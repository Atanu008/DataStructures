package org.atanu.java.ds.binarytree;

public class Identical {

    public static boolean isIdentical(TreeNode a, TreeNode b) {

        /* Base case : Both empty */
        if (a == null && b == null) {
            return true;
        }

        // If only one is empty
        if (a == null || b == null)
            return false; 

        /* Both non-empty, compare them recursively 
        Note that in recursive calls */
        return (a.val == b.val)
                && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);

    }

    public static void main(String[] args) {

        TreeNode x = new TreeNode(15);
        x.left = new TreeNode(10);
        x.right = new TreeNode(20);
        x.left.left = new TreeNode(8);
        x.left.right = new TreeNode(12);
        x.right.left = new TreeNode(16);
        x.right.right = new TreeNode(25);

        // construct second tree
        TreeNode y = new TreeNode(15);
        y.left = new TreeNode(10);
        y.right = new TreeNode(20);
        y.left.left = new TreeNode(8);
        y.left.right = new TreeNode(12);
        y.right.left = new TreeNode(16);
        y.right.right = new TreeNode(25);

        y.right.right.left = new TreeNode(98); //Not Identical chance


        if (isIdentical(x, y)) {
            System.out.print("Given binary Trees are identical");
        } else {
            System.out.print("Given binary Trees are not identical");
        }
    }

}
