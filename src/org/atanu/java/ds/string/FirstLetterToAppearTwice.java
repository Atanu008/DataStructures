package org.atanu.java.ds.string;

//https://leetcode.com/problems/first-letter-to-appear-twice/description
//Leetcode 2351

import java.util.HashMap;
import java.util.Map;

public class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                return ch;
            }
            map.put(ch, i);
        }
        return '0'; // Default return .This wont happen I guess as "s" has at least one repeated letter.
    }

    public static void main(String[] args) {
        String s = "abccbaacz";
        char ch = new FirstLetterToAppearTwice().repeatedCharacter(s);
        System.out.println(ch);
        //Explanation:
        //The letter 'a' appears on the indexes 0, 5 and 6.
        //The letter 'b' appears on the indexes 1 and 4.
        //The letter 'c' appears on the indexes 2, 3 and 7.
        //The letter 'z' appears on the index 8.
        //The letter 'c' is the first letter to appear twice, because out of all the letters the index of its second occurrence is the smallest.
    }
}
