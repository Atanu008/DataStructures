package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/maximum-average-subarray-i/
//LeetCode 643
public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {

        int windowEnd = 0;
        int windowStart = 0;
        double maxAverage = Integer.MIN_VALUE;
        double sum = 0;

        while(windowEnd < nums.length){

            sum += nums[windowEnd];

            if(windowEnd >= k-1){
                double average = (double)sum/k;
                maxAverage = Math.max(maxAverage, average);
                sum -= nums[windowStart];
                windowStart++;
            }
            windowEnd++;
        }

        return maxAverage;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI  maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        int[]  nums = {1,12,-5,-6,50,3};
        int k = 4;
        double maxAverage = maximumAverageSubarrayI.findMaxAverage(nums, k);
        //Output: 12.75000
        //Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
        System.out.println("Maximum Average : "+ maxAverage);
    }
}
