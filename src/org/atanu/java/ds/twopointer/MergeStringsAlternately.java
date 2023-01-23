package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/merge-strings-alternately/description/
//LeetCode 1768
public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {

        int index = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i < word1.length() && j < word2.length()){
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        //Remaining word1
        while(i < word1.length()){
            sb.append(word1.charAt(i++));
        }
        //Remaining word2
        while(j < word2.length()){
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        MergeStringsAlternately mergeStringsAlternately = new MergeStringsAlternately();
        String word1 = "ab", word2 = "pqrs";
        String mergedString = mergeStringsAlternately.mergeAlternately(word1, word2);
        System.out.println(mergedString);
    }
}
