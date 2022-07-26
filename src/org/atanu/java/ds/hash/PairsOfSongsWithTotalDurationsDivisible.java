package org.atanu.java.ds.hash;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
//LeetCode 1010

//Video : https://www.youtube.com/watch?v=UcCBdYQU2cU&t=619s
public class PairsOfSongsWithTotalDurationsDivisible {

    public int numPairsDivisibleBy60(int[] time) {

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int t : time){

            int reminder = t % 60;

            int otherTime = reminder == 0 ? 0 : 60 - reminder;

            count += map.getOrDefault(otherTime, 0);

            map.put(reminder, map.getOrDefault(reminder, 0) + 1);
        }

        return count;
    }

    public int numPairsDivisibleBy60V2(int[] time) {

        int[] reminderFreq = new int[60];
        int count = 0;
        for(int t : time){

            int reminder = t % 60;

            int otherTime = reminder == 0 ? 0 : 60 - reminder;

            count += reminderFreq[otherTime];

            reminderFreq[reminder]++;
        }

        return count;
    }
}
