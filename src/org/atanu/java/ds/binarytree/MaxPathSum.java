package org.atanu.java.ds.binarytree;

import java.util.concurrent.atomic.AtomicInteger;

public class MaxPathSum {

    int maxSum;

    public int maxPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftSum = maxPathSum(root.left);

        int rightSum = maxPathSum(root.right);

        // Max path for parent call of root. This path must
        // include at-most one child of root
        int currMaxSingle = Math.max(Math.max(leftSum, rightSum) + root.data, root.data);

        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no 
        // ancestors of root are there in max sum path 
        int maxTop = Math.max(currMaxSingle, leftSum + rightSum + root.data);

        maxSum = Math.max(maxSum, maxTop);

        return currMaxSingle;
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
        a.left.left = new TreeNode(-2);
        a.left.right = new TreeNode(-4);
        a.right.left = new TreeNode(-8);
        a.right.right = new TreeNode(-7);

        MaxPathSum binaryTreeProblem26 = new MaxPathSum();

        binaryTreeProblem26.maxPathSum(a);

        System.out.println("Max Path Sum is " + binaryTreeProblem26.maxSum);

    }

}
