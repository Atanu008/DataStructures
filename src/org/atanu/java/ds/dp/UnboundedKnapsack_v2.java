package org.atanu.java.ds.dp;

public class UnboundedKnapsack_v2 {

    public int findKnapsack(int[] weights, int[] value, int capacity){

        int n = weights.length;
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
                // we have i and NOT i - 1 while including(This is the only change between 0/1 knapsack)
                // This keeps our option open to include more than instance of the same item if we want.
                if(weights[i-1] <= j){
                    dp[i][j] = Math.max(value[i-1] + dp[i][j-weights[i-1]], dp[i-1][j]);
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
        UnboundedKnapsack_v2 unboundedKnapsack = new UnboundedKnapsack_v2();
        int[] val = new int[] { 10, 30, 20 };
        int[] wt = new int[] { 5, 10, 15};
        int capacity = 100;

        int maxValue = unboundedKnapsack.findKnapsack(wt, val, capacity);
        System.out.println("Bottom Up Approach ");
        System.out.println("Maximum value that the knapsack can have is : " + maxValue);
    }
}
