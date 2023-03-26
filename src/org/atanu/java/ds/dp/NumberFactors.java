package org.atanu.java.ds.dp;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/m77pAnlzvO3

import java.util.Arrays;
import java.util.stream.Stream;

public class NumberFactors {

    private static long countWaysRec(int n, long[] dp) {
        // We can not get a negative target number at any point,
        // so we return 0 for negative values
        if(n < 0){
            return 0;
        }
        // One way . able to form the number Or the number itself is zero
        if(n == 0){
            return 1;
        }
        //Return from cache
        if(dp[n] != -1){
            return dp[n];
        }
        // Recursively calculate the number of ways using the
        // recurrence relation we saw earlier
        return dp[n] = countWaysRec(n - 1, dp) + countWaysRec(n - 3, dp) + countWaysRec(n - 4, dp);
    }

    public long countWays(int n) {
        // Initializing our solution array
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return countWaysRec(n, dp);
    }

    public long countWaysBottomUP(int n) {
        // Initializing our solution vector
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        // Each vector index holds the number of ways to
        // reach a number equal to the index
        dp[0] = 1;

        // Variables to store sub-target numbers
        long n4, n3, n1 = 0;

        // Iteratively calculate the number of ways to reach a
        // target number and store it in the solutions' array
        for (int r = 1; r <= n; r++) {
            // Return 0 if index is less than 0, otherwise
            // set to array value
            n1 = r - 1 < 0 ? 0 : dp[r - 1];
            n3 = r - 3 < 0 ? 0 : dp[r - 3];
            n4 = r - 4 < 0 ? 0 : dp[r - 4];

            // Using our recurrence relation to calculate new answers
            dp[r] = n1 + n3 + n4;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumberFactors numberFactors = new NumberFactors();
        int[] targetNumbers = {3, 5, 10, 25, 0};

        // You can uncomment the lines below and check how this recursive solution causes a time-out

        // targetNumbers = Arrays.copyOf(targetNumbers, targetNumbers.length + 1);
        // targetNumbers[targetNumbers.length - 1] = 50;

        for (int i = 0; i<targetNumbers.length; i++) {
            System.out.println(i + 1 + ".\tn: " + targetNumbers[i] +
                    "\n\n\tNumber of ways to reach the target number: " + numberFactors.countWays(targetNumbers[i]));
            System.out.println(i + 1 + ".\tn: " + targetNumbers[i] +
                    "\n\n\tNumber of ways to reach the target number Using bottom up: " + numberFactors.countWaysBottomUP(targetNumbers[i]));

            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println(" ");
        }
    }
}
