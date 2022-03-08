package org.atanu.java.ds.stack;

//https://leetcode.com/problems/min-stack/
//leetCode 155
public class MinStackV2 {

    class Node {
        int val;
        Node next;
        int minValue;

        Node(int val, Node next, int minValue) {
            this.val = val;
            this.next = next;
            this.minValue = minValue;
        }
    }

    Node head;
    public MinStackV2() {

        head = null;
    }

    public void push(int val) {

        if(head == null) {
            head = new Node(val, null , val);
        }
        else {
            head = new Node(val, head, Math.min(head.minValue, val));
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.minValue;
    }
}
