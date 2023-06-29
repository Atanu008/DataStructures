package org.atanu.java.ds.binarytree;

// https://leetcode.com/problems/diameter-of-binary-tree/description/
// Leetcode 543

// Video : https://www.youtube.com/watch?v=Rezetez59Nk . Can refer

// the current node's both left and right branches might be a part of the longest path;
// one of the current node's left/right branches might be a part of the longest path.

// Initalize an integer variable diameter to keep track of the longest path we find from the DFS.
//Implement a recursive function longestPath which takes a TreeNode as input. It should recursively explore the entire tree rooted at the given node. Once it's finished, it should return the longest path out of its left and right branches:
//if node is None, we have reached the end of the tree, hence we should return 0;
//we want to recursively explore node's children, so we call longestPath again with node's left and right children. In return, we get the longest path of its left and right children leftPath and rightPath;
//if leftPath plus rightPath is longer than the current longest diameter found, then we need to update diameter;
//finally, we return the longer one of leftPath and rightPath. Remember to add 111 as the edge connecting it with its parent.
//Call longestPath with root.
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        longestPath(root, diameter);
        return diameter[0];
    }

    private int longestPath(TreeNode root, int[] diameter){

        if(root == null){
            return 0;
        }
        // recursively find the longest path in
        // both left child and right child
        int leftPath = longestPath(root.left, diameter);
        int rightPath = longestPath(root.right, diameter);
        // update the diameter if left_path plus right_path is larger
        diameter[0] = Math.max(diameter[0], leftPath + rightPath);
        // return the longest one between left_path and right_path;
        // remember to add 1 for the path connecting the node and its parent
        return 1 + Math.max(leftPath, rightPath);

    }
}
