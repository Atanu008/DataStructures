package org.atanu.java.ds.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/reorganize-string/
//LeetCode 767
//https://www.educative.io/courses/grokking-the-coding-interview/xV7wx4o8ymB
//The time complexity of the above algorithm is O(N*logN)O(N∗logN) where ‘N’ is the number of characters in the input string.
public class ReorganizeString {
    //in each step, we should append one occurrence of the highest frequency character to the output string.
    //We will not put this character back in the heap to ensure that no two same characters are adjacent to each other.
    //In the next step,
    //we should process the next most frequent character from the heap in the same way and then, at the end of this step,
    //insert the character from the previous step back to the heap after decrementing its frequency
    public String reorganizeString(String s) {

        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        //Track Char Frequencies
        for(char ch : s.toCharArray()) {
            characterFrequencyMap.put(ch, characterFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        // add all characters to the max heap
        maxHeap.addAll(characterFrequencyMap.entrySet());

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder reArrangedString = new StringBuilder();
        while(!maxHeap.isEmpty()) {

            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            // append the current character to the result string and decrement its count
            reArrangedString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            // add the previous entry back in the heap if its frequency is greater than zero
            if(previousEntry != null && previousEntry.getValue() > 0) {
                maxHeap.offer(previousEntry);
            }
            //Update Previous
            previousEntry = currentEntry;
        }

        // if we were successful in appending all the characters to the result string, return it
        return reArrangedString.length() == s.length() ? reArrangedString.toString() : "";
    }

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println("Rearranged string: " + reorganizeString.reorganizeString("aappp"));
        System.out.println("Rearranged string: " + reorganizeString.reorganizeString("Programming"));
        System.out.println("Rearranged string: " + reorganizeString.reorganizeString("aapa"));
        System.out.println("Rearranged string: " + reorganizeString.reorganizeString("aaab"));
        System.out.println("Rearranged string: " + reorganizeString.reorganizeString("aab"));
    }
}
