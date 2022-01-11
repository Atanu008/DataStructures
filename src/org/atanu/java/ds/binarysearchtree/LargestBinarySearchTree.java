package org.atanu.java.ds.binarysearchtree;

public class LargestBinarySearchTree {

    public static int size(TreeNode root) {

        if (root == null) {

            return 0;
        }

        int leftSize = size(root.left);
        int rightSize = size(root.right);

        return 1 + leftSize + rightSize;
    }

    public static boolean isBST(TreeNode root, int minKey, int maxKey) {

        if (root == null) {

            return true;
        }

        if (root.val < minKey || root.val > maxKey) {
            return false;
        }

        return isBST(root.left, minKey, root.val) && isBST(root.right, root.val, maxKey);

    }

    public static int findLargestBST(TreeNode root) {

        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {

            return size(root);
        }

        return Math.max(findLargestBST(root.left), findLargestBST(root.right));

    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(15);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(14);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(7);
        root.right.right.right = new TreeNode(10);

        System.out.print("The size of the largest BST is " +
                findLargestBST(root));

    }

}
