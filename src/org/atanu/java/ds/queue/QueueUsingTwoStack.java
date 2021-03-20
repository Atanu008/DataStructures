package org.atanu.java.ds.queue;

import java.util.Stack;

public class QueueUsingTwoStack {

    Stack<Integer> original = new Stack<>();
    Stack<Integer> aux = new Stack<>();

    public void enQueue(int data) {
        while (!original.isEmpty()) {
            aux.push(original.pop());
        }

        original.push(data);

        while (!aux.isEmpty())
            original.push(aux.pop());
    }

    public int deQueue() {
        if (original.isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(0);
        }

        return original.pop();
    }

    public int peek() {
        if (original.isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(0);
        }

        return original.peek();
    }

    public static void main(String[] args) {


        int[] keys = {1, 2, 3, 4};

        // insert above keys into the stack
        QueueUsingTwoStack queue = new QueueUsingTwoStack();
        for (int key : keys) {
            queue.enQueue(key);
        }

        for (int i = 0; i <= keys.length; i++) {
            System.out.println(queue.deQueue());
        }
    }

}
