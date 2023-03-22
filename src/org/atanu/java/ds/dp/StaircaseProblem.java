package org.atanu.java.ds.dp;

import java.util.Arrays;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/NEpPjmP21l8

// Same as https://leetcode.com/problems/climbing-stairs/description/
// Leetcode 70
// The only difference is here it can move 3 steps

public class StaircaseProblem {

    public long countWays(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return countWaysRec(n, dp);
    }

    public long countWaysRec(int n, long[] dp) {
        if(n < 0){
            return 0;
        }
        //we are already at the top of the stairs, and need to take 0 steps
        //We will define this as 1 way
        if(n == 0){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = countWaysRec(n - 1, dp) + countWaysRec(n - 2, dp) + countWaysRec(n - 3, dp);
    }

    public static void main(String[] args) {
        StaircaseProblem staircaseProblem = new StaircaseProblem();
        int[] inputs = {0, 4, 3, 5, 6};
        System.out.println("Top Down :");
        // Let's uncomment this and check the effect of dynamic programming using memoization
        // int temp[] = Arrays.copyOf(inputs, inputs.length + 1);
        // temp[inputs.length] = 39;
        // inputs = temp;

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tSteps: " + inputs[i] +
                    "\n\n\tNumber of ways: " + staircaseProblem.countWays(inputs[i]));

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
