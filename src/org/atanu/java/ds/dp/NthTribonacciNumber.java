package org.atanu.java.ds.dp;

import java.util.Arrays;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/YVGORA152x2

//https://leetcode.com/problems/n-th-tribonacci-number/
//LeetCode 1137

public class NthTribonacciNumber {

    //Bottom Up
    public int tribonacci(int n) {
        if(n < 2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

    // Using Memoization
    public int tribonacci_v2(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, 0);
        return tribonacciHelper(n, cache);
    }

    public int tribonacciHelper(int n, int cache[]) {
        // Base cases
        if (n == 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;

        // Using memoization table to get the already evaluated result
        if (cache[n] != 0)
            return cache[n];

        cache[n] = tribonacciHelper(n - 1, cache) +
                tribonacciHelper(n - 2, cache) +
                tribonacciHelper(n - 3, cache);

        return cache[n];
    }

    public static void main(String[] args) {
        int n = 25;
        int tribo = new NthTribonacciNumber().tribonacci(n);
        System.out.println("N-th Tribonacci Number of "+ n +" is "+ tribo);
        tribo = new NthTribonacciNumber().tribonacci_v2(n);
        System.out.println("N-th Tribonacci Number of "+ n +" is "+ tribo);
    }
}
