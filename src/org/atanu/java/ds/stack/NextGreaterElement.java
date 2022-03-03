package org.atanu.java.ds.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    //From Right To Left
    //Monotonic Increasing Stack
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
    public int[] nextGreaterElementV2(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {

            //Maintain a Monotonic Decreasing  Stack
            // Keep popping elements from the stack smaller than the current
            // element, and set their next greater element to the current element
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            // push current element Index into the stack
            stack.push(i);
        }

        //Elements in the stack has No greater Element, mark -1 for them
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] input = { 2, 7, 3, 5, 4, 6, 8 };

        int[] result = nextGreaterElement.nextGreaterElement(input);
        System.out.println(Arrays.toString(result));

        result = nextGreaterElement.nextGreaterElementV2(input);
        System.out.println(Arrays.toString(result));
    }
}
