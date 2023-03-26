package org.atanu.java.ds.dp;

// https://leetcode.com/problems/edit-distance/description/
// Leetcode 72
// https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/q22x28J2OzD

//Awesome Explanation : https://www.udemy.com/course/dynamic-programming-master-course-coding-minutes/learn/lecture/31157776#overview
// Top Down https://www.udemy.com/course/dynamic-programming-master-course-coding-minutes/learn/lecture/31157780#overview

// Top Down Approach

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        Integer[][] dp = new Integer[m][n];
        return dp(word1, word2, 0, 0, dp);
    }

    private int dp(String word1, String word2, int i, int j, Integer[][] dp){

        // If Both string reached their end . We dont need to insert/delete/replace
        // Return 0
        if(i == word1.length() && j == word2.length()){
            return 0;
        }
        // If word1 reached to end we need to delete remaining word2 characters(word2.length() - j)
        if(i == word1.length()){
            return word2.length() - j;
        }
        // If word2 reached to end we need to delete remaining word2 characters(word1.length() - i)
        if(j == word2.length()){
            return word1.length() - i;
        }
        // Return from cache
        if(dp[i][j] != null){
            return dp[i][j];
        }

        // If the two character dont match

        // Delete From First String :
        // i will go forward as we are deleting from first , j will remain same
        // dp(i, j) = 1 + dp(i + 1, j)

        // Insert In First String:
        // we will try to match the character in second sting while inserting the char in first
        // So we will forward the second String(j + 1) as it is matched by inserting the same char in first String
        // dp(i, j)   = 1 + dp(i, j + 1)

        // Replace In First String :
        // Replace will match the character in second String , so we will forward both String
        // dp(i, j)   = 1 + dp(i + 1, j + 1)

        // Now if we consider doing Delete/Insert/Replce the dp state will be
        // Delete : dp(i, j)   = 1 + dp(i, j + 1)
        // Insert : dp(i, j)   = 1 + dp(i + 1, j)
        // Replace: dp(i, j)   = 1 + dp(i + 1, j + 1)

        // So basically Delete became Insert if we do it from second String
        // So taking one String as reference is just Fine.
        // No need to do it for both String
        if(word1.charAt(i) != word2.charAt(j)){
            return  dp[i][j] = 1 + Math.min(dp(word1, word2, i+1, j, dp),
                    Math.min(dp(word1, word2, i, j+1, dp), dp(word1, word2, i+1, j+1, dp)));
        }
        // If the Characters match , we will just forward both String
        // No need to do any editing .So No +1
        // dp(i, j)   = dp(i + 1, j + 1)
        else{
            return dp[i][j] = dp(word1, word2, i+1, j+1, dp);
        }
    }
}
