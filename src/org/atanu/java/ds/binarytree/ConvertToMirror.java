package org.atanu.java.ds.binarytree;

//LeetCode 226 Invert Binary Tree
//https://leetcode.com/problems/invert-binary-tree/
public class ConvertToMirror {

    //Traverse the tree in PostOrder fashion and swap its left and right child recursively
    public static void convertToMirror(TreeNode root) {

        if (root == null)
            return;

        convertToMirror(root.left);

        convertToMirror(root.right);

        swap(root);
    }

    public static void swap(TreeNode root) {

        if (root == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

    }

    public static void preOrder(TreeNode root) {

        if (root == null)
            return;

        System.out.print(root.data);

        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {


		   /* Construct below tree
        1
      /   \
     /     \
    2       3
   / \     / \
  4   5   6   7   */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        preOrder(root);

        System.out.println();
        convertToMirror(root);
        preOrder(root);

    }

}
