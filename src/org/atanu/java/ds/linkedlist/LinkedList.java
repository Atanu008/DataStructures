package org.atanu.java.ds.linkedlist;


public class LinkedList {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
        }

        Node(int d, Node next) {
            data = d;
            this.next = next;
        }

        Node() {
        }
    }

    public void push(int new_data) {

        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void append(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new_node;
            return;
        }
        Node last = head;

        while (last.next != null) {
            last = last.next;
        }

        last.next = new_node;
    }

    public static void printList(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printList(node.next);
        }
    }
}