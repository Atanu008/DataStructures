package org.atanu.java.ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/minimum-time-difference/description/
//LeetCode 539
//Video : https://www.youtube.com/watch?v=-o_YDXNfRUY
public class MinimumTimeDifference {

    //In a day total 24*60 minutes
    //Make an array of that length , when a time is present make it true
    //Then compare the time differences
    //Only one edge case is we need to check the differnce between the firstTime and lastTime
    //as the time array is circular
    // ....20....67.....1200......Last(24*60)
    // suppose 20 is the first and 1200 is teh last time
    // So the time difference would be (1440 - lastTime + firstTime)
    public int findMinDifference(List<String> timePoints) {
        int minutesInADay = 24*60;
        boolean time[] = new boolean[minutesInADay];

        for(String t : timePoints){
            String[] timeArray = t.split(":");
            int hour = Integer.parseInt(timeArray[0]);
            int minute = Integer.parseInt(timeArray[1]);

            int minutes = (hour * 60) + minute;
            //If the same time present then the difference would be zero only;
            if(time[minutes]){
                return 0;
            }

            time[minutes] = true; // make that time true
        }

        int prevTime = -1;
        int currentTime = -1;
        int firstTime = -1;
        int minDifference = Integer.MAX_VALUE;

        for(int i = 0; i < time.length; i++){
            if(time[i]){
                if(prevTime == -1){
                    firstTime = i;
                    prevTime = i;
                }
                else{
                    currentTime = i;
                    minDifference = Math.min(minDifference, currentTime - prevTime);
                    prevTime = currentTime;
                }
            }
        }
        return minDifference = Math.min(minDifference, minutesInADay - currentTime + firstTime);
    }

    public static void main(String[] args) {
        MinimumTimeDifference minimumTimeDifference = new MinimumTimeDifference();
        List<String> timePoints = new ArrayList<>(Arrays.asList("23:59","00:00"));
        int timeDifference = minimumTimeDifference.findMinDifference(timePoints);
        System.out.println(timeDifference);

        timePoints = new ArrayList<>(Arrays.asList("00:00","23:59","00:00"));
        timeDifference = minimumTimeDifference.findMinDifference(timePoints);
        System.out.println(timeDifference);
    }
}
