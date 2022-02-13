package org.atanu.java.ds.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/sort-characters-by-frequency/
//LeetCode 451
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        // find the frequency of each character
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for (char chr : s.toCharArray()) {
            characterFrequencyMap.put(chr, characterFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
                (a, b) -> b.getValue() - a.getValue());

        // add all characters to the max heap
        maxHeap.addAll(characterFrequencyMap.entrySet());

        // build a string, appending the most occurring characters first
        StringBuilder sortedString = new StringBuilder(s.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++)
                sortedString.append(entry.getKey());
        }
        return sortedString.toString();
    }

    public String frequencySortV2(String s) {

        Map<Character, Integer> map = new HashMap<>();
        //Sort alphabetically if equal frequency
        PriorityQueue<Map.Entry<Character,Integer>> pQueue = new PriorityQueue<>(
                (a,b) -> {
                    if(a.getValue() == b.getValue()){
                        return a.getKey().compareTo(b.getKey());
                    }
                    else return b.getValue() - a.getValue();
                }
        );

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            pQueue.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while(!pQueue.isEmpty()){
            Map.Entry<Character,Integer> en = pQueue.poll();
            for(int i = 0; i < en.getValue(); i++){
                sb.append(en.getKey());
            }
        }
        return sb.toString();
    }
}
