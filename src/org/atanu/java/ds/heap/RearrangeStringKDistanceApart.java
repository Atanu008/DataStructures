package org.atanu.java.ds.heap;

import java.util.*;

//https://leetcode.com/problems/rearrange-string-k-distance-apart/
//Leetcode 358
//https://www.educative.io/courses/grokking-the-coding-interview/qA7n6820GjG
//The time complexity of the above algorithm is O(N*logN)O(N∗logN) where ‘N’ is the number of characters in the input string
public class RearrangeStringKDistanceApart {

    //Similar To ReorganizeString, since we were inserting a character back in the heap in the next iteration,
    //in this problem, we will re-insert the character after ‘K’ iterations.
    //We can keep track of previous characters in a queue to insert them back in the heap after ‘K’ iterations.
    public String rearrangeString(String s, int k) {
        //Base case. Rearrange is not possible
        if(k <= 1) {
            return s;
        }

        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        //Track Char Frequencies
        for(char ch : s.toCharArray()) {
            characterFrequencyMap.put(ch, characterFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        // add all characters to the max heap
        maxHeap.addAll(characterFrequencyMap.entrySet());

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder reArrangedString = new StringBuilder();
        while(!maxHeap.isEmpty()) {

            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            // append the current character to the result string and decrement its count
            reArrangedString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            queue.offer(currentEntry);

            if(queue.size() == k) {
                Map.Entry<Character, Integer> kthPreviousEntry = queue.poll();
                if(kthPreviousEntry.getValue() > 0) {
                    maxHeap.offer(kthPreviousEntry);//Making it available for append again
                }
            }
        }

        // if we were successful in appending all the characters to the result string, return it
        return reArrangedString.length() == s.length() ? reArrangedString.toString() : "";
    }

    public static void main(String[] args) {
        RearrangeStringKDistanceApart rearrangeStringKDistanceApart = new RearrangeStringKDistanceApart();
        System.out.println("Reorganized string: " +
                rearrangeStringKDistanceApart.rearrangeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                rearrangeStringKDistanceApart.rearrangeString("Programming", 3));
        System.out.println("Reorganized string: " +
                rearrangeStringKDistanceApart.rearrangeString("aab", 2));
        System.out.println("Reorganized string: " +
                rearrangeStringKDistanceApart.rearrangeString("aappa", 3));
        System.out.println("Reorganized string: " +
                rearrangeStringKDistanceApart.rearrangeString("aabbcc", 3));
        System.out.println("Reorganized string: " +
                rearrangeStringKDistanceApart.rearrangeString("aaabc", 3));
        System.out.println("Reorganized string: " +
                rearrangeStringKDistanceApart.rearrangeString("aaaaaadbbccbc", 2));
    }
}
