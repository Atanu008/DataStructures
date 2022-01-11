package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
//LeetCode 124
//Video : https://www.youtube.com/watch?v=TO5zsKtc1Ic
public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        maxPathSumHelper(root);
        return maxSum;

    }

    public int maxPathSumHelper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftSum = maxPathSumHelper(root.left);

        int rightSum = maxPathSumHelper(root.right);

        // Max path for parent call of root. This path must
        // include at-most one child of root
        // Path 1 : Root + Left
        // Path 2 : Root + Right
        // Path 3: Only Root
        int currMaxSinglePath = Math.max(Math.max(leftSum, rightSum) + root.val, root.val);

        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        //Path 4 : Root + Left + Right // where the path started from left and ended at right
        int maxTop = Math.max(currMaxSinglePath, leftSum + rightSum + root.val);

        maxSum = Math.max(maxSum, maxTop);

        return currMaxSinglePath; //As This would only needed to create path. One directional
    }
}
