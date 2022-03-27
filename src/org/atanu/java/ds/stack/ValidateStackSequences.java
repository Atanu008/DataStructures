package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/validate-stack-sequences/
//LeetCode 946
//https://www.educative.io/courses/decode-coding-interview-java/YMMgkVzrYx2
public class ValidateStackSequences {

    //Declare an empty stack.
    //Remove the element from the front of the pushed array and push it onto the stack.
    //If the element at the top of the stack is the same as the item at the front of the popped array, pop the element from the stack and remove it from the popped array.
    //If the stack is empty by the end, return true.
    //Otherwise, return false.
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if(pushed.length != popped.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushOp = {1,2,3,4,5};
        int[] popOp = {5,4,3,2,1};

        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        if (validateStackSequences.validateStackSequences(pushOp, popOp))
            System.out.println( "Sequence Valid!" );
        else
            System.out.println( "Not Valid" );
    }
}
