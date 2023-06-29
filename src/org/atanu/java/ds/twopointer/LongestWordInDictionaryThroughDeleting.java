package org.atanu.java.ds.twopointer;

// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
// Leetcode 524

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String source, List<String> dictionary) {

        // Sort by their size in Desceding order. longest word first
        // If equal sort smallest lexicographical order
        Collections.sort(dictionary,
                (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));

        for(String target : dictionary){
            if(isSubsequence(source, target)){
                return target;
            }
        }

        return "";
    }

    private boolean isSubsequence(String source, String target){

        int i = 0;
        int j = 0;

        while(i < source.length() && j < target.length()){

            if(source.charAt(i) == target.charAt(j)){
                j++;
            }

            i++;
        }
        return j == target.length();
    }

    public static void main(String[] args) {
        LongestWordInDictionaryThroughDeleting longestWordInDictionaryThroughDeleting = new LongestWordInDictionaryThroughDeleting();
        String source = "abpcplea";
        List<String> dict = Arrays.asList("ale","apple","monkey","plea");
        String longestWord = longestWordInDictionaryThroughDeleting.findLongestWord(source, dict);
        System.out.println(longestWord);
    }
}
