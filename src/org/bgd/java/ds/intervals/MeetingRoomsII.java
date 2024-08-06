package org.bgd.java.ds.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/meeting-rooms-ii/">...</a>
 *
 * 253. Meeting Rooms II
 *
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
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
     * Heap Based Solution. Keep track of the last meeting time with a heap
     */
    public int minMeetingRoomsWithHeap(int[][] intervals) {
        Queue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]); // sorted by start

        pq.offer(intervals[0][1]); // add ending time of first meeting

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.offer(interval[1]);
        }
        return pq.size();
    }

}
