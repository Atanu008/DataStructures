package org.atanu.java.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
//LeetCode 104
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //BFS Version
    public int maxDepthV2(TreeNode root) {

        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maximumTreeDepth = 0;
        while (!queue.isEmpty()) {
            maximumTreeDepth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
        }

        return maximumTreeDepth;
    }
}
