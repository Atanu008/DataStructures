package org.atanu.java.ds.array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/find-right-interval/
//LeetCode 436
public class FindRightInterval {

    //Brute Force
    //O(N2)
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){

            int nextMinStart = Integer.MAX_VALUE;
            int minIdex = -1;
            for(int j = 0; j < intervals.length; j++){
                if(intervals[j][0] >= intervals[i][1] && intervals[j][0] < nextMinStart){
                    nextMinStart = intervals[j][0];
                    minIdex = j;
                }

            }
            result[i] = minIdex;
        }
        return result;
    }

    // In our case, we store the data such that the start point of an interval acts as the
    //Key
    //Key and the index corresponding to the interval acts as the value, since we are concerned with data sorted based on the start points, as discussed in previous approaches. Every element of the
    //intervals
    //intervals array is stored in the TreeMap
    //Now, we choose each element of the intervals
    //intervals array and make use of a function TreeMap.ceilingEntry(end_point) to obtain the element in the TreeMap with itsKey
    //Key just larger than the
    //end_point
    //end_point of the currently chosen interval. The function ceilingEntry(Key) returns the element just with its
    //Key
    //Key larger than the Key(passed as the argument) from amongst the elements of the TreeMap and returns null if no such element exists.

    // [[3,4],[2,3],[1,2]] -- if we query for [1,2] End Time(2) - we have two entry [3,4] and [2,3]
    //Tree map is sorted using start time . It will return [2,3] as ceiling entry
    public int[] findRightIntervalV2(int[][] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for(int i = 0; i < intervals.length; i++){
            treeMap.put(intervals[i][0], i);
        }

        for(int i = 0; i < intervals.length; i++){
            Map.Entry<Integer, Integer> ceilingEntry = treeMap.ceilingEntry(intervals[i][1]);
            int rightIndex = ceilingEntry == null ? -1 : ceilingEntry.getValue();
            result[i] = rightIndex;
        }

        return result;
    }

    public static void main(String[] args) {
        FindRightInterval findRightInterval = new FindRightInterval();
        int[][] intervals = {{3,4},{2,3},{1,2}};
        int[] result = findRightInterval.findRightInterval(intervals);
        //Output: [-1,0,1]
        //Explanation: There is no right interval for [3,4].
        //The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
        //The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
        System.out.println(Arrays.toString(result));
    }
}
