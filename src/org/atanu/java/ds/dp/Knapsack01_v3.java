package org.atanu.java.ds.dp;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/B84xWoY7YB2
//Video : https://www.youtube.com/watch?v=WNkqbqyvR_0&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=6

public class Knapsack01_v3 {

    //we will create a 2-D array of size (n + 1)*(capacity + 1).
    //The row indicates the values of the available items
    //The column shows the capacity of the knapsack at any given point
    public int findKnapsack(int[] weights, int[] value, int capacity, int n){

        int[][] dp = new int[n + 1][capacity + 1];
        //If there is no capacity left that is capacity is 0 then DP[i][0] for every i will be 0.
        //So the first column column will be zero only as the capacity is zero

        //If there are no items left that is N reaches 0 then DP[0][i] for every i will be 0
        //So the first row will be zero only as no item is included

        //Note : Not doing the first row and column initialization as they are zero only

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= capacity; j++){
                // check if the weight of the nth item is less than capacity then
                // either
                // We include the item and reduce the weigth of item from the total weight
                // or
                // We don't include the item
                if(weights[i-1] <= j){
                    dp[i][j] = Math.max(value[i-1] + dp[i-1][j-weights[i-1]], dp[i-1][j]);
                }
                // we don't include the item if the weight is greater than the capacity.
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Knapsack01_v3 knapsack01 = new Knapsack01_v3();
        int[] weights = {3, 6, 10, 7, 2};
        int[] values = {12, 10, 15, 17, 13};
        int n = weights.length;
        int capacity = 10;
        Integer[][] dp = new Integer[n + 1][capacity + 1];
        int maxEarn = knapsack01.findKnapsack(weights, values, 10, 5);
        System.out.println(maxEarn); //Taking 7+2 weight

        // input: a set of items, each with a weight and a value
        int[] v = { 20, 5, 10, 40, 15, 25 };
        int[] w = { 1, 2, 3, 8, 7, 4 };
        // knapsack capacity
        int W = 10;
        maxEarn = knapsack01.findKnapsack(w, v, W, v.length);
        System.out.println(maxEarn); //Taking 7+2 weight
    }
}
