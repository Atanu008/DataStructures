package org.atanu.java.ds.binarysearchtree;

//https://leetcode.com/problems/recover-binary-search-tree/
//LeetCode 99
//Video : https://www.youtube.com/watch?v=2ahCLZ3x1iI
//https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
public class RecoverBinarySearchTree {

    TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {

        inOrder(root);
        swap(first, second);
    }

    private void inOrder(TreeNode node){
        if(node == null){
            return;
        }

        inOrder(node.left);

        if(prev != null && first == null && prev.val > node.val){
            first = prev;
        }

        if(prev != null && first != null && prev.val > node.val){
            second = node;
        }

        prev = node;
        inOrder(node.right);
    }

    private void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
