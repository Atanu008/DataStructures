package org.atanu.java.ds.dp;

// Video : https://www.udemy.com/course/dynamic-programming-master-course-coding-minutes/learn/lecture/31159606#overview
// Video : https://www.udemy.com/course/dynamic-programming-master-course-coding-minutes/learn/lecture/31159608#overview
//https://leetcode.com/problems/regular-expression-matching/description/
//Leetcode 10
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        //Boolean array s.length()+ 1 because in recursion there might be cases where it can go to that length
        //Otherwise Map can be introduced to cache the result
        Boolean[][] dp = new Boolean[s.length()+ 1][p.length() + 1];
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

        //Return in cache
        if(dp[strIndex][patternIndex] != null){
            return dp[strIndex][patternIndex];
        }

        //Now here str length can be less than the length also can equal to length
        //So doing further recursion we need to check whether it exceeds the length or not(strIndex < str.length())
        //Pattern in inside index only . base condition covers it

        // Case A : Pattern[patternIndex + 1] = "*"
        // Case A1 : Str[strIndex] = Pattern[patternIndex] match the current character with pattern. forward the String
        //           dp(strIndex, patternIndex) = dp(strIndex + 1, patternIndex)
        // Case A2 : Pattern[patternIndex] = "."  Pattern dot(.) will match the staring character, forward the string
        //           dp(strIndex, patternIndex) = dp(strIndex + 1, patternIndex)
        // Case A3 : Dont match any string character with "*" pattern. forward the pattern and move the patternIndex to +2
        //           like we have c*ab and we dont want c* to vanish/dont match move the index to "a"
        boolean ans = false;
        if( patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*'){
            // Case A1 and Case A2
            if(strIndex < str.length() &&
                    (str.charAt(strIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.')){
                ans |= isMatchUtil(str, pattern, strIndex + 1, patternIndex, dp);
            }

            ans |= isMatchUtil(str, pattern, strIndex, patternIndex + 2, dp); // Case A3 Dont match any string character with "*" pattern
        }
        // Case B1 : if the current Str character matches with Pattern
        // Case B2 : If the pattern character is "."
        // In Both cases both pointer will move forward as the character matching(. can can match ant char in Str)
        else if(strIndex < str.length() &&
                (str.charAt(strIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.')){
            ans |= isMatchUtil(str, pattern, strIndex + 1, patternIndex + 1, dp);
        }

        return dp[strIndex][patternIndex] = ans;
    }

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        String s = "aa", p = "a";
        boolean result = regularExpressionMatching.isMatch(s, p);
        //Output: false
        //Explanation: "a" does not match the entire string "aa".
        System.out.println(result);

        s = "aa";
        p = "a*";
        result = regularExpressionMatching.isMatch(s, p);
        //Output: true
        //Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
        System.out.println(result);

        s = "ab";
        p = ".*";
        result = regularExpressionMatching.isMatch(s, p);
        //Output: true
        //Explanation: ".*" means "zero or more (*) of any character (.)".
        System.out.println(result);
    }
}
