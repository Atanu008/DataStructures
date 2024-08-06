package org.bgd.java.ds.dp.recursion;

import java.util.Arrays;

/**
 *
 */
public class KnightDialer {
    int MOD = (int) 1e9 + 7;

    private int recur(int x, int y, int n, int[][][] dp) {
        int moves = 0;

        if (n == 1) {
            return 1;
        }

        if (dp[x][y][n] != -1) {
            return dp[x][y][n];
        }

        for (int[] d : directions) {
            int newx = x + d[0];
            int newy = y + d[1];

            if (isValid(newx, newy)) {
                moves = (moves + recur(newx, newy, n - 1, dp)) % MOD;
            }
        }
        return dp[x][y][n] = moves;
    }

    public int knightDialer(int n) {

        int[][][] dp = new int[4][3][n + 1];
        for (int[][] dd : dp) {
            for (int[] d : dd) {
                Arrays.fill(d, -1);
            }
        }
        int moves = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                moves = (moves + recur(i, j, n, dp)) % MOD;
            }
        }

        moves = (moves + recur(3, 1, n, dp)) % MOD;
        return moves;
    }

    int[][] directions = { { -2, -1 }, { -2, 1 }, { 2, -1 }, { 2, 1 }, { -1, 2 }, { 1, 2 }, { -1, -2 }, { 1, -2 } };

    private boolean isValid(int x, int y) {
        if (x < 0 || x > 3 || y < 0 || y > 2) {
            return false;
        }
        return x != 3 || y == 1;
    }
}
