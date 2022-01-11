package org.atanu.java.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//LeetCode 116
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
//LeetCode 117
//Both having same solution
public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            // Iterate over all the nodes on the current level
            for(int i = 0; i < size; i++){

                Node current = queue.poll();

                // This check is important. We don't want to
                // establish any wrong connections. The queue will
                // contain nodes from 2 levels at most at any
                // point in time. This check ensures we only
                // don't establish next pointers beyond the end
                // of a level
                if(i < size -1){
                    current.next = queue.peek();
                }

                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
            }
        }

        return root;
    }

    //Maitaining a prev variable
    public Node connectV2(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node prev = null; // This is imp. for every level right most nodes next pointer will be null
            int size = queue.size();
            // Iterate over all the nodes on the current level
            while(size --> 0){

                Node current = queue.poll();
                current.next = prev;
                prev = current;

                if(current.right != null){
                    queue.offer(current.right);
                }

                if(current.left != null){
                    queue.offer(current.left);
                }

            }
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
