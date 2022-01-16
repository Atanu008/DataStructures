package org.atanu.java.ds.array;

import java.util.Arrays;

//https://leetcode.com/problems/non-overlapping-intervals/
//LeetCode 435
//Same idea as https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class NonOverlappingIntervals {

    //This looks intuitive to me
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); //Sort by end Time
        int overLapCount = 0;
        int prevEnd = intervals[0][1]; // Will have the smallest end as it is sorted by end time

        for(int i = 1; i < intervals.length; i++){

            //Overlapping
            //In case of Overlapping count it . as these needs to be deleted
            if(intervals[i][0] < prevEnd){
                overLapCount++;
            }
            else{ //Not Overlapping . Upadte the previous End Pointer here . this will base for next compare
                prevEnd = intervals[i][1];
            }
        }

        return overLapCount;
    }

    //Kind of same idea
    //But here non over lapping takes the precedence as greedy
    public int eraseOverlapIntervalsV2(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[1] - b[1]); //Sort by end Time
        int nonOverLapCount = 1;
        int prevEnd = intervals[0][1]; // Will have the smallest end as it is sorted by end time

        for(int i = 1; i < intervals.length; i++){

            //Non Overlapping
            //Not Overlapping . Upadte the previous End Pointer here . this will base for next compare
            if(intervals[i][0] >= prevEnd){
                nonOverLapCount++;
                prevEnd = intervals[i][1];
            }
        }

        return intervals.length - nonOverLapCount;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        //Output: 1
        //Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
        System.out.println("Non Over lapping Intervals "+ nonOverlappingIntervals.eraseOverlapIntervals(intervals));
        System.out.println("Non Over lapping Intervals "+ nonOverlappingIntervals.eraseOverlapIntervalsV2(intervals));
    }
}
