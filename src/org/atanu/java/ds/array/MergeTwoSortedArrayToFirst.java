package org.atanu.java.ds.array;

import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/
public class MergeTwoSortedArrayToFirst {

    public void merge(int[] a, int n, int[] b, int m) {
        int i = n - 1;
        int j = m - 1;

        int lastIndex = n + m - 1;

        // Merge a and b, starting
        // from last element in each
        while (j >= 0)
        {

            /* End of a is greater than end of b */
            if (i >= 0 && a[i] > b[j])
            {
                // Copy Element
                a[lastIndex] = a[i];
                i--;
            } else
            {
                // Copy Element
                a[lastIndex] = b[j];
                j--;
            }
            // Move indices
            lastIndex--;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedArrayToFirst mergeArray = new MergeTwoSortedArrayToFirst();
        int [] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        mergeArray.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));


    }
}
