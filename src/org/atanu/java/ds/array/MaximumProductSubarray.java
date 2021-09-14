package org.atanu.java.ds.array;

// Explanation Video : https://www.youtube.com/watch?v=vtJvbRlHqTA
//https://leetcode.com/problems/maximum-product-subarray/
//LeetCode 152
// Similar to Kadanes Algo
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int curr_max_product = nums[0];
        int curr_min_product = nums[0];
        int prev_max_product = nums[0];
        int prev_min_product = nums[0];
        int maxProduct = nums[0];

        for(int i = 1; i < nums.length; i++){
            //since the array can contain negative/positive integers
            //at each iteration, the max product could be obtained by
            //multiplying to a previous max or by multiplying prev min
            //(since even number of -ve integers will be a +ve product)
            //or by using the number itself
            //At every position we have three Choice
            //1. Current Element is positve Integer. prev_max_product*nums[i] would give the max
            //2. Current Element is Negative Integer. prev_min_product*nums[i] would give the max
            //3. Current element is starting point

            curr_max_product = Math.max(Math.max(prev_max_product*nums[i], prev_min_product*nums[i]), nums[i]);
            curr_min_product = Math.min(Math.min(prev_max_product*nums[i], prev_min_product*nums[i]), nums[i]);
            prev_max_product = curr_max_product;
            prev_min_product = curr_min_product;

            maxProduct = Math.max(maxProduct, curr_max_product);
        }
        return maxProduct;
    }

    //Brute Force. O(n^2)
    public int maxProductV2(int[] nums) {
        int maxSum = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 1;
            for(int j = i; j < nums.length; j++){
                sum *= nums[j];
                maxSum = Math.max(sum, maxSum);
            }

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(new MaximumProductSubarray().maxProductV2(nums));
        System.out.println(new MaximumProductSubarray().maxProduct(nums));
    }
}
