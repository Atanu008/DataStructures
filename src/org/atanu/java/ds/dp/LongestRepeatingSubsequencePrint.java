package org.atanu.java.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/g2VxB8gqY1j
//https://www.techiedelight.com/longest-repeated-subsequence-problem/

// Same Pattern as Printing Longest Common Subsequence
// just i != j is added . that's it

public class LongestRepeatingSubsequencePrint {

    public String printLRS(String str) {

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

        StringBuilder lcs = new StringBuilder();
        int i = m;
        int j = n;

        while(i > 0 && j > 0){
            //System.out.println("KK");
            if(str.charAt(i-1) == str.charAt(j-1) && i != j){
                //Take the element
                //(i-1 Or j-1) . Anything is fine
                //Go Diagonal
                //System.out.println("KK");
                lcs.append(str.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                //Left Value is greater
                //Go Up one row. Dont need to consider the element
                i--;
            }
            else{
                //Upper value if greater
                j--;
            }
        }

        return lcs.reverse().toString();

    }

    public static void main(String[] args) {

        LongestRepeatingSubsequencePrint longestRepeatingSubsequence = new LongestRepeatingSubsequencePrint();
        ArrayList<String> inputs = new ArrayList<String>(
                Arrays.asList("abcd", "abddccd", "abbaba", "aaaaba", "abcdaeda")
        );

        // Let's uncomment this and check the effect of dynamic programming using memoization
        // inputs.add("abcdefghijklmnopqrstuv");


        for (int i = 0; i < inputs.size(); i++) {
            System.out.println(i + 1 + ". String: " + inputs.get(i));
            System.out.println("Longest repeating subsequence is " + longestRepeatingSubsequence.printLRS(inputs.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-') + '\n');
        }
    }
}
