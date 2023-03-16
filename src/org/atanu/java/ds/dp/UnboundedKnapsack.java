package org.atanu.java.ds.dp;

public class UnboundedKnapsack {

    public int knapsack(int capacity, int[] weight, int[] value, int n, Integer[][] dp) {
        // Base Case
        if (n == 0||capacity == 0){
            return 0;
        }
        if (dp[n][capacity] != null){
            return dp[n][capacity];
        }
        // The only only change between 0/1 knapsack and this one is here
        // We are not forwarding the item(i.e doing n- 1) while including in choice
        // This will give us option to choose it again.
        if (weight[n - 1] <= capacity)
            return dp[n][capacity] = Math.max((value[n - 1] + knapsack(capacity - weight[n - 1], weight, value,
                     n, dp)), knapsack(capacity, weight, value,n - 1, dp));
        else
            return dp[n][capacity] = knapsack(capacity, weight, value, n - 1, dp);
    }

    public static void main(String[] args) {
        UnboundedKnapsack unboundedKnapsack = new UnboundedKnapsack();
        int[] val = new int[] { 10, 30, 20 };
        int[] wt = new int[] { 5, 10, 15};
        int capacity = 100;
        int n = val.length;
        Integer dp[][] = new Integer[n + 1][capacity + 1];
        int maxValue = unboundedKnapsack.knapsack(capacity, wt, val, n, dp);
        System.out.println("Top Down Approach ");
        System.out.println("Maximum value that the knapsack can have is : " + maxValue);
    }
}
