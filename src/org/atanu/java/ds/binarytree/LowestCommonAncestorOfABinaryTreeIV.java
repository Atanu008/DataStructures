package org.atanu.java.ds.binarytree;

import java.util.HashSet;
import java.util.Set;

//Same as LowestCommonAncestorOfABinaryTreeII
//Instead of Two Node we have an array
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/
//LeetCode1676
public class LowestCommonAncestorOfABinaryTreeIV {

    int count = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();
        for(TreeNode node: nodes){
            set.add(node);
        }

        TreeNode LCA = LCA(root, set);

        return count == set.size() ? LCA : null;
    }

    public TreeNode LCA(TreeNode root, Set<TreeNode> set) {
        if (root == null) return root;
        TreeNode left = LCA(root.left, set);
        TreeNode right = LCA(root.right, set);
        if (set.contains(root)) {
            count++;
            return root;
        }

        if(left != null && right != null){
            return root;
        }
        else if(left != null){
            return left;
        }
        else if(right != null){
            return right;
        }
        else return null;
        //return left == null ? right : right == null ? left : root;
    }
}
