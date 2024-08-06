package org.bgd.java.ds.binarysearch;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays">...</a>
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 */
public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int na = A.length, nb = B.length;
        int n = na + nb;
        if ((na + nb) % 2 == 1) {
            return solve(A, B, n / 2, 0, na - 1, 0, nb - 1);
        } else {
            return ((double) (solve(A, B, n / 2, 0, na - 1, 0, nb - 1) + solve(A, B, n / 2 - 1, 0, na - 1, 0, nb - 1)) / 2);
        }
    }

    private int solve(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
        if (aEnd < aStart) {
            return B[k - aStart];
        }

        if (bEnd < bStart) {
            return A[k - bStart];
        }

        int aMid = (aStart + aEnd) / 2;
        int bMid = (bStart + bEnd) / 2;
        int aValue = A[aMid];
        int bValue = B[bMid];

        // k is in right half
        if (aMid + bMid < k) {
            if (aValue > bValue) {
                return solve(A, B, k, aStart, aEnd, bMid + 1, bEnd);
            } else {
                return solve(A, B, k, aMid + 1, aEnd, bStart, bEnd);
            }
        } else {
            if (aValue > bValue) {
                return solve(A, B, k, aStart, aMid - 1, bStart, bEnd);
            } else {
                return solve(A, B, k, aStart, aEnd, bStart, bMid - 1);
            }
        }
    }
}
