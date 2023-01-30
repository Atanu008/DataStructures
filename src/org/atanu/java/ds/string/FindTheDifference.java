package org.atanu.java.ds.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/find-the-difference/description/
//Leetcode 389
public class FindTheDifference {
    public char findTheDifference(String s, String t) {

        Map<Character, Integer> freq = new HashMap<>();
        char extraChar = '\0';

        // Prepare a counter for string s.
        // This hash map holds the characters as keys and respective frequency as value.
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Iterate through string t and find the character which is not in s.
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            int count = freq.getOrDefault(ch, 0);

            if(count == 0){
                extraChar = ch;
                break;
            }
            else{
                // Once a match is found we reduce frequency left.
                // This eliminates the possibility of a false match later.
                freq.put(ch, count - 1);
            }
        }

        return extraChar;
    }

    public char findTheDifference_v2(String s, String t) {
        // Sort both the strings
        char[] sortedS = s.toCharArray();
        char[] sortedT = t.toCharArray(); // Length of sortedT will always be greater

        Arrays.sort(sortedS);
        Arrays.sort(sortedT);

        // Character by character comparison
        int i = 0;
        while(i < s.length()){
            if(sortedS[i] != sortedT[i]){
                return sortedT[i]; //return if not matching
            }
            i++;
        }

        return sortedT[i];
    }

    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        char ch= new FindTheDifference().findTheDifference(s, t);
        char ch1 = new FindTheDifference().findTheDifference_v2(s, t);
        //Explanation: 'e' is the letter that was added.
        System.out.println(ch);
        System.out.println(ch1);
    }
}
