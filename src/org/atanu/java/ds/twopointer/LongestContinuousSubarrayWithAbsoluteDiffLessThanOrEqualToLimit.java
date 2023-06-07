package org.atanu.java.ds.twopointer;

// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
// Leetcode 1438
// Video : https://www.youtube.com/watch?v=LDFZm4iB7tA

import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> decreseaingQueue = new LinkedList<>();
        Deque<Integer> increasingQueue = new LinkedList<>();

        int high = 0;
        int low = 0;

        int longest = 0;
        while(high < nums.length){

            while(!decreseaingQueue.isEmpty() && decreseaingQueue.peekLast() < nums[high]){
                decreseaingQueue.pollLast();
            }
            decreseaingQueue.addLast(nums[high]);

            while(!increasingQueue.isEmpty() && increasingQueue.peekLast() > nums[high]){
                increasingQueue.pollLast();
            }
            increasingQueue.addLast(nums[high]);


            while(decreseaingQueue.peekFirst() - increasingQueue.peekFirst() > limit){
                if(decreseaingQueue.peekFirst() == nums[low]) decreseaingQueue.pollFirst();
                if(increasingQueue.peekFirst() == nums[low]) increasingQueue.pollFirst();
                low++;
            }

            longest = Math.max(longest, high - low + 1);

            high++;
        }

        return longest;
    }
}
