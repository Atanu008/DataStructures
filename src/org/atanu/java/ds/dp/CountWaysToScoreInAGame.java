package org.atanu.java.ds.dp;

import java.util.Arrays;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/gkxy59xPgxl

public class CountWaysToScoreInAGame {

    private long scoringOptionsRec(int n, long[] memo) {
        // We can not get a negative score, we return 0 for negative values
        if (n < 0) return 0;

        // Check if a solution already exists in the array
        if (memo[n] != -1) return memo[n];

        // Else, we recursively calculate the solution for the
        // given value and store it in our solution array
        return memo[n] =
                scoringOptionsRec(n - 1, memo) + scoringOptionsRec(n - 2, memo) + scoringOptionsRec(n - 4, memo);
    }

    // Scoring options are 1, 2, and 4
    public long scoringOptions(int n) {
        // Initializing our solution array
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);

        // Set up the base case, 1 way to score 0
        memo[0] = 1;

        // Pass our array to the helper function
        return scoringOptionsRec(n, memo);
    }

    // Scoring options are 1, 2, and 4
    public long scoringOptionsBottomUp(int n) {
        // Initializing our solution array
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        // Each array index holds the number of ways to
        // reach a score equal to the index
        dp[0] = 1;

        // Varaibles to store scores
        long s4, s2, s1 = 0;

        // Iteratively calculate the number of ways to reach a
        // score and store it into the solutions array
        for (int r = 1; r <= n; r++) {
            // Return 0 if index is less than 0, otherwise
            // set to array value
            s1 = r - 1 < 0 ? 0 : dp[r - 1];
            s2 = r - 2 < 0 ? 0 : dp[r - 2];
            s4 = r - 4 < 0 ? 0 : dp[r - 4];

            // Using our recurrence relation to calculate new answers
            dp[r] = s1 + s2 + s4;
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int[] totalScores = {3, 5, 10, 25, 0};
        CountWaysToScoreInAGame countWaysToScoreInAGame = new CountWaysToScoreInAGame();
        // You can uncomment the lines below and check how this bottom-up solution executes without a time-out

        // totalScores = Arrays.copyOf(totalScores, totalScores.length + 1);
        // totalScores[totalScores.length - 1] = 50;

        for (int i = 0; i < totalScores.length; i++) {
            System.out.println((i + 1) + ".\tn: " + totalScores[i] +
                    "\n\n\tNumber of ways to reach the score: " + countWaysToScoreInAGame.scoringOptions(totalScores[i]));

            System.out.println((i + 1) + ".\tn: " + totalScores[i] +
                    "\n\n\tNumber of ways to reach the score Using Bottom Up: " + countWaysToScoreInAGame.scoringOptionsBottomUp(totalScores[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
