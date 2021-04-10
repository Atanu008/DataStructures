package org.atanu.java.ds.design;

import java.util.ArrayList;
import java.util.List;

//LeetCode 173
//https://leetcode.com/problems/binary-search-tree-iterator/
public class BSTIterator {
    List<Integer> inOrderList;
    int index;

    public BSTIterator(TreeNode root) {
        inOrderList = new ArrayList<>();
        index = 0;
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        inOrderList.add(node.val);
        inOrder(node.right);
    }

    public int next() {
        return inOrderList.get(index++);
    }

    public boolean hasNext() {
        return index < inOrderList.size();
    }

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


