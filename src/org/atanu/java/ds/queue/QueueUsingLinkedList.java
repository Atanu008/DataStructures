package org.atanu.java.ds.queue;

public class QueueUsingLinkedList {

    private class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    Node rear, front;
    int size;

    public QueueUsingLinkedList() {

        rear = null;
        front = null;
        size = 0;
    }

    public void enqueue(int data) {


        Node node = new Node(data);

        // special case: queue was empty
        if (isEmpty()) {
            // initialize both front and rear
            front = rear = node;
        } else {
            // update rear
            rear.next = node;
            rear = node; // rear = rear.next
        }

        size++;

    }

    public int dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }


        int retVal = front.data;

        // advance front to the next node
        front = front.next;

        // if list becomes empty
        if (front == null) {
            rear = null;
        }

        System.out.println("Removing " + retVal);

        size--;
        return retVal;

    }


    private int peek() {

        if (isEmpty()) {
            System.out.println("UnderFlow\nProgram Terminated");

        }
        return front.data;
    }

    public boolean isEmpty() {

        return rear == null && front == null;
    }

    public int size() {

        return size;
    }

    public static void main(String[] args) {


        QueueUsingLinkedList q = new QueueUsingLinkedList();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        System.out.println("Front element is: " + q.peek());
        q.dequeue();
        System.out.println("Front element is: " + q.peek());

        System.out.println("Queue size is " + q.size());

        q.dequeue();
        q.dequeue();

        System.out.println("Front element is: " + q.peek());

        q.dequeue();
        if (q.isEmpty())
            System.out.println("Queue Is Empty");
        else
            System.out.println("Queue Is Not Empty");

    }


}
