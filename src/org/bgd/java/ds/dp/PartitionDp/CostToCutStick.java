package org.bgd.java.ds.dp.PartitionDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/">...</a>
 * Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:
 *
 *
 * Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
 *
 * You should perform the cuts in order, you can change the order of the cuts as you wish.
 *
 * The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.
 *
 * Return the minimum total cost of the cuts.
 *
 * Input: n = 7, cuts = [1,3,4,5]
 * Output: 16
 *
 * Input: n = 9, cuts = [5,6,1,4,2]
 * Output: 22
 */
public class CostToCutStick {

    public int minCost(int n, int[] cuts) {
        List<Integer> newCuts = new ArrayList<>();

        for (int i : cuts) {
            newCuts.add(i);
        }
        newCuts.addFirst(0);
        newCuts.addLast(n);
        Collections.sort(newCuts);
        int[][] dp = new int[cuts.length + 1][cuts.length + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return minCostMemo(n, newCuts, 1, cuts.length, dp);
    }

    private int minCostRec(int n, List<Integer> cuts, int i, int j) {
        if (i > j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = cuts.get(j + 1) - cuts.get(i - 1) + minCostRec(n, cuts, i, ind - 1) + minCostRec(n, cuts, ind + 1, j);
            min = Math.min(min, cost);
        }
        return min;
    }

    /** Memoized
     *
     */

    private int minCostMemo(int n, List<Integer> cuts, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        for (int ind = i; ind <= j; ind++) {
            int cost = cuts.get(j + 1) - cuts.get(i - 1) + minCostMemo(n, cuts, i, ind - 1, dp) + minCostMemo(n, cuts, ind + 1, j, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}
