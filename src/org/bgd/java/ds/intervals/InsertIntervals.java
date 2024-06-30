package org.bgd.java.ds.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/insert-interval/">...</a>
 *
 *You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int n = intervals.length;
        int i = 0;

        while (i < n) {
            if (intervals[i][0] < newInterval[0]) {
                result.add(intervals[i]);
                i++;
            } else {
                break;
            }

        }
        if (result.isEmpty() || result.getLast()[1] < newInterval[0]) {
            result.add(newInterval);
        } else {
            result.getLast()[1] = Math.max(result.getLast()[1], newInterval[1]);
        }

        while (i < n) {
            if (result.getLast()[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
            }
            i++;
        }
        return result.toArray(new int[0][0]);
    }
}
