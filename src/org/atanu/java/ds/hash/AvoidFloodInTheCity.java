package org.atanu.java.ds.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//https://leetcode.com/problems/avoid-flood-in-the-city/description/
//Leetcode 1488

//video : Can refer https://www.youtube.com/watch?v=Q_90h1fxCSM
public class AvoidFloodInTheCity {

    public int[] avoidFlood(int[] rains) {
        // Lake number -> day on which it became full.
        Map<Integer, Integer> lastRains = new HashMap<>();
        // Set of available days that can be used for drying a full lake.
        TreeSet<Integer> dryDays = new TreeSet<>();
        int[] ans = new int[rains.length];//Final Answar

        for(int i = 0; i < rains.length; i++){
            int rain = rains[i];
            if(rain == 0){
                // This day can be used as a day to dry some lake.
                // We don't know which lake to prioritize for drying yet.
                dryDays.add(i);
                // Any number would be ok. This will get overwritten eventually.
                // If it doesn't get overwritten, its totally ok to dry a lake
                // irrespective of whether it is full or empty.
                ans[i] = 1;
            }
            else{
                ans[i] = -1; // As the problem statement expects.
                Integer lastRainDay = lastRains.get(rain);
                if(lastRainDay != null){
                    //We have come here means there is lastRainDay that means the lake is already full
                    //Now its is rainiing on teh same lake again . so we need to dry this lake
                    // We must dry this lake before it rains in this lake.
                    // So find a day in "drydays" to dry this lake. Obviously, that day must be
                    // a day that is after the day on which the lake was full.
                    // i.e. if the lake got full on 7th day, we must find a dry day that is
                    // greater than 7.
                    Integer drayDayAfterLastRainDay = dryDays.ceiling(lastRainDay);
                    System.out.println("drayDayAfterLastRainDay "+ drayDayAfterLastRainDay);

                    if(drayDayAfterLastRainDay == null){
                        // If there is no available dry day to dry the lake,
                        // flooding is inevitable.
                        //Can not prevent flood
                        return new int[0];
                    }
                    else{
                        ans[drayDayAfterLastRainDay] = rain; // Overwrite the "1" and dry "lake"-th lake instead.
                        // We dried "lake"-th lake on "dryday", and we can't use
                        // the same day to dry any other lake, so remove the day
                        // from the set of available drydays.
                        dryDays.remove(drayDayAfterLastRainDay);
                    }
                }
                lastRains.put(rain, i); // Update that the "lake" became full on "i"-th day.
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        AvoidFloodInTheCity avoidFloodInTheCity = new AvoidFloodInTheCity();
        int[] rains = {1,2,0,0,2,1};
        int[] result = avoidFloodInTheCity.avoidFlood(rains);
        //Explanation: After the first day full lakes are [1]
        //After the second day full lakes are [1,2]
        //After the third day, we dry lake 2. Full lakes are [1]
        //After the fourth day, we dry lake 1. There is no full lakes.
        //After the fifth day, full lakes are [2].
        //After the sixth day, full lakes are [1,2].
        //It is easy that this scenario is flood-free. [-1,-1,1,2,-1,-1] is another acceptable scenario.
        System.out.println(Arrays.toString(result));
    }
}
