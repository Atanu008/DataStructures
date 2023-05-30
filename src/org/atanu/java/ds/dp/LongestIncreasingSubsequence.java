package org.atanu.java.ds.dp;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/longest-increasing-subsequence/
//LeetCode 300
//Coding Minute
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        //Base Case. For one element Subsequence is always one
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            //Base Case. For one element Subsequence is always one
            dp[i] = 1;
            //Check for all previous elements.
            //If (nums[i] > nums[j] then take the length of jth element(i.e dp[j]) + 1(means teh ith element)
            //Take the maximum while evluating all js
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }

            }
        }
        return maxLength;
    }

    //Perfect Explanation : Intution
    //https://leetcode.com/problems/longest-increasing-subsequence/discuss/1326308
    // O(NlogN)
    //
    // Greedy with Binary Search
    //Let's construct the idea from following example.
    //Consider the example nums = [2, 6, 8, 3, 4, 5, 1], let's try to build the increasing subsequences starting with an empty one: sub1 = [].
    //Let pick the first element, sub1 = [2].
    //6 is greater than previous number, sub1 = [2, 6]
    //8 is greater than previous number, sub1 = [2, 6, 8]
    //3 is less than previous number, we can't extend the subsequence sub1, but we must keep 3 because in the future there may have the longest subsequence start with [2, 3], sub1 = [2, 6, 8], sub2 = [2, 3].
    //With 4, we can't extend sub1, but we can extend sub2, so sub1 = [2, 6, 8], sub2 = [2, 3, 4].
    //With 5, we can't extend sub1, but we can extend sub2, so sub1 = [2, 6, 8], sub2 = [2, 3, 4, 5].
    //With 1, we can't extend neighter sub1 nor sub2, but we need to keep 1, so sub1 = [2, 6, 8], sub2 = [2, 3, 4, 5], sub3 = [1].
    //Finally, length of longest increase subsequence = len(sub2) = 4.
    //In the above steps, we need to keep different sub arrays (sub1, sub2..., subk) which causes poor performance. But we notice that we can just keep one sub array, when new number x is not greater than the last element of the subsequence sub, we do binary search to find the smallest element >= x in sub, and replace with number x.
    //Let's run that example nums = [2, 6, 8, 3, 4, 5, 1] again:
    //Let pick the first element, sub = [2].
    //6 is greater than previous number, sub = [2, 6]
    //8 is greater than previous number, sub = [2, 6, 8]
    //3 is less than previous number, so we can't extend the subsequence sub. We need to find the smallest number >= 3 in sub, it's 6. Then we overwrite it, now sub = [2, 3, 8].
    //4 is less than previous number, so we can't extend the subsequence sub. We overwrite 8 by 4, so sub = [2, 3, 4].
    //5 is greater than previous number, sub = [2, 3, 4, 5].
    //1 is less than previous number, so we can't extend the subsequence sub. We overwrite 2 by 1, so sub = [1, 3, 4, 5].
    //Finally, length of longest increase subsequence = len(sub) = 4.

    public int lengthOfLISV2(int[] nums) {

        List<Integer> lisSub = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(lisSub.isEmpty() || curr > lisSub.get(lisSub.size() -1)){
                lisSub.add(curr);
            }
            else{
                int insertIndex = upperBoundBinarySearch(lisSub, curr);
                lisSub.set(insertIndex, curr);
            }
        }

        return lisSub.size();
    }

    private int upperBoundBinarySearch(List<Integer> lisSub, int target){

        int low = 0;
        int high = lisSub.size() -1;

        // For lower bound will try to go left , will set high = mid
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (lisSub.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence increasingSubsequence = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Longest Increasing Subsequence is " + increasingSubsequence.lengthOfLIS(nums));
        System.out.println("Longest Increasing Subsequence is " + increasingSubsequence.lengthOfLISV2(nums));

    }
}
