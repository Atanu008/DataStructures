package org.atanu.java.ds.binarytree;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/univalued-binary-tree/
//LeetCode 965
public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> visited = new HashSet<>();
        preOrder(root, visited);
        return visited.size() == 1;
    }

    private void preOrder(TreeNode root, Set<Integer> visited){
        if(root == null){
            return;
        }

        visited.add(root.val);
        preOrder(root.left, visited);
        preOrder(root.right, visited);
    }

    public boolean isUnivalTreeV2(TreeNode root) {
        boolean leftTree = (root.left == null || (root.val == root.left.val && isUnivalTreeV2(root.left)));
        boolean rightTree = (root.right == null || (root.val == root.right.val && isUnivalTreeV2(root.right)));

        return leftTree && rightTree;
    }
}
