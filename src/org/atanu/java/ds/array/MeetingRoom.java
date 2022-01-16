package org.atanu.java.ds.array;

import java.util.Arrays;

//https://leetcode.com/problems/meeting-rooms/
//LeetCode 252
public class MeetingRoom {

    //The idea here is to sort the meetings by starting time. Then, go through the meetings one by one and make sure that each meeting ends before the next one starts.
    public boolean canAttendMeetings(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        MeetingRoom meetingRoom = new MeetingRoom();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};

        System.out.println("All Meeting can be attended " + meetingRoom.canAttendMeetings(intervals));

        intervals = new int[][] {{7, 10}, {2, 4}};
        System.out.println("All Meeting can be attended " + meetingRoom.canAttendMeetings(intervals));

    }

}
