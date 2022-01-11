package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/longest-univalue-path/
//LeetCode 687
//https://leetcode.com/problems/longest-univalue-path/discuss/204642/Java-Python-Scala-Recursion-with-Explanations

//leftPath indicates max univalue path starting from root.left,
//rightPath indicates max univalue path starting from root.right,
//then
//leftPath = (root.val == root.left.val) ? leftPath + 1 : 0// subproblem
//rightPath = (root.val == root.right.val) ? rightPath + 1 : 0 // subproblem
//update maxUnivaluePath by leftPath + rightPath, which is max univalue path rooted at root.
//max(leftPath, rightPath) is max univalue path starting from root // conquer
public class LongestUnivaluePath {

    int longestPath = 0;

    public int longestUnivaluePath(TreeNode root) {

        postOrder(root);
        return longestPath;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftPath = postOrder(root.left);
        int rightPath = postOrder(root.right);

        if (root.left != null && root.val == root.left.val) {
            leftPath++;
        } else {
            leftPath = 0;
        }

        if (root.right != null && root.val == root.right.val) {
            rightPath++;
        } else {
            rightPath = 0;
        }

        longestPath = Math.max(longestPath, leftPath + rightPath);

        return Math.max(leftPath, rightPath);
    }
}
