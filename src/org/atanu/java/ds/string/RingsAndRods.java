package org.atanu.java.ds.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/rings-and-rods/
//LeetCode 2103
public class RingsAndRods {

    public int countPoints(String rings) {

        Map<Integer, Set<Character>> rodRingMap = new HashMap<>();

        int i = 0;
        while(i < rings.length()) {
            char ring = rings.charAt(i++);
            int rod = rings.charAt(i++) - '0';
            rodRingMap.putIfAbsent(rod, new HashSet<>());
            rodRingMap.get(rod).add(ring);
        }

        int rodWithAllThreeColor = 0;
        for(Map.Entry<Integer, Set<Character>> entry: rodRingMap.entrySet()) {
            if(entry.getValue().size() == 3){
                rodWithAllThreeColor++;
            }
        }

        return rodWithAllThreeColor;
    }
}
