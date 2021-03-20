package org.atanu.java.ds.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostorder {

    int index = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        index = inorder.length - 1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeHelper(postorder, 0, inorder.length - 1, map);

    }

    public TreeNode buildTreeHelper(int[] postorder, int start, int end, Map<Integer, Integer> map) {

        if (start > end) {
            return null;
        }
        System.out.println("Start " + start + " End  " + end + " Index " + index);
        TreeNode root = new TreeNode(postorder[index--]);
        int rootIndex = map.get(root.data);
        root.right = buildTreeHelper(postorder, rootIndex + 1, end, map);
        root.left = buildTreeHelper(postorder, start, rootIndex - 1, map);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        ConstructBinaryTreeFromPostorder construct = new ConstructBinaryTreeFromPostorder();
        TreeNode root = construct.buildTree(inorder, postorder);

        System.out.println("InOrder");
        TreeNode.inOrder(root);
        System.out.println("\nPostOrder");
        TreeNode.postOrder(root);
    }
}