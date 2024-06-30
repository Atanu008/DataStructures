package org.bgd.java.ds.intervals;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 * 253. Meeting Rooms II
 *
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 */
public class MeetingRoomsII {

    /**
     * Greedy solution
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        int i = 0;
        for (int[] interval : intervals) {
            starts[i] = interval[0];
            ends[i] = interval[1];
            i++;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int start_pointer = 0, end_pointer = 0;
        int used = 0;

        while (start_pointer < intervals.length) {
            if (starts[start_pointer] >= ends[end_pointer]) {
                used--;
                end_pointer++;
            }

            used += 1;
            start_pointer++;
        }
        return used;
    }

    /**
     *
     */

}
