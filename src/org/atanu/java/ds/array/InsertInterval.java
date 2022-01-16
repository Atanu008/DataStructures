package org.atanu.java.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/insert-interval/
//LeetCode 57
public class InsertInterval {

    //Skip all intervals which end before the start of the new interval, i.e., skip all intervals with the following condition:
    //intervals[i].end < newInterval.start
    //
    //Let’s call the last interval ‘b’ that does not satisfy the above condition. If ‘b’ overlaps with the new interval (a) (i.e. b.start <= a.end), we need to merge them into a new interval ‘c’:
    //c.start = min(a.start, b.start)
    //c.end = max(a.end, b.end)
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> retVal = new ArrayList<>();

        int i = 0;

        // skip (and add to output) all intervals that come before the 'newInterval'
        while(i < intervals.length && newInterval[0] > intervals[i][1]){
            retVal.add(intervals[i]);
            i++;
        }

        // here either i = intervals.length OR newInterval[0] <= intervals[i][1]
        // we need to check another condition to check wheter this over lapping
        // i.e intervals[i][0] <= newInterval[1]
        // Otherwiese this new Interval comes before any of the intervals in the list
        // merge all intervals that overlap with 'newInterval'
        while(i < intervals.length && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // insert the newInterval
        retVal.add(newInterval);

        while(i < intervals.length){
            retVal.add(intervals[i]);
            i++;
        }
        // add all the remaining intervals to the output
        return retVal.toArray(new int[retVal.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] result = insertInterval.insert(intervals, newInterval);
        //Output: [[1,5],[6,9]]
        System.out.println(Arrays.deepToString(result));

        int[][] intervals1 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval1 = {4,8};
        result = insertInterval.insert(intervals1, newInterval1);
        //Output: [[1,2],[3,10],[12,16]]
        //Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
        System.out.println(Arrays.deepToString(result));
    }
}
