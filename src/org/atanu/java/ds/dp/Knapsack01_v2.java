package org.atanu.java.ds.dp;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/B84xWoY7YB2
//https://www.youtube.com/watch?v=dT6dvdbpChA&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=5
public class Knapsack01_v2 {

    public int findKnapsack(int[] weights, int[] value, int capacity, int n, Integer[][] dp){
        // Base case
        // 0 items left or knapsack is full
        if(n == 0 || capacity == 0){
            return 0;
        }

        // If we have solved it earlier, then return the result from memory
        if(dp[n][capacity] != null){
            return dp[n][capacity];
        }
        // check if the weight of the nth item is less than capacity then
        // either
        // We include the item and reduce the weigth of item from the total weight
        // or
        // We don't include the item
        if(weights[n-1] <= capacity){
            int include = value[n-1] + findKnapsack(weights, value, capacity - weights[n-1], n-1, dp);
            int exclude = findKnapsack(weights, value, capacity, n-1, dp);
            return dp[n][capacity] = Math.max(include, exclude);
        }
        // Item can't be added in our knapsack
        // if it's weight is greater than the capacity
        return dp[n][capacity] = findKnapsack(weights, value, capacity, n-1, dp);
    }

    public static void main(String[] args) {
        Knapsack01 knapsack01 = new Knapsack01();
        int[] weights = {3, 6, 10, 7, 2};
        int[] values = {12, 10, 15, 17, 13};
        int n = weights.length;
        int capacity = 10;
        Integer[][] dp = new Integer[n + 1][capacity + 1];
        int maxEarn = knapsack01.findKnapsack(weights, values, 10, 5);
        System.out.println(maxEarn); //Taking 7+2 weight
    }
}
