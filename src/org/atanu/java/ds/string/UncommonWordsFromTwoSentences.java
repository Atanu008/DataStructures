package org.atanu.java.ds.string;

import java.util.*;

//https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
//Leetcoe 884
public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordFreq = new HashMap<>();

        for(String word : s1.split(" ")){
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        for(String word : s2.split(" ")){
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : wordFreq.entrySet()){
            if(entry.getValue() == 1){
                result.add(entry.getKey());
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        String s1 = "this apple is sweet", s2 = "this apple is sour";
        String[] result = new UncommonWordsFromTwoSentences().uncommonFromSentences(s1, s2);
        System.out.println(Arrays.toString(result));
    }
}
