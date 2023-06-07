package org.atanu.java.ds.greedy;

// https://leetcode.com/problems/minimize-maximum-of-array/description/
// Leetcode 2439
// Video : https://www.youtube.com/watch?v=AeHMvcKuR0Y

public class MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums) {
        // First number can not be decremented ,
        // Its the possible answer
        long res = nums[0];
        long sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            // Math.ceil(sum/(i + 1)) = (sum + i) / (i + 1)
            res = Math.max(res, (sum + i) / (i + 1));
        }
        return (int)res;
    }
}
