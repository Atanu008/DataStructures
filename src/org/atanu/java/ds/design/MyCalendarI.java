package org.atanu.java.ds.design;

import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/my-calendar-i/
//LeetCode 729
public class MyCalendarI {

    TreeMap<Integer, Integer> treeMap;

    public MyCalendarI() {
        treeMap  = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        Map.Entry<Integer,Integer> previousMeeting = treeMap.floorEntry(start);
        Map.Entry<Integer,Integer> nextMeeting = treeMap.ceilingEntry(start);

        if(previousMeeting != null && start < previousMeeting.getValue()){
            return false;
        }

        if(nextMeeting != null && end > nextMeeting.getKey()){
            return false;
        }

        treeMap.put(start,end);

        return true;
    }
}
