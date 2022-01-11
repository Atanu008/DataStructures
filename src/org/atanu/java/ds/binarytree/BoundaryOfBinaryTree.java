package org.atanu.java.ds.binarytree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/boundary-of-binary-tree/
//LeetCode 545
public class BoundaryOfBinaryTree {
    List<Integer> nodes = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if(root == null) return nodes;

        nodes.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return nodes;
    }
    public void leftBoundary(TreeNode root) {
        if(root == null) return;
        // if leaf node, ignore while printing edges
        if(root.right == null && root.left == null){
            return;
        }
        nodes.add(root.val); //Add First for Left Boundary
        if(root.left != null){
            leftBoundary(root.left);
        }
        else{
            leftBoundary(root.right);
        }
    }
    public void rightBoundary(TreeNode root) {
        if(root == null) return;
        // if leaf node, ignore while printing edges
        if(root.right == null && root.left == null){
            return;
        }
        //Check Right First
        if(root.right != null){
            rightBoundary(root.right);
        }
        else{
            rightBoundary(root.left);
        }
        nodes.add(root.val); // add after child visit(reverse) For Right
    }
    public void leaves(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
}
