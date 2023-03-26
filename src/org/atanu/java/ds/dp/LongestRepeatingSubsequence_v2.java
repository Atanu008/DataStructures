package org.atanu.java.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/g2VxB8gqY1j
//https://www.techiedelight.com/longest-repeated-subsequence-problem/

public class LongestRepeatingSubsequence_v2 {

    public int findLRS(String str) {

        int m = str.length();
        int n = str.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                // if characters at index `i` and `j` matches
                // and the index are different
                if(str.charAt(i -1) == str.charAt(j -1 ) && i != j){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                // otherwise, if characters at index `i` and `j` are different
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        LongestRepeatingSubsequencePrint longestRepeatingSubsequence = new LongestRepeatingSubsequencePrint();
        ArrayList<String> inputs = new ArrayList<String>(
                Arrays.asList("abcd", "abddccd", "abbaba", "aaaaba", "abcdaeda")
        );

        // Let's uncomment this and check the effect of dynamic programming using memoization
        // inputs.add("abcdefghijklmnopqrstuv");

        System.out.println("Bottom Up Approach ");
        for (int i = 0; i < inputs.size(); i++) {
            System.out.println(i + 1 + ". String: " + inputs.get(i));
            System.out.println("Longest repeating subsequence is " + longestRepeatingSubsequence.printLRS(inputs.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-') + '\n');
        }
    }
}
