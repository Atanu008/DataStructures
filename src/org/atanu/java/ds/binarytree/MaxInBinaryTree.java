package org.atanu.java.ds.binarytree;

public class MaxInBinaryTree {

    public static int maxInBinaryTree(TreeNode root) {

        int max = Integer.MIN_VALUE;

        if (root != null) {

            int left = maxInBinaryTree(root.left);

            int right = maxInBinaryTree(root.right);

            return Math.max(root.val, Math.max(left, right));

        }

        return max;

    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(69);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);

        System.out.println(" Max element is  " + maxInBinaryTree(root));

    }

}
