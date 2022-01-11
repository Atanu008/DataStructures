package org.atanu.java.ds.binarysearchtree;

//https://leetcode.com/problems/convert-bst-to-greater-tree/
//LeetCode 538
//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
//LeetCode 1038
//LeetCode 538 and LeetCode 1038 are same
//Video : https://www.youtube.com/watch?v=L6zftBseFXU Can help
//Leetcode Sol Explanation
public class ConvertBSTToGreaterTree {

    //perform a reverse in-order traversal
    //Maintain some minor "global" state so each recursive call can access and modify the current total sum
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        reverseInOrder(root);
        return root;
    }

    private void reverseInOrder(TreeNode root){
        if(root == null){
            return;
        }
        reverseInOrder(root.right);
        sum += root.val;
        root.val = sum;
        reverseInOrder(root.left);
    }
}
