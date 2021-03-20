package org.atanu.java.ds.queue;

public class QueueUsingArray {

    int array[];
    int front;    // front points to front element in the queue
    int rear; // rear points to last element in the queue
    int capacity;
    int size;

    public QueueUsingArray(int capacity) {

        array = new int[capacity];
        front = 0;
        rear = -1;
        this.capacity = capacity;
        size = 0;
    }

    public void enqueue(int data) {

        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        rear = (rear + 1) % capacity;
        array[rear] = data;
        size++;

    }

    public int dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }


        int retVal = array[front];

        front = (front + 1) % capacity;
        size--;

        System.out.println("Removing " + retVal);
        return retVal;

    }

    private int peek() {

        if (isEmpty()) {
            System.out.println("UnderFlow\nProgram Terminated");

        }
        return array[front];
    }

    public boolean isEmpty() {

        return size() == 0;
    }

    public boolean isFull() {

        return size() == capacity;
    }

    public int size() {

        return size;
    }

    public static void main(String[] args) {


        // create a queue of capacity 5
        QueueUsingArray q = new QueueUsingArray(5);

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
