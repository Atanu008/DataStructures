package org.atanu.java.ds.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/
//LeetCode 496
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] nextGreaterElements = nextGreaterElement(nums2);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], nextGreaterElements[i]);
        }

        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    public int[] nextGreaterElement(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int result[] = new int[nums.length];

        for(int i = nums.length -1; i >=0; i--) {
            //Maintain a Monotonic Increasing Stack
            // pop elements that aren't greater than the current element
            while(!stack.isEmpty() && stack.peek() < nums[i]) {
                stack.pop();
            }

            // If Stack in NOT empty the the next greater element is now on the top of the stack
            result[i] = stack.isEmpty() ? -1: stack.peek();
            // push current element into the stack
            stack.push(nums[i]);
        }

        return result;
    }

    //Left To Right Solution. Maintain MMonotonic Decreasing Stack
    //https://www.youtube.com/watch?v=sDKpIO2HGq0&t=3s
    public int[] nextGreaterElementV2(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums2.length; i++){

            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }

            stack.push(nums2[i]);
        }

        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

}
