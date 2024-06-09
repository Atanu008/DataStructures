package org.bgd.java.ds.stacksqueues;

/**
 * <a href="https://leetcode.com/problems/min-stack/">...</a>
 *
 * This is a Space Optimised version of Min Stack with a Custom node class which tracks the node value and min
 */

public class MinStackSpaceOptimised {
    class MinStack {
        private Node head;

        public void push(int x) {
            if (head == null)
                head = new Node(x, x, null);
            else
                head = new Node(x, Math.min(x, head.min), head);
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        private static class Node {
            int val;
            int min;
            Node next;

            private Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }
}
