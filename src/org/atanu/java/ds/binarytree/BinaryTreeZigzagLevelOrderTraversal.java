package org.atanu.java.ds.binarytree;

import java.util.*;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//LeetCode 103
public class BinaryTreeZigzagLevelOrderTraversal {

    //BFS Traversal just use boolean flag to flip the ordering in each level
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean zigzag = false;
        while(!queue.isEmpty()){

            LinkedList<Integer> levelNodes = new LinkedList<>();
            int size = queue.size();
            while(size -->0){
                TreeNode current = queue.poll();
                if(zigzag){
                    levelNodes.addFirst(current.val); //Same as add(0,val) in ArrayList
                }
                else{
                    levelNodes.addLast(current.val);//Same as add()
                }

                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
            }

            result.add(levelNodes);
            zigzag = !zigzag; //Flip it
        }

        return result;
    }
}
