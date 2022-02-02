package org.atanu.java.ds.binarytree;

import java.util.*;

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
//LeetCode 107
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){

            LinkedList<Integer> levelNodes = new LinkedList<>();
            int size = queue.size();
            while(size -->0){
                TreeNode current = queue.poll();
                levelNodes.addLast(current.val);
                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
            }
            // append the current level at the beginning
            result.add(0,levelNodes); //this the trick :)
        }

        return result;
    }
}
