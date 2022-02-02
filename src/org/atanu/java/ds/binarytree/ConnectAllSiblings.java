package org.atanu.java.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://www.educative.io/courses/grokking-the-coding-interview/qVxy1qop77p

//Kinda same as PopulatingNextRightPointersInEachNode
//The only difference will be that
//while traversing we will remember (irrespective of the level) the previous node
//to connect it with the current node
public class ConnectAllSiblings {

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int x) {
            val = x;
            left = right = next = null;
        }

        // tree traversal using 'next' pointer
        public void printTree() {
            Node current = this;
            System.out.print("Traversal using 'next' pointer: ");
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
        }
    }

    ;

    public static void connect(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node currentNode = null, previousNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (previousNode != null)
                previousNode.next = currentNode;
            previousNode = currentNode;

            // insert the children of current node in the queue
            if (currentNode.left != null)
                queue.offer(currentNode.left);
            if (currentNode.right != null)
                queue.offer(currentNode.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        ConnectAllSiblings.connect(root);
        root.printTree();
    }


}
