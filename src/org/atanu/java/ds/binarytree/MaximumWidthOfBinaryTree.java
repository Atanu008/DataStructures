package org.atanu.java.ds.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/maximum-width-of-binary-tree/
//LeetCode 662
//If Index of one node is i then left can be represented as (2.i) and right is (2.i +1)
//Full Binary
//Node we need to get the difference of last first and last nodes in last level using level order traversal

public class MaximumWidthOfBinaryTree {

    static class Node{
        TreeNode node;
        int index;
        public Node(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {

        Queue<Node> queue = new ArrayDeque<>();
        Node rootNode = new Node(root, 1);
        queue.offer(rootNode);
        int maxWidth = 0;
        while(!queue.isEmpty()){
            Node first = queue.peek();
            int size = queue.size();
            Node current = null;
            while(size -->0){

                current = queue.poll();
                if(current.node.left != null){
                    Node leftNode = new Node(current.node.left, current.index*2);
                    queue.offer(leftNode);
                }
                if(current.node.right != null){
                    Node rightNode = new Node(current.node.right, current.index*2 +1);
                    queue.offer(rightNode);
                }

            }

            maxWidth = Math.max(maxWidth, current.index - first.index +1);
        }

        return maxWidth;
    }
}
