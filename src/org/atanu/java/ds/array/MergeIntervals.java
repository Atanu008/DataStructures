package org.atanu.java.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/
//LeetCode 56
//Educative Explanation is good
//Same As
//https://leetcode.com/problems/non-overlapping-intervals/
//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> retVal = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            //Overlapping . just update the End . Take the max End
            if(currentStart <= end){
                end = Math.max(end, currentEnd);
            }
            else{//Non Overlapping . add the previous intervals to the result . Update start and end
                retVal.add(new int[]{start, end});
                start = currentStart;
                end = currentEnd;
            }
        }

        //In case of Over lapping and Non Over lapping we are not inserting the last one
        //After loop is over insert the last one. start and first will be updated
        retVal.add(new int[]{start, end});

        return retVal.toArray(new int[retVal.size()][]);
    }

    //Same as before just different way of implementation
    public int[][] mergeV2(int[][] intervals) {

        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        List<int[]> retVal = new ArrayList<>();

        int[] newInterval = intervals[0];
        //Insert the Interval in the result . In first solution we added it after loop
        retVal.add(newInterval);

        for(int[] interval : intervals){

            if(interval[0] <= newInterval[1]){

                newInterval[1] = Math.max(newInterval[1],interval[1] );
            }
            else{
                retVal.add(interval);
                newInterval = interval;
            }
        }

        return retVal.toArray(new int[retVal.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        int[][] result = mergeIntervals.merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }
}
