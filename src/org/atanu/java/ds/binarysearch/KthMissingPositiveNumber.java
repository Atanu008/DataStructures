package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/kth-missing-positive-number/description/
// Leetcode 1539

public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {

        int i = 0;
        int num = 1; // num will start from 1. 1 <= arr.length <= 1000
        int n = arr.length;

        while(i < n && k > 0){
            // Not a missing number
            if(arr[i] == num){
                i++;
            }else{ // Missing number
                k--; // increment the missing number count
            }

            num++; // Forward the num
        }
        // For Remaining k's
        while(k --> 0){
            num++;
        }
        // When loop is done , numm will be pointing to next element. decrement and return
        return num - 1;
    }
}
