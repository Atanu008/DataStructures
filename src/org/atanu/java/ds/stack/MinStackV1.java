package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
//LeetCode 155
public class MinStackV1 {

    Stack<Integer> originalStack;
    Stack<Integer> minStack;

    public MinStackV1() {
        originalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        originalStack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {

        int top = originalStack.pop();
        if(minStack.peek() == top) {
            minStack.pop();
        }
    }

    public int top() {
        return originalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
