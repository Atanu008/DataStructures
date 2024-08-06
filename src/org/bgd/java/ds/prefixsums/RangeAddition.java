package org.bgd.java.ds.prefixsums;

/**
 * <a href="https://leetcode.com/problems/range-addition/description/">...</a>
 * 370. Range Addition
 * You are given an integer length and an array updates where updates[i] = [startIdxi, endIdxi, inci].
 * You have an array arr of length length with all zeros, and you have some operation to apply on arr.
 * In the ith operation, you should increment all the elements arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] by inci.
 * Return arr after applying all the updates.
 *
 *
 * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * Output: [-2,0,3,5,3]
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] prefix = new int[length];
        for (int[] q : updates) {
            prefix[q[0]] += q[2];
            if (q[1] < length - 1)
                prefix[q[1] + 1] -= q[2];
        }

        for (int i = 1; i < length; i++) {
            prefix[i] += prefix[i - 1];
        }

        return prefix;
    }
}
