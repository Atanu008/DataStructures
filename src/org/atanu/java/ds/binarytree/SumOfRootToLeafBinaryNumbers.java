package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
//LeetCode 1022
//Same as https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumOfRootToLeafBinaryNumbers {

    public int sumRootToLeaf(TreeNode root) {

        return sumRootToLeaf(root, 0);
    }

    private int sumRootToLeaf(TreeNode root, int sum){
        if(root == null){
            return 0;
        }

        sum = (sum << 1) + root.val;
        //Return sum when reached leaf
        if(root.left == null && root.right == null) return sum;

        return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
    }

    //Using
    public int sumRootToLeafV2(TreeNode root) {

        return sumRootToLeafV2(root, 0);
    }

    private int sumRootToLeafV2(TreeNode root, int sum){
        if(root == null){
            return 0;
        }

        sum = sum*2 + root.val;
        //Return sum when reached leaf
        if(root.left == null && root.right == null) return sum;

        return sumRootToLeafV2(root.left, sum) + sumRootToLeafV2(root.right, sum);
    }

    //Third Solution . Using gloval variable
    //Ad sum to global variable when reached leaf node
    int sumRootToLeaf = 0;
    public int sumRootToLeafV3(TreeNode root) {

        sumRootToLeafV3(root, 0);
        return sumRootToLeaf;
    }

    private void sumRootToLeafV3(TreeNode root, int sum){
        if(root == null){
            return;
        }

        sum = sum*2 + root.val;

        if(root.left == null && root.right == null){
            sumRootToLeaf += sum;
        }

        sumRootToLeafV3(root.left, sum);
        sumRootToLeafV3(root.right, sum);
    }
}
