package org.atanu.java.ds.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//LeetCode 1239
//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

//Input: arr = ["un","iq","ue"]
//Output: 4
//Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
//Maximum length is 4.
public class MaxLengthConcatenatedStringUniqueChar {

    int max = 0;
    public int maxLength(List<String> arr) {
        backtrack(arr, 0, "");
        return max;
    }

    private void backtrack(List<String> arr, int index, String current){
        //Exit for Non Unique String
        if(!isSafe(current)){
            return;
        }
        //Update Max for Unique String
        max = Math.max(max, current.length());
        System.out.println(current);
        //Exit when th lenght is reached. Redundant may be.
        if(index == arr.size()){
            return;
        }

        for(int i = index; i < arr.size(); i++){
            String s = arr.get(i);
            //Backtrack. As it is a netring no need to ad and remove(choose and unchoose)
            //Once the string is back it will have the same value .
            backtrack(arr, i+1, current+s);
        }
    }

    private boolean isSafe(String s){
        Set<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()){
            if(set.contains(ch)){
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        List arr = Arrays.asList(new String[]{"un", "iq", "ue"});
        MaxLengthConcatenatedStringUniqueChar stringUniqueChar = new MaxLengthConcatenatedStringUniqueChar();
        int maxLength = stringUniqueChar.maxLength(arr);
        System.out.println(maxLength);

    }
}
