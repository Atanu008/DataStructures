package org.atanu.java.ds.dp;

import java.util.Map;

//https://leetcode.com/problems/fibonacci-number/
//LeetCode 509
public class FibonacciNumber {
    //Simple Recurssion
    public int fib(int n) {
        if(n<2){
            return n;
        }

        return fib(n-1) + fib(n-2);
    }

    //Recursion with Memoization
    //Memoization with Array
    public int fibV2(int n) {
        int[] dp = new int[n+1];

        return fibMemo(n, dp);
    }

    private int fibMemo(int n, int[] dp){
        if(n<2){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = fibMemo(n-1, dp) + fibMemo(n-2, dp);
        return dp[n];
    }

    // Function to find the nth Fibonacci number
    // Memoization with Map
    public static int fib(int n, Map<Integer, Integer> lookup)
    {
        if (n <= 1) {
            return n;
        }

        // if the subproblem is seen for the first time
        lookup.putIfAbsent(n, fib(n - 1, lookup) + fib(n - 2, lookup));

        return lookup.get(n);
    }

    //Bottom UP DP
    public int fibV3(int n) {

        if(n < 2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //Bottom UP DP
    // As we are interested in two states only
    // Previous two state is enough
    public int fibV4(int n) {

        if(n < 2){
            return n;
        }

        int previousFib = 0;
        int currentFib = 1;

        for(int i = 2; i<=n; i++){
            int newFib = previousFib + currentFib;
            previousFib = currentFib;
            currentFib = newFib;
        }

        return currentFib;
    }

    public static void main(String[] args) {
        int n = 7;
        FibonacciNumber fib = new FibonacciNumber();
        System.out.println("Fibonacci of "+n+"th term is "+fib.fib(n));
        System.out.println("Fibonacci of "+n+"th term is "+fib.fibV2(n));
        System.out.println("Fibonacci of "+n+"th term is "+fib.fibV3(n));
        System.out.println("Fibonacci of "+n+"th term is "+fib.fibV4(n));

    }
}
