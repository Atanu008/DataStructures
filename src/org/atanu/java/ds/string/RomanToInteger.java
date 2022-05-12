package org.atanu.java.ds.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/roman-to-integer/
//LeetCode 13
//Video : https://www.youtube.com/watch?v=3jdxYj3DD98
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;
        for(int i = 0; i < s.length(); i++){
            if(i < s.length() -1 && roman.get(s.charAt(i)) < roman.get(s.charAt(i+1))){
                result -= roman.get(s.charAt(i));
            }
            else {
                result += roman.get(s.charAt(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        String s = "III";
        //Explanation: III = 3.
        System.out.println(romanToInteger.romanToInt(s));

        s = "LVIII";
        //Explanation: L = 50, V= 5, III = 3.
        System.out.println(romanToInteger.romanToInt(s));

        s = "MCMXCIV";
        //Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
        System.out.println(romanToInteger.romanToInt(s));
    }
}
