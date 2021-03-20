package org.atanu.java.ds.avltree;

public class TreeNode {

    int data, height;

    TreeNode left, right;

    TreeNode(int key) {

        data = key;
        height = 1;
    }

    public static void inOrder(TreeNode root) {

        if (root == null) {

            return;
        }

        inOrder(root.left);

        System.out.print(root.data + " ");

        inOrder(root.right);
    }
}
