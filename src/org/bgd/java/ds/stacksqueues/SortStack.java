package org.bgd.java.ds.stacksqueues;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/problems/sort-a-stack/1
 *
 * Given a stack, the task is to sort it such that the top of the stack has the greatest element.
 *
 * Example 1:
 *
 * Input:
 * Stack: 3 2 1
 * Output: 3 2 1
 * Example 2:
 *
 * Input:
 * Stack: 11 2 32 3 41
 * Output: 41 32 11 3 2
 */
public class SortStack {
    public Stack<Integer> sort(Stack<Integer> s) {
        sortStack(s);
        return s;
    }

    private void sortStack(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int top = s.pop();
            sortStack(s);

            insertSorted(s, top);
        }
    }

    private void insertSorted(Stack<Integer> s, int val) {
        if (s.isEmpty() || s.peek() < val) {
            s.push(val);
            return;
        }

        int top = s.pop();
        insertSorted(s, val);
        s.push(top);
    }
}
