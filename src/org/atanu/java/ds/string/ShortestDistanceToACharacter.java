package org.atanu.java.ds.string;

//https://leetcode.com/problems/shortest-distance-to-a-character/description/
//Leetcode 821
public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        //Distance From left 'c'
        int prev = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == c){
                ans[i] = 0;
                prev = i;
            }
            else{
                ans[i] = Math.abs(i - prev);
            }
        }

        prev = Integer.MAX_VALUE;
        //Distance from right 'c'
        //As we alreday have distace from left c
        //Take the minimum
        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == c){
                prev = i;
            }
            else{
                ans[i] = Math.min(ans[i], Math.abs(i - prev));
            }
        }

        return ans;
    }
}
