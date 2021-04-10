package org.atanu.java.ds.design;

import java.util.Stack;

public class BSTIteratorStack {
    Stack<TreeNode> stack;
    public BSTIteratorStack(TreeNode root) {
        stack = new Stack<>();
        pushAllLeftNodes(root);
    }

    public int next() {
        TreeNode poppedNode = stack.pop();
        pushAllLeftNodes(poppedNode.right);
        return poppedNode.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeftNodes(TreeNode node){

        while(node !=null){
            stack.push(node);
            node = node.left;
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right; }
    }
}
