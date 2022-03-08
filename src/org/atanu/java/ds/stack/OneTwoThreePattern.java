package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/132-pattern/submissions/
//LeetCode 456
//https://leetcode.com/problems/132-pattern/discuss/906789/Short-Java-O(N)-Solution-with-Detailed-Explanation-and-Sample-Test-Case-or-Stack-or-100
public class OneTwoThreePattern {

    //Basically, the top of stack is containing the highest number so far, i.e. 3
    //and second is containing the second highest number after the highest number, i.e. 2.
    //So, this satisfies the 32 pattern.
    //Now, we will just keep updating second and stack top
    //when we encounter a number which is greater than the highest number.
    public boolean find132pattern(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int secondElement = Integer.MIN_VALUE;

        for(int i = nums.length -1; i >= 0; i--) {

            if(nums[i] < secondElement ){
                return true;
            }
            //Stack will be onotonicly Decreasing.
            while(!stack.isEmpty() &&  nums[i] > stack.peek()) {
                secondElement = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }

    //Brute Force
    public boolean find132patternV2(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length;  j++) {
                for(int k = j+1; k < nums.length; k++){
                    if(nums[i] < nums[j] && nums[j] > nums[k] && nums[k] > nums[i]){
                        System.out.println(nums[i] + " "+ nums[j] + " "+ nums[k]);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
