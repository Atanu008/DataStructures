package org.atanu.java.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/meeting-rooms-ii/
//LeetCode 253
public class MeetingRoomII {

    //Sort the given meetings by their start time.
    //Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
    //For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
    //If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
    //If not, then we allocate a new room and add it to the heap.
    //After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.
    public int minMeetingRooms(int[][] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }
        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //Min Heap . will strore the End Times
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Add the first End meeting
        pq.offer(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++){
            // If the room due to free up the earliest is free, assign that room to this meeting.
            if(intervals[i][0] >= pq.peek()){
                pq.poll();
            }
            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            pq.offer(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return pq.size();
    }

    public static void main(String[] args) {
        MeetingRoomII meetingRoomII = new MeetingRoomII();
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println("Meeting Rooms Needed is "+meetingRoomII.minMeetingRooms(intervals) );
    }
}
