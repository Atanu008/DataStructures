package org.bgd.java.ds.stacksqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-i/description/">...</a>
 * 496. Next Greater Element I
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 */

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> nextGreater = new HashMap<>();
        for(int i : nums2) {
            while(!stack.isEmpty() && stack.peek() < i) {
                nextGreater.put(stack.pop(), i);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
        }
        int[] result = new int[nums1.length];
        int k = 0;
        for(int i : nums1) {
            result[k++] = nextGreater.get(i);
        }
        return result;
    }
}
