package org.atanu.java.ds.binarytree;

//Initialize a function dfs, as well as a variable numGoodNodes that keeps track of how many good nodes are in the tree.
//The function should take two arguments: a node node, and an integer representing the greatest value in the path leading from the root to the current node maxSoFar.

//For each call to the function, first check if maxSoFar <= node.val. If so, increment numGoodNodes.
//Next, call dfs(child, max(node.val, maxSoFar)) for all children of the current node.
//Call dfs(root, INT_MIN) and return numGoodNodes.

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
//LeetCode 1448
public class CountGoodNodesInBinaryTree {

    int countGoodNodes = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return countGoodNodes;
    }

    private void dfs(TreeNode root, int maxSoFar){

        if(root.val >= maxSoFar){
            countGoodNodes++;
        }

        if(root.left != null){
            dfs(root.left, Math.max(root.val, maxSoFar));
        }

        if(root.right != null){
            dfs(root.right, Math.max(root.val, maxSoFar));
        }
    }
}
