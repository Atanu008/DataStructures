package org.atanu.java.ds.stack;

public class StackUsingArray {

    private int[] array;
    private int top;
    private int capacity;


    public StackUsingArray() {
        array = new int[10];
        top = -1;
        capacity = 10;
    }

    public StackUsingArray(int capacity) {
        array = new int[capacity];
        top = -1;
        this.capacity = capacity;
    }

    public boolean push(int data) {

        if (isFull()) {
            System.out.println("Stack is full");
            return false;
        }

        array[++top] = data;
        return true;
    }

    public int pop() {

        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return array[top--];

    }

    public int top() {

        if (!isEmpty())
            return array[top];
        else
            return -1;
    }

    public boolean isEmpty() {

        return top == -1;
    }

    public boolean isFull() {

        return top == capacity - 1;
    }

    public int size() {

        return top + 1;
    }


    public static void main(String... args) {

        StackUsingArray stack = new StackUsingArray(3);

        stack.push(1);        // Inserting 1 in the stack
        stack.push(2);        // Inserting 2 in the stack

        stack.push(8);
        int popped = stack.pop();        // removing the top 2
        System.out.println("Popped " + popped);

        stack.pop();        // removing the top 8

        //stack.push(9);		// Inserting 9 in the stack

        System.out.println("Top element is: " + stack.top());
        System.out.println("Stack size is " + stack.size());

        stack.pop();        // removing the top 3

        // check if stack is empty
        if (stack.isEmpty())
            System.out.println("Stack Is Empty");
        else
            System.out.println("Stack Is Not Empty");
    }
}
