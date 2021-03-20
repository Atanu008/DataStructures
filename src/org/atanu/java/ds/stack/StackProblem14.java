package org.atanu.java.ds.stack;

import java.util.Stack;

public class StackProblem14 {

    public static void sortStack(Stack<Integer> stack) {

        if (stack.isEmpty())
            return;

        int top = stack.pop();

        sortStack(stack);

        sortInserted(stack, top);
    }

    public static void sortInserted(Stack<Integer> stack, int data) {

        if (stack.isEmpty() || data <= stack.peek()) {
            stack.push(data);
            return;
        }

        int top = stack.pop();

        sortInserted(stack, data);

        stack.push(top);


    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(8);
        stack.push(9);
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        sortStack(stack);

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

}
