package org.atanu.java.ds.binarytree;

//LeetCode 1302
//https://leetcode.com/problems/deepest-leaves-sum/
public class DeepestLeavesSum {
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        int maxLevel = getmaxLevel(root);
        return deepestLeavesSum(root, 1, maxLevel);
        //return sum;
    }

    private int deepestLeavesSum(TreeNode node, int currentLevel, int maxLevel) {
        if(node == null){
            return 0;
        }
        if(currentLevel == maxLevel){
            sum += node.val;
        }
        deepestLeavesSum(node.left, currentLevel + 1, maxLevel);
        deepestLeavesSum(node.right, currentLevel + 1, maxLevel);
        return sum;
    }
    private int getmaxLevel(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(getmaxLevel(node.left), getmaxLevel(node.right));
    }

    public static void main(String[] args) {
        DeepestLeavesSum deepestLeavesSum = new DeepestLeavesSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        root.right.right.right = new TreeNode(100);
        int deepestSum = deepestLeavesSum.deepestLeavesSum(root);
        System.out.println("Deepest Level Sum is "+ deepestSum);
    }
}
