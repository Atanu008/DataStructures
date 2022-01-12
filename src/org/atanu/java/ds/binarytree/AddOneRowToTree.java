package org.atanu.java.ds.binarytree;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/add-one-row-to-tree/
//LeetCode 623
public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentDepth = 1;
        while(!queue.isEmpty() && currentDepth < d - 1){
            int size = queue.size();
            while(size > 0)
            {
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
            currentDepth++;

        }

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = new TreeNode(v);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(v);
            node.right.right = temp;
        }

        return root;
    }
}
