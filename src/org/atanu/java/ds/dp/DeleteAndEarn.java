package org.atanu.java.ds.dp;

//https://leetcode.com/problems/delete-and-earn/
//LeetCode 740
//Same as House Robber Concept
// we have taken  the max element as the DP array size would be that max
// some solutions are taking 1000 as size as the it is defiened in constraint

/*
The idea is a simple trick. First, you notice that at every single element in our original nums array, you have 2 choices: To earn or not to earn. Based on problem, whichever element you earn, you must delete any values of nums[i]-1 and nums[i]+1. It helps to assume a sorted array so that you can place elements in ascending order to visualize the problem. You notice there that if you earn an element, you cannot earn its immediate unequal neighbors on both sides.

You also notice that if you have duplicate values in nums array, if you earn one of them, you end up earning all of them. This is because you have deleted its neighbors and therefore make its remaining duplicates "undeletable". This is important because you notice the problem simplifies to which values can earn you the largest total.

So I aggregated the sums into a sums array to map each value (array's index) with the total sum you can earn by deleting all elements of that value (array's value). Then write a for loop to compute the maximum sum ending at i At each step, your sum can either depend on your previous sum or the prior plus the current. You use a greedy algorithm to always pick the maximum value for each i.
 */
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {

        int max = nums[0];
        for(int a : nums){
            max = Math.max(max,a);
        }
        int[] buckets = new int[max + 1];
        for (int num : nums) {
            buckets[num] += num;
        }
        int[] dp = new int[max + 1];
        dp[0] = buckets[0];
        dp[1] = buckets[1];
        for (int i = 2; i < buckets.length; i++) {
            dp[i] = Math.max(buckets[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4};
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        System.out.println("You earn a total points of "+deleteAndEarn.deleteAndEarn(nums));
    }
}
