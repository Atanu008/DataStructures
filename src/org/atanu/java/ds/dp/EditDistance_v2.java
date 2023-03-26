package org.atanu.java.ds.dp;

// https://leetcode.com/problems/edit-distance/description/
// Leetcode 72
// https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/q22x28J2OzD

//Awesome Explanation : https://www.udemy.com/course/dynamic-programming-master-course-coding-minutes/learn/lecture/31157776#overview
// Top Down https://www.udemy.com/course/dynamic-programming-master-course-coding-minutes/learn/lecture/31157780#overview
// Bottom Up : https://www.udemy.com/course/dynamic-programming-master-course-coding-minutes/learn/lecture/31157782#overview
public class EditDistance_v2 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // If second string is empty, only option is to
        // remove all characters of first string
        for(int i = 1; i <= m; i++){
            dp[i][0] = i;
        }

        // If first string is empty, only option is to
        // insert all characters of second string
        for(int i = 1; i <= n; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                // If last characters are same, ignore last char
                // and recur for remaining string
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If the last character is different, consider all
                // possibilities and find the minimum
                else{
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1],  // Insert
                            dp[i - 1][j]),  // Delete
                            dp[i - 1][j - 1]); // Replace
                }
            }
        }
        return dp[m][n];
    }
}
