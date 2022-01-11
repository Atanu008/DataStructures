package org.atanu.java.ds.binarysearchtree;

//https://leetcode.com/problems/minimum-distance-between-bst-nodes/
//LeetCode 783

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Same problem
//Minimum Absolute Difference in BST
//https://leetcode.com/problems/minimum-absolute-difference-in-bst/
//LeetCode 530
public class MinimumDistanceBetweenBSTNodes {

    Integer minDistance;
    TreeNode prev;
    public int minDiffInBST(TreeNode root) {
        minDistance = Integer.MAX_VALUE;
        TreeNode prev = null;
        minDiffInBSTHelper(root);
        return minDistance;
    }

    private void  minDiffInBSTHelper(TreeNode root){

        if(root == null){
            return;
        }

        minDiffInBSTHelper(root.left);
        if(prev != null){
            minDistance = Math.min(minDistance, root.val - prev.val);
        }
        prev = root;
        minDiffInBSTHelper(root.right);
    }

    //Create a list
    //Sort if not InOrder
    //Check minumim
    public int getMinimumDifference(TreeNode root) {
        Integer minDifference = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        Collections.sort(list); // This sort is not needed if we do InOrder Traversal, that yeilds sorted sequence
        for(int i = 0; i < list.size() -1; i++){
            minDifference = Math.min(minDifference, list.get(i+1) - list.get(i));
        }

        return minDifference;
    }

    private void preOrder(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

}
