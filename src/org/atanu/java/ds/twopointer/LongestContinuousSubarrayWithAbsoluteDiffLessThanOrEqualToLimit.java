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

        int windowEnd = 0;
        int windowStart = 0;

        int longest = 0;
        while(windowEnd < nums.length){

            while(!decreseaingQueue.isEmpty() && decreseaingQueue.peekLast() < nums[windowEnd]){
                decreseaingQueue.pollLast();
            }
            decreseaingQueue.addLast(nums[windowEnd]);

            while(!increasingQueue.isEmpty() && increasingQueue.peekLast() > nums[windowEnd]){
                increasingQueue.pollLast();
            }
            increasingQueue.addLast(nums[windowEnd]);


            while(decreseaingQueue.peekFirst() - increasingQueue.peekFirst() > limit){
                if(decreseaingQueue.peekFirst() == nums[windowStart]) decreseaingQueue.pollFirst();
                if(increasingQueue.peekFirst() == nums[windowStart]) increasingQueue.pollFirst();
                windowStart++;
            }

            longest = Math.max(longest, windowEnd - windowEnd + 1);

            windowEnd++;
        }

        return longest;
    }
}
