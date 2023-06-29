package org.atanu.java.ds.array;

import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/
// Leetcode 88
// Video : https://www.youtube.com/watch?v=P1Ic85RarKY

public class MergeTwoSortedArrayToFirst {

    public void merge(int[] a, int m, int[] b, int n) {

        int i = m - 1;
        int j = n - 1;
        int lastIndex = m + n - 1;
        // Merge a and b, starting
        // from last element in each
        while(i >= 0 && j >= 0){
            /* End of a is greater than end of b */
            if(a[i] > b[j]){
                a[lastIndex] = a[i]; // Copy Element
                i--;
            }else{ // either End of b bigger Or equal. In both cases copy
                a[lastIndex] = b[j]; // Copy Element
                j--;
            }
            lastIndex--;
        }
        // Corner case . If we have few smaller eelements than a
        // a = {4, 5, 8, 0, 0, 0}
        // b = {1, 2, 9}
        // i loop will be -1 but still {1, 2} would be there in b.
        // So need to include them
        while(j >= 0){
            a[lastIndex--] = b[j--];
        }
    }

    // Brute Force
    public void merge_v2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
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
