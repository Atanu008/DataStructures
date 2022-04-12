package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/merge-two-binary-trees/
//LeetCode 617
public class MergeTwoBinaryTrees {

    //This solution is creating a new Tree
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null){
            return null;
        }

        if(root1 == null){
            return root2;
        }

        if(root2 == null){
            return root1;
        }

        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }

    //This solution is merging second tree into first tree
    public TreeNode mergeTreesV2(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null){
            return null;
        }

        if(root1 == null){
            return root2;
        }

        if(root2 == null){
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTreesV2(root1.left, root2.left);
        root1.right = mergeTreesV2(root1.right, root2.right);

        return root1;
    }
}
