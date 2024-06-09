package org.bgd.java.ds.tree.binarytree;

public class DiameterOfABT {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        diameterOfBinaryTree(root, max);
        return max[0];
    }
    public int diameterOfBinaryTree(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }

        int leftD = diameterOfBinaryTree(root.left, max);
        int rightD = diameterOfBinaryTree(root.right, max);

        max[0] = Math.max(max[0], leftD + rightD);
        return 1 + Math.max(leftD, rightD);
    }
}
