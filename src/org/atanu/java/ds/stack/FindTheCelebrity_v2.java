package org.atanu.java.ds.stack;

// https://leetcode.com/problems/find-the-celebrity/description/
// Leetcode 277

import java.util.Stack;

public class FindTheCelebrity_v2 {

    public int findCelebrity(int n) {

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            // if a knows b , a can not be celebrity, b is possibility , push b
            if (knows(a, b)) {
                stack.push(b);
            } else { // if b knows a , b can not be celebrity, a is possibility , push a
                stack.push(a);
            }

        }

        int candidate = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate)))
                return -1;
        }
        return candidate;
    }

    private boolean knows(int candidate, int i) {
        return true;
    }
}
