package org.atanu.java.ds.binarytree;

//Time Complexity: Time worst case complexity of above solution is O(mn) where m and n are number of nodes in given two trees.

public class CheckSubTree {

    public static boolean isSubTree(TreeNode mainTree, TreeNode subTree) {

        if (subTree == null) {
            return true;
        }

        //here subTree is not equeal to null and Maintree is null .
        if (mainTree == null) {
            return false;
        }

        //If both the trees are same
        if (isIdentical(mainTree, subTree)) {
            return true;
        }

        return isSubTree(mainTree.left, subTree) || isSubTree(mainTree.right, subTree);

    }

    public static boolean isIdentical(TreeNode a, TreeNode b) {

        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }

        return (a.val == b.val) && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);

    }

    public static void main(String[] args) {
		/* Construct below tree
        1
     /     \
    2       3
   / \     / \
  4   5   6   7
		 */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        TreeNode sub = new TreeNode(3);
        sub.left = new TreeNode(6);
        sub.right = new TreeNode(7);

        if (isSubTree(root, sub)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }

}
