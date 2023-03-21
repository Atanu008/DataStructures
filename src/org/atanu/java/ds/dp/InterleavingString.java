package org.atanu.java.ds.dp;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/interleaving-string/description/
//Leetcode 97

//https://www.udemy.com/course/dynamic-programming-master-course-coding-minutes/learn/lecture/31162140#overview
//https://www.udemy.com/course/dynamic-programming-master-course-coding-minutes/learn/lecture/31162144#overview

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {

        Map<String, Boolean> dp = new HashMap<>();
        return dp(s1, s2, s3, 0, 0, 0, dp);
    }

    private boolean dp(String s1, String s2, String s3, int s1Index, int s2Index, int s3Index, Map<String, Boolean> dp){

        // If we have reached the end of all the strings
        if(s1Index == s1.length() && s2Index == s2.length() && s3Index == s3.length()){
            return true;
        }

        // If we have reached the end of 's3' but 's1' or 's2' still has some characters left
        if(s3Index == s3.length()){
            return false;
        }

        String key = s1Index + "$" + s2Index + "$" + s3Index;

        if(dp.containsKey(key)){
            return dp.get(key);
        }

        boolean checkForS1 = false;
        boolean checkForS2 = false;
        // If s1 index and s3 index are pointing to the same character
        if(s1Index < s1.length() && s1.charAt(s1Index) == s3.charAt(s3Index)){
            checkForS1 = dp(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1, dp);
        }

        // If s2 index and s3 index are pointing to the same character
        if(s2Index < s2.length() && s2.charAt(s2Index) == s3.charAt(s3Index)){
            checkForS2 = dp(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1, dp);
        }

        // If either of these conditions is true(one of the recursion leads to a solution),
        // it means that s3 was indeed a product of
        // interleaving s1 and s2.
        dp.put(key, (checkForS1 | checkForS2));
        return dp.get(key);
    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        InterleavingString interleavingString = new InterleavingString();
        //Explanation: One way to obtain s3 is:
        //Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
        //Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
        //Since s3 can be obtained by interleaving s1 and s2, we return true.
        System.out.println(interleavingString.isInterleave(s1, s2, s3));

        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";
        System.out.println(interleavingString.isInterleave(s1, s2, s3));
    }
}
