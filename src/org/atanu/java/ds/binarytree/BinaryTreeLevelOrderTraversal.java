package org.atanu.java.ds.binarytree;

import java.util.*;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
//LeetCode 102
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
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

            result.add(levelNodes);
        }

        return result;
    }
}
