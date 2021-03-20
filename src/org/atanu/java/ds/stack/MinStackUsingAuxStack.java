package org.atanu.java.ds.stack;


import java.util.Stack;


public class MinStackUsingAuxStack {

    Stack<Integer> original = new Stack<>();
    Stack<Integer> minimum = new Stack<>();

    public boolean push(int data) {

        original.push(data);

        if (minimum.isEmpty() || minimum.peek() >= data)
            minimum.push(data);

        return true;

    }

    public int pop() {

        int top = original.pop();

        if (top == minimum.peek())
            minimum.pop();

        return top;
    }

    public int top() {

        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return original.peek();
    }

    public int getMin() {

        if (minimum.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return minimum.peek();
    }

    public boolean isEmpty() {

        return original.isEmpty();
    }


    public static void main(String[] args) {


        MinStackUsingAuxStack s = new MinStackUsingAuxStack();

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
