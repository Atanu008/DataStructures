package org.atanu.java.ds.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/find-all-the-lonely-nodes/
//LeetCode 1469
//Check Premium
public class FindAllTheLonelyNodes {

    //BFS . Intuitive
    public List<Integer> getLonelyNodes(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){

            TreeNode current = queue.poll();

            if(current.left != null){
                queue.offer(current.left);
                if(current.right == null){
                    result.add(current.left.val);
                }
            }

            if(current.right != null){
                queue.offer(current.right);
                if(current.left == null){
                    result.add(current.right.val);
                }
            }
        }

        return result;
    }


    //Recursion
    public List<Integer> getLonelyNodesV2(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        getLonelyNodes(root, false, nodes); // root is not lonely
        return nodes;
    }

    private void getLonelyNodes(TreeNode root, boolean isLonely, List<Integer> nodes) {
        if (root == null) return;

        if (isLonely) {
            nodes.add(root.val);
        }

        getLonelyNodes(root.left, root.right == null, nodes);
        getLonelyNodes(root.right, root.left == null, nodes);
    }
}
