package org.atanu.java.ds.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LeetCode 971
//https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
public class FlipBinaryTreeToMatchPreOrder {
    int index;
    List<Integer> result;
    int[] prOrder;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] TreeNode) {
        index = 0;
        result = new ArrayList<>();
        prOrder = TreeNode;
        return dfs(root) ? result : Arrays.asList(-1);
    }

    private boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.val != prOrder[index++]) {
            return false;
        }
        if (node.left != null && node.left.val != prOrder[index]) {
            result.add(node.val);
            return dfs(node.right) && dfs(node.left);//Flip in case of mismatch
        } else {
            return dfs(node.left) && dfs(node.right);
        }
    }
}
