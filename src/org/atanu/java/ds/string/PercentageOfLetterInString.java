package org.atanu.java.ds.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/percentage-of-letter-in-string/description/
//Leetcode 2278

public class PercentageOfLetterInString {

    public int percentageLetter(String s, char letter) {
        int letterCount = 0;
        for(char ch : s.toCharArray()){
            if(ch == letter){
                letterCount++;
            }
        }
        if(letterCount == 0){
            return 0;
        }

        return  (letterCount * 100) / s.length();
    }

    //This is bit overkill as we need to know for only one letter
    public int percentageLetter_v2(String s, char letter) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        Integer a = freq.get(letter);
        System.out.println("a "+ a);
        if(a == null){
            return 0;
        }
        //System.out.println(a);
        return  (a * 100) / s.length();
    }

    public static void main(String[] args) {
        String s = "foobar";
        char letter = 'o';
        int percentage = new PercentageOfLetterInString().percentageLetter(s, letter);
        System.out.println(percentage);
    }
}
