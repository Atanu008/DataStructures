package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/max-stack/
//LeetCode 716
public class MaxStack {

    Stack<Integer> originalStack;
    Stack<Integer> maxStack;

    public MaxStack() {

        originalStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        originalStack.push(x);
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
    }

    public int pop() {

        maxStack.pop();
        return originalStack.pop();
    }

    public int top() {
        return originalStack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {

        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}
