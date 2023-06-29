package org.atanu.java.ds.array;

// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/description/
// Leetcode 1588

import java.io.SyncFailedException;

public class SumOfAllOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] nums) {

        int sum = 0;

        for(int left = 0; left < nums.length; left++){
            int windowSum = 0;
            for(int right = left; right < nums.length; right++){
                windowSum += nums[right];
                int windowSize = right - left + 1;
                if( windowSize % 2 != 0){
                    sum += windowSum;
                }
            }
        }
        return sum;
    }

    // Awesome Video : https://www.youtube.com/watch?v=4SdOYDW4HAk
    public int sumOddLengthSubarrays_v2(int[] arr) {

        int sum = 0;
        for(int i = 0; i < arr.length; i++){

            int left = i + 1;
            int right = arr.length - i;

            int totalSubArray = left * right;
            int OddLengthSubArray = totalSubArray % 2 == 0 ? totalSubArray / 2 : totalSubArray / 2 + 1;

            sum += OddLengthSubArray * arr[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        SumOfAllOddLengthSubarrays sumOfAllOddLengthSubarrays = new SumOfAllOddLengthSubarrays();
        int[] nums = {1,4,2,5,3};
        System.out.println(sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(nums));
        System.out.println(sumOfAllOddLengthSubarrays.sumOddLengthSubarrays_v2(nums));
    }
}
