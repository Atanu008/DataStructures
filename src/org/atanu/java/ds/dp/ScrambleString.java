package org.atanu.java.ds.dp;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/scramble-string/description/
// Leetcode 87

// Video : https://www.youtube.com/watch?v=MDmZm_aVDF8
public class ScrambleString {
    Map<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        int n = s1.length();
        if(s1.length() != s2.length()){
            return false;
        }

        // If we come here then s1 and s2 hase to be same length
        // now if its a single charater
        // - both characters are same then return true (Eg s1 = a , s2 = a) :)
        // - both character are different return false (Eg s1 = k , s2 = z)
        if(s1.length() == 1){
            return s1.equals(s2);
        }
        //Return true if they are equal
        if(s1.equals(s2)){
            return true;
        }

        String key = s1 + ":" + s2;
        // Cache
        if(map.containsKey(key)){
            return map.get(key);
        }

        // Cut the String in n - 1
        for(int i = 1; i < n; i++){
            // Dont swap
            // left part of first and second string &&  right part of first and second string;
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))){
                map.put(key, true);
                return true; // early exit , if can form scramble string
            }
            // Try Swap
            // ex of withswap: gr|eat rge|at
            // here we compare "gr" with "at" and "eat" with "rge"
            // left part of first and right part of second && right part of first and left part of second
            if(isScramble(s1.substring(0, i), s2.substring(n-i)) && isScramble(s1.substring(i), s2.substring(0,n-i))){
                map.put(key, true);
                return true;
            }

        }
        // After all the breaking if we can not find the solution return false.
        map.put(key, false);
        return map.get(key);
    }
}
