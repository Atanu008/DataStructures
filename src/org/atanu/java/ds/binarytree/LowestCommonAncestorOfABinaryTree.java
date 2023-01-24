package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
//LeetCode 236
public class LowestCommonAncestorOfABinaryTree {

    //It is guaranteed that both p and q are in the tree.
    //A node can be a descendant of itsel
    //Like In the example of 4 and 5
    //Thats why we can return as soon as we get any of them
    //if(root == p || root == q){
    //       return root;
    //   }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }
        //Return if any of them found
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

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
    }

    public TreeNode lowestCommonAncestor_v2(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }
        //Return if any of them found
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        //Simplified Return
        return left == null ? right : left;
    }
}
