package org.atanu.java.ds.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/maximum-number-of-balloons/
//LeetCode 1189
public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char ch : text.toCharArray()) {
            if(ch == 'b' || ch == 'a' || ch == 'n'|| ch == 'l' || ch == 'o') {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) +1);
            }
        }

        //If all the char from baloon is not present then its not possible to from 'baoon'
        if(frequencyMap.size() < 5){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        //Take the Min , that will from the whole word
        for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()){
            min = Math.min(min, entry.getValue());
            if(entry.getKey() == 'l' || entry.getKey() == 'o'){
                min = Math.min(min, entry.getValue()/2);
            }
        }

        return min;

    }
}
