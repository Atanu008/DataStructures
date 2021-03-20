package org.atanu.java.ds.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreeFromPreorder {

    // static int pIndex = 0; // AtomicInteger pIndex = new AtomicInteger(0); Thread safe

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        // create a map to efficiently find the index of any element in
        // given inorder sequence
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // pIndex stores index of next unprocessed node in preorder sequence
        // start with root node (present at 0'th index)
        AtomicInteger pIndex = new AtomicInteger(0);
        return buildTreeHelper(preorder, 0, inorder.length - 1, pIndex, map);
    }

    public static TreeNode buildTreeHelper(int[] preorder, int start, int end, AtomicInteger pIndex, Map<Integer, Integer> map) {

        if (start > end) {
            return null;
        }

        // The next element in preorder[] will be the root node of subtree
        // formed by inorder[start, end]
        TreeNode root = new TreeNode(preorder[pIndex.getAndIncrement()]);

        // get the index of root node in inorder[] to determine the
        // boundary of left and right subtree
        int index = map.get(root.data);

        // recursively construct the left and right subtree
        root.left = buildTreeHelper(preorder, start, index - 1, pIndex, map);
        root.right = buildTreeHelper(preorder, index + 1, end, pIndex, map);

        // return current node
        return root;

    }

    public static void main(String[] args) {
        int[] inorder = {4, 2, 1, 7, 5, 8, 3, 6};
        int[] preorder = {1, 2, 4, 3, 5, 7, 8, 6};

        TreeNode root = buildTree(preorder, inorder);

        System.out.println("InOrder");
        TreeNode.inOrder(root);
        System.out.println("\nPreOrder");
        TreeNode.preOrder(root);
    }
}