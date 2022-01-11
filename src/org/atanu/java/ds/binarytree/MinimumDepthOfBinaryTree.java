package org.atanu.java.ds.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/
//LeetCode 111
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        if(root.left == null){
            return 1 + minDepth(root.right);
        }

        if(root.right == null){
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    //BFS Solution
    public int minDepthV2(TreeNode root) {

        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size --> 0){

                TreeNode current = queue.poll();
                //Return Depth when we first Encounter the first Leaf Node
                //Thats the minimum Depth
                if(current.left == null && current.right == null){
                    return depth;
                }

                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
            }

            depth++;
        }

        return 0;
    }
}
