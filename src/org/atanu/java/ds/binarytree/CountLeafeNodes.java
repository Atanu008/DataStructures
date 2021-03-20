package org.atanu.java.ds.binarytree;

public class CountLeafeNodes {

    public static int countLeafeNodes(TreeNode root) {

        if (root == null) {

            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        } else {
            return countLeafeNodes(root.left) + countLeafeNodes(root.right);
        }

    }

    public static void main(String[] args) {
		/* Construct below tree
        1
      /   \
     /     \
    2       3
   / \     / \
  4   5   6   7   */

        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);
        a.right.left = new TreeNode(6);
        a.right.right = new TreeNode(7);

        int result = countLeafeNodes(a);

        System.out.println("No of Leafe Nodes " + result);

    }

}
