package org.atanu.java.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

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

    //Without Calculating Height
    //update sum in for maxheight only
    int maxLevel = 0;
    public int deepestLeavesSumV2(TreeNode root) {
        sum = 0;
        deepestLeavesSum(root, 0);
        return sum;
    }

    private void deepestLeavesSum(TreeNode node, int currentLevel) {
        if(node == null){
            return ;
        }
        if(currentLevel > maxLevel){
            sum = 0;
            maxLevel = currentLevel;
        }
        if(currentLevel == maxLevel){
            sum += node.val;
        }
        deepestLeavesSum(node.left, currentLevel + 1);
        deepestLeavesSum(node.right, currentLevel + 1);
    }

    //BFS and calculating sum at every level
    public int deepestLeavesSumV3(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int deepestLeavesSum = 0;
        while(!queue.isEmpty()){
            deepestLeavesSum = 0;
            int size = queue.size();
            while(size -->0){
                TreeNode currentNode = queue.poll();
                deepestLeavesSum += currentNode.val;
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
        }
        return deepestLeavesSum;
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
