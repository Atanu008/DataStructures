package org.bgd.java.ds.dp.twodimension;

import java.util.Arrays;

/**
 * <a href="https://www.geeksforgeeks.org/problems/geeks-training/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geeks-training">...</a>
 *
 * Geek is going for n day training program. He can perform any one of these three activities Running, Fighting, and Learning Practice. Each activity has some point on each day. As Geek wants to improve all his skills, he can't do the same activity on two consecutive days. Help Geek to maximize his merit points as you are given a 2D array of points points, corresponding to each day and activity.
 *
 * Example:
 * Input:
 * n = 3
 * points = [[1,2,5],[3,1,1],[3,3,3]]
 * Output:
 * 11
 * Explanation:
 * Geek will learn a new move and earn 5 point then on second
 * day he will do running and earn 3 point and on third day
 * he will do fighting and earn 3 points so, maximum point is 11.
 *
 * Example:
 * Input:
 * n = 3
 * points = [[1,2,5],[3,1,1],[3,2,3]]
 * Output:
 * 11
 * Explanation:
 * Geek will learn a new move and earn 5 point then on second
 * day he will do running and earn 3 point and on third day
 * he will do running and earn 3 points so, maximum point is 11.
 */
public class NinjaTraining {
    public int maximumPoints(int[][] points, int N) {
        int[][] dp = new int[points.length + 1][points[0].length + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return maxPointsMemo(points, points.length - 1, points[0].length, dp);
    }

    /**
     * Recursive solution
     * @param p
     * @param i
     * @param d
     * @return
     */
    private int maxPointsRec(int[][] p, int i, int d) {
        if (i == 0) {
            int maximum = 0;
            for (int j = 0; j < p[0].length; j++) {
                if (j != d) {
                    maximum = Math.max(maximum, p[i][j]);
                }
            }
            return maximum;
        }
        int max = 0;
        for (int j = 0; j < p[0].length; j++) {
            if (j != d) {
                int score = p[i][j] + maxPointsRec(p, i - 1, j);
                max = Math.max(max, score);
            }
        }
        return max;
    }

    /**
     * Top Down Memoization
     * @param p
     * @param day
     * @param last
     * @param dp
     * @return
     */

    private int maxPointsMemo(int[][] p, int day, int last, int[][] dp) {
        if (day == 0) {
            int maximum = 0;
            for (int j = 0; j < p[0].length; j++) {
                if (j != last) {
                    maximum = Math.max(maximum, p[day][j]);
                }
            }
            return maximum;
        }
        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        int max = 0;
        for (int task = 0; task < p[0].length; task++) {
            if (task != last) {
                int score = p[day][task] + maxPointsMemo(p, day - 1, task, dp);
                max = Math.max(max, score);
            }
        }
        dp[day][last] = max;
        return dp[day][last];
    }

    private int maxPointsTabulation(int[][] points, int N) {
        int[][] dp = new int[points.length][points[0].length + 1];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < N; day++) {
            for (int last = 0; last < points[0].length + 1; last++) {
                int max = 0;
                for (int task = 0; task < points[0].length; task++) {
                    if (task != last) {
                        int score = points[day][task] + dp[day - 1][task];
                        max = Math.max(max, score);
                    }
                }
                dp[day][last] = max;
            }
        }
        return dp[N - 1][3];
    }
}
