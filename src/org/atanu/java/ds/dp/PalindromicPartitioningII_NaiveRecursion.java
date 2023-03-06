package org.atanu.java.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/qZG5G2OZzJ7
public class PalindromicPartitioningII_NaiveRecursion {
    // Function to check if the current substring is a palindrome or not
    public static int isPalindrome(String s, int i, int j, int[][] palindromeTable){
        if (palindromeTable[i][j] == -1)
            palindromeTable[i][j] = 1;

        int start=i;
        int end = j;

        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                palindromeTable[i][j] = 0;
                return palindromeTable[i][j];
            }
            start += 1;
            end -= 1;

            if (start < end && palindromeTable[start][end] != -1){
                palindromeTable[i][j] = palindromeTable[start][end];
                return palindromeTable[i][j];
            }
        }
        return palindromeTable[i][j];
    }

    // Helper function with updated signature: i is start index of the current substring
    // j is the end index of the current substring
    public static int minCutsHelper(String s, int i, int j, int[][] dp,int[][] palindromeTable){
        // Base case
        if (i == j || (isPalindrome(s, i, j, palindromeTable))==1)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        // Variable to store the minimum number of cuts per iteration
        int result = j - i + 1;

        // Loop to place a cut after each index
        for(int k = i; k < j; k++){
            dp[i][j] = 1 + minCutsHelper(s, i, k, dp, palindromeTable) + minCutsHelper(s, k + 1, j, dp, palindromeTable);
            result = Math.min(result, dp[i][j]);
        }

        // Return the minimum number of cuts
        dp[i][j] = result;
        return dp[i][j];
    }

    public static int minCuts(String s){
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            Arrays.fill(dp[i], -1);

        int[][] palindromeTable = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            Arrays.fill(palindromeTable[i], -1);
        }

        return minCutsHelper(s, 0, s.length() - 1, dp, palindromeTable);
    }

    // Driver code
    public static void main(String[] args){
        ArrayList<String> inputs = new ArrayList<String>(){{add("radar"); add("abac"); add("book"); add("sleek"); add("fours");}};

        // You can uncomment the lines below and check how this recursive solution causes a time-out
        // inputs.add("elwxubtrnarrrjguuqwwoopgwjaaeavczrdubcgfvnxeutcatt");

        for (int i = 0; i < inputs.size(); i++){
            System.out.println(i + 1 + ".\tInput string:" + inputs.get(i) + "\n\n\t" + "The minimum number of cuts are: " + minCuts(inputs.get(i)));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }
    }
}
