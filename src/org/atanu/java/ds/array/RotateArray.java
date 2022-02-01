package org.atanu.java.ds.array;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-array/
//LeetCode 189
public class RotateArray {

    public void rotate(int[] arr, int rotation) {
        int n = arr.length;
        rotation = rotation%n;
        //reverse last k digit
        reverse(arr, n - rotation, n - 1);
        // Reverse the first 'n-k' elements
        reverse(arr, 0, n - rotation - 1);
        // Reverse the whole array
        reverse(arr, 0, n - 1);
    }

    public void reverse(int[] arr, int start, int end) {
        while (start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotateArray.rotate(nums, k);
        System.out.println("After K rotation :\n" + Arrays.toString(nums));
    }
}
