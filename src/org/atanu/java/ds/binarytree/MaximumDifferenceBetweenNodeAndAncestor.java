package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/solution/
//LeetCode 1026
public class MaximumDifferenceBetweenNodeAndAncestor {

    int maxAncestorDiff = 0;
    public int maxAncestorDiff(TreeNode root) {

        dfs(root, root.val, root.val);
        return maxAncestorDiff;
    }

    private void dfs(TreeNode root, int currMax, int currMin){

        if(root == null){
            return;
        }

        int possibleMaxAncestorDiff = Math.max(Math.abs(root.val - currMax), Math.abs(root.val - currMin));
        maxAncestorDiff = Math.max(maxAncestorDiff, possibleMaxAncestorDiff);

        currMax = Math.max(root.val, currMax);
        currMin = Math.min(root.val, currMin);

        dfs(root.left, currMax, currMin);
        dfs(root.right, currMax, currMin);
    }

    //Same Solution as above
    //Record the maximum and minimum values during the recursion
    //Return the difference when encountering leaves.
    public int maxAncestorDiffV2(TreeNode root) {

        return dfsV2(root, root.val, root.val);
    }

    private int dfsV2(TreeNode root, int currMax, int currMin){

        // if encounter leaves, return the max-min along the path
        if(root == null){
            return currMax - currMin;
        }

        // else, update max and min
        // and return the max of left and right subtrees
        currMax = Math.max(root.val, currMax);
        currMin = Math.min(root.val, currMin);

        int left = dfsV2(root.left, currMax, currMin);
        int right = dfsV2(root.right, currMax, currMin);

        return Math.max(left,right);
    }
}
