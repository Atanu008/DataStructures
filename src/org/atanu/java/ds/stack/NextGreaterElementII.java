package org.atanu.java.ds.stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-ii/
//LeetCode 503
public class NextGreaterElementII {

    //From Right To Left. I like this :)
    public int[] nextGreaterElements(int[] nums) {

        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 2*nums.length -1; i >=0; i--) {

            //Maintain a Monotonic Increasing Stack
            // pop elements that aren't greater than the current element
            while(!stack.isEmpty() && stack.peek() <= nums[i%nums.length]){
                stack.pop();
            }
            // If Stack in NOT empty the the next greater element is now on the top of the stack
            result[i%nums.length] = !stack.isEmpty() ? stack.peek() : -1;
            // push current element into the stack
            stack.push(nums[i%nums.length]);
        }

        return result;
    }

    //Fro Left To Right.
    public int[] nextGreaterElementsV2(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for(int i = 0; i < 2*nums.length; i++) {

            //Maintain a Monotonic Decreasing  Stack
            // Keep popping elements from the stack smaller than the current
            // element, and set their next greater element to the current element
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%nums.length]) {
                result[stack.pop()] = nums[i%nums.length];
            }
            // push current element Index into the stack
            stack.push(i%nums.length);
        }

        //Elements in the stack has No greater Element, mark -1 for them
        //Not sure why this is not working. Need more debugging
       /* while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }*/
        return result;
    }
}
