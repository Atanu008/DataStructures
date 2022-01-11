package org.atanu.java.ds.design;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/my-calendar-ii/
//LeetCode 731
public class MyCalendarII {

    private static class Meeting{
        int start;
        int end;

        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

    }

    private List<Meeting> events;
    private List<Meeting> doubleBooking;

    public MyCalendarII() {
        events = new ArrayList<>();
        doubleBooking = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        for(Meeting meeting : doubleBooking){
            //Tripple booking happeing
            if(start < meeting.end && end > meeting.start){
                return false;
            }

        }

        for(Meeting meeting : events){
            //Double booking happeing
            //Update Double Booking
            if(start < meeting.end && end > meeting.start){

                int overlappedStart = Math.max(start,meeting.start);
                int overlappedEnd = Math.min(end,meeting.end);
                Meeting doubleEntry = new Meeting(overlappedStart, overlappedEnd);

                doubleBooking.add(doubleEntry);
            }
        }
        //add every entry to event list
        events.add(new Meeting(start, end));

        return true;
    }
}
