package org.atanu.java.ds.dp;

//https://leetcode.com/problems/n-th-tribonacci-number/
//LeetCode 1137
public class NthTribonacciNumber {

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

    public static void main(String[] args) {
        int n = 25;
        int tribo = new NthTribonacciNumber().tribonacci(n);
        System.out.println("N-th Tribonacci Number of "+ n +" is "+ tribo);
    }
}
