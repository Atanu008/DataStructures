package org.atanu.java.ds.dp;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/NEpPjmP21l8

// Same as https://leetcode.com/problems/climbing-stairs/description/
// Leetcode 70
// The only difference is here it can move 3 steps

public class StaircaseProblem_v2 {

    public long countWays(int n) {

        //Base Case
        if (n < 0)
            return 0;
        if(n == 0)
            return 1;

        long[] dp = new long[n + 1];

        dp[0] = 1; // total number of ways to reach the Oth Stair is 1 (Needs no step BTW :))
        dp[1] = 1; // total number of ways to reach the Oth Stair is 1 . one jump
        dp[2] = 2; // // total number of ways to reach the Oth Stair is 2 (1 + 1 and 2 )


        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        StaircaseProblem_v2 staircaseProblem = new StaircaseProblem_v2();
        int[] inputs = {0, 4, 3, 5, 6};
        System.out.println("Bottom Up :");
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
