package org.atanu.java.ds.stack;

public class StackUsingLinkedList {

    Node top;

    private class Node {

        int data;
        Node next;

        Node() {
        }
    }

    public boolean push(int data) {

        Node node = new Node();

        node.data = data;
        node.next = top;

        top = node;

        return true;

    }

    public int pop() {

        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        int retVal = top.data;

        top = top.next;

        return retVal;

    }

    public int top() {

        if (!isEmpty())
            return top.data;
        else
            return -1;
    }

    private boolean isEmpty() {

        return top == null;
    }

    public static void main(String[] args) {

        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(1);        // Inserting 1 in the stack
        stack.push(2);        // Inserting 2 in the stack

        stack.push(8);
        int popped = stack.pop();        // removing the top 8
        System.out.println("Popped " + popped);

        stack.pop();        // removing the top 2

        //stack.push(9);		// Inserting 9 in the stack

        System.out.println("Top element is: " + stack.top());
        //System.out.println("Stack size is " + stack.size());

        stack.pop();        // removing the top 3

    }

}
