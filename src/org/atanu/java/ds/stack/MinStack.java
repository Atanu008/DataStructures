package org.atanu.java.ds.stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    private int min;

    public boolean push(int data) {

        if (stack.isEmpty()) {
            stack.push(data);
            min = data;
        } else {
            if (data < min) {
                int minElement = 2 * data - min;
                stack.push(minElement);
                min = data;
            } else {
                stack.push(data);
            }
        }

        return true;

    }

    public int pop() {

        int top = stack.pop();

        if (top > min)
            return top;
        else {
            min = 2 * min - top;
            return min;
        }

    }

    public int top() {

        int top = stack.peek();

        if (top < min)
            return min;
        else
            return top;
    }

    public int getMin() {

        return min;
    }

    public static void main(String[] args) {

        MinStack s = new MinStack();

        s.push(6);
        System.out.println(s.getMin());    // prints 6

        s.push(7);
        System.out.println(s.getMin());    // prints 6

        s.push(8);
        System.out.println(s.getMin());    // prints 6

        s.push(5);
        System.out.println(s.getMin());    // prints 5

        s.push(3);
        System.out.println(s.getMin());    // prints 3

        s.pop();
        System.out.println(s.getMin());    // prints 5

        s.push(10);
        System.out.println(s.getMin());    // prints 5

        s.pop();
        System.out.println(s.getMin());    // prints 5

        s.pop();
        System.out.println(s.getMin());    // prints 6

    }

}
