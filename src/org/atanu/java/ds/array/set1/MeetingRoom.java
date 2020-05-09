package org.atanu.java.ds.array.set1;

import java.util.Arrays;

public class MeetingRoom {


	public static boolean canAttendMeetings(Interval[] intervals) {

		int n = intervals.length;

		int[] starts = new int[n];
		int[] ends = new int[n];

		for(int i = 0; i < n ; i++) {

			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}

		Arrays.sort(starts);
		Arrays.sort(ends);

		for(int i = 0; i < n -1; i++) {

			//Check if The next meeting start time is less than the current meeting
			//If Yes then that meeting can not be attended
			if(ends[i] > starts[i+1]) {
				return false;
			}
		}

		return true;
	}
	public static void main(String[] args) {

		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0, 30);
		intervals[1] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);
		
		Interval[] intervals1 = new Interval[2];
		intervals1[0] = new Interval(7, 10);
		intervals1[1] = new Interval(2, 4);

		System.out.println("All Meeting can be attended "+ canAttendMeetings(intervals));
		
		System.out.println("All Meeting can be attended "+ canAttendMeetings(intervals1));

	}

}
