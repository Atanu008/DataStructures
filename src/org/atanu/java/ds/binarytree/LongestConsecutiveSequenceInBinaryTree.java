package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
//https://www.geeksforgeeks.org/longest-consecutive-sequence-binary-tree/

//if current node has value one more than its parent node then it makes a consecutive path,
//At each node we will compare node’s value with its parent value and update the longest consecutive path accordingly.
public class LongestConsecutiveSequenceInBinaryTree {

    public int longestConsecutive(TreeNode root){
        if(root == null){
            return 0;
        }

        int[] result = new int[1]; // AtomicInteger or any object can be used to pass in the recursion tree
        longestConsecutive(root, root.val, 1, result);
        return result[0];
    }

    public void longestConsecutive(TreeNode root, int expectedVal, int currentLength, int[] result){

        if(root == null){
            return;
        }

        if(root.val == expectedVal){
            currentLength++;
        }
        else{
            currentLength = 1;
        }

        result[0] = Math.max(result[0], currentLength);
        longestConsecutive(root.left, root.val +1, currentLength, result);
        longestConsecutive(root.right, root.val +1, currentLength, result);

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);
        root.right.right.right = new TreeNode(11);
        root.right.right.right.left = new TreeNode(12);
        int longestCommonSequence = new LongestConsecutiveSequenceInBinaryTree().longestConsecutive(root);
        System.out.println("Longest Consecutive Sequence is "+ longestCommonSequence);

    }
}
