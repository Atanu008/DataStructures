package org.bgd.java.ds.dp.onedimension;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/problems/geek-jump/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geek-jump
 *
 *  Geek wants to climb from the 0th stair to the (n-1)th stair. At a time the Geek can climb either one or two steps. A height[N] array is also given. Whenever the geek jumps from stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. return the minimum energy that can be used by the Geek to jump from stair 0 to stair N-1.
 *
 * Example:
 * Input:
 * n = 4
 * height = {10 20 30 10}
 * Output:
 * 20
 * Explanation:
 * Geek jump from 1st to 2nd stair(|20-10| = 10 energy lost).
 * Then a jump from the 2nd to the last stair(|10-20| = 10 energy lost).
 * so, total energy lost is 20 which is the minimum.
 */
public class FrogJump {
    public int minimumEnergy(int[] arr, int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        return minEnergyMemo(arr, N - 1, dp);
    }

    /**
     * Recursive solution
     * @param arr
     * @param i
     * @return
     */

    private int minEnergy(int[] arr, int i) {

        if (i == 0) {
            return 0;
        }
        int step1 = 0;
        int step2 = Integer.MAX_VALUE;
        if (i > 0) {
            step1 = Math.abs(arr[i] - arr[i - 1]) + minEnergy(arr, i - 1);
        }
        if (i > 1) {
            step2 = Math.abs(arr[i] - arr[i - 2]) + minEnergy(arr, i - 2);
        }
        return Math.min(step1, step2);
    }

    /**
     * Memoization Top Down
     * @param arr
     * @param i
     * @param dp
     * @return
     */

    private int minEnergyMemo(int[] arr, int i, int[] dp) {
        if (i == 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int step1 = Math.abs(arr[i] - arr[i - 1]) + minEnergyMemo(arr, i - 1, dp);
        int step2 = Integer.MAX_VALUE;

        if (i > 1) {
            step2 = Math.abs(arr[i] - arr[i - 2]) + minEnergyMemo(arr, i - 2, dp);
        }

        dp[i] = Math.min(step1, step2);
        return dp[i];
    }

    /**
     * Bottom up Tabulation
     */
    private int minEnergyTabulation(int[] arr, int N) {
        int[] dp = new int[N];
        dp[0] = 0;
        for (int i = 1; i < N; i++) {
            int step1 = Math.abs(arr[i] - arr[i - 1]) + dp[i - 1];
            int step2 = Integer.MAX_VALUE;
            if (i > 1) {
                step2 = Math.abs(arr[i] - arr[i - 2]) + dp[i - 2];
            }
            dp[i] = Math.min(step1, step2);
        }
        return dp[N - 1];
    }

}
