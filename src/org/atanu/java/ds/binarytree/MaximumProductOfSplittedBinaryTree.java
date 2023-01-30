package org.atanu.java.ds.binarytree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
//Leetcode 1339
//Video : https://www.youtube.com/watch?v=ZGmvcUtXKxU&t=502s
public class MaximumProductOfSplittedBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public int maxProduct(TreeNode root) {
            //treeSum will reecord sum of the subTree with that node
            List<Integer> treeSum = new ArrayList<>();
            long totalSum = postOrder(root, treeSum);
            long maxProduct = 0;

            for(int sum : treeSum){
                maxProduct = Math.max(maxProduct, sum * (totalSum - sum));
            }
            //int MOD = (int) (1e9) + 7;
            return (int) (maxProduct % 1000000007);
        }

        private int postOrder(TreeNode root, List<Integer> treeSum){

            if(root == null){
                return 0;
            }

            int left = postOrder(root.left, treeSum);
            int right = postOrder(root.right, treeSum);

            int treeSumWithThisRoot = left + right + root.val;

            treeSum.add(treeSumWithThisRoot);
            return treeSumWithThisRoot;
        }
    }
}
