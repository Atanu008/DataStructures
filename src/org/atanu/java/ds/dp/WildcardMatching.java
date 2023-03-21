package org.atanu.java.ds.dp;

// Video :  https://www.udemy.com/course/dynamic-programming-master-course-coding-minutes/learn/lecture/31158498#overview
// Video : https://www.udemy.com/course/dynamic-programming-master-course-coding-minutes/learn/lecture/31158506#overview

//https://leetcode.com/problems/wildcard-matching/description/
//Leetcode 44

public class WildcardMatching {

    public boolean isMatch(String s, String p) {

        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return isMatchUtil(s, p, 0, 0, dp);
    }

    private boolean isMatchUtil(String str, String pattern, int strIndex, int patternIndex, Boolean[][] dp){
        //Both indexes reaches end of both string . so that means pattern matches the string .
        //Return true;
        if(strIndex == str.length() && patternIndex == pattern.length()){
            return true;
        }
        //If we have come here that means pattern is complete but there are character left in string that did not match
        //return false in that case
        if(patternIndex == pattern.length()){
            return false;
        }
        // String reached to end . But still characters left in pattern
        // Case A : If all the remaining characters in pattern are star(*)
        // then return true as the stars can match empty string
        // Case B : if in pattern there is Non star character then return false
        // As it would not match with empty String
        if(strIndex == str.length()){
            return isAllStarsInPattern(pattern, patternIndex);
        }

        //Return from cache
        if(dp[strIndex][patternIndex] != null){
            return dp[strIndex][patternIndex];
        }

        boolean ans = false; // Initialize ans as false(This will cover the case where pattern char and String chars dont match)

        // Case A : If String char and Pattern Char Match
        // Case B : If pattern char is "?"
        // In both cases forward String and Pattern
        if(str.charAt(strIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '?' ){
            ans |= isMatchUtil(str, pattern, strIndex + 1, patternIndex + 1, dp);
        }
        // Case C : If the pattern char is "*"
        // Case C1 : Dont match the "*" with current String char . We forward the pattern Index ans not matching
        //           Dont forward the String Index as its not matching
        //           Dont Match : dp(strIndex, patternIndex) = dp(strIndex, patternIndex + 1)
        //Case C2 :  Match the "*" with current character. We forward the String Index as matching
        //           Dont forward the pattern Index as it can still match with next character in recurssion
        //           Match : dp(strIndex, patternIndex) = dp(strIndex + 1, patternIndex)

        //We need to check both possibilities . So take the Or(any path is fine)
        else if( pattern.charAt(patternIndex) == '*'){
            ans |= isMatchUtil(str, pattern, strIndex, patternIndex + 1, dp);
            ans |= isMatchUtil(str, pattern, strIndex + 1, patternIndex, dp);
        }

        return dp[strIndex][patternIndex] = ans;
    }

    private boolean isAllStarsInPattern(String pattern, int patternIndex){

        for(int i = patternIndex; i < pattern.length(); i++){
            if(pattern.charAt(i) != '*'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        String s = "aa", p = "a";
        boolean result = wildcardMatching.isMatch(s, p);
        //Output: false
        //Explanation: "a" does not match the entire string "aa".
        System.out.println(result);

        s = "aa";
        p = "*";
        //Output: true
        //Explanation: '*' matches any sequence.
        result = wildcardMatching.isMatch(s, p);
        System.out.println(result);

        s = "cb";
        p = "?a";
        //Output: false
        //Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
        result = wildcardMatching.isMatch(s, p);
        System.out.println(result);
    }
}
