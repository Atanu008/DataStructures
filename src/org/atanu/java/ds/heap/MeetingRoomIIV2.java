package org.atanu.java.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomIIV2 {

    public int minMeetingRooms(Interval[] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Interval> queue = new PriorityQueue<>((a, b) -> a.end - b.end);

        queue.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            Interval current = intervals[i];
            Interval earliest = queue.poll();

            //If Current starting time is greater then No need of extra meeting Room
            if (current.start >= earliest.end) {
                //Update earliest
                earliest.end = Math.max(current.end, earliest.end);
            }
            // We need extra meeting if the next meeting starting before teh earliest ends
            else {
                queue.offer(current);
            }

            //Put back the earliest in the Queue
            queue.offer(earliest);
        }

        return queue.size();

    }

    public static void main(String[] args) {
        MeetingRoomIIV2 meetingRoomII = new MeetingRoomIIV2();
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 20);

        Interval[] intervals1 = new Interval[2];
        intervals1[0] = new Interval(7, 10);
        intervals1[1] = new Interval(2, 4);

        System.out.println("Minimum No of Meeting Room needed " + meetingRoomII.minMeetingRooms(intervals));

        System.out.println("Minimum No of Meeting Room needed " + meetingRoomII.minMeetingRooms(intervals1));

    }

}
