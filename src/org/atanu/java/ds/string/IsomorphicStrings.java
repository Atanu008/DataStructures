package org.atanu.java.ds.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/isomorphic-strings/
//LeetCode 205
//Video : https://www.youtube.com/watch?v=GixTBEkxudg
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> mapSToT = new HashMap<>();
        Map<Character, Character> mapTToS = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(mapSToT.containsKey(sChar)){
                if(mapSToT.get(sChar) != tChar){
                    return false;
                }
            }

            if(mapTToS.containsKey(tChar)){
                if(mapTToS.get(tChar) != sChar){
                    return false;
                }
            }

            mapSToT.put(sChar, tChar);
            mapTToS.put(tChar, sChar);
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "egg", t = "add";
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic(s,t));
        s = "foo"; t = "bar";
        System.out.println(isomorphicStrings.isIsomorphic(s,t));
    }

}
