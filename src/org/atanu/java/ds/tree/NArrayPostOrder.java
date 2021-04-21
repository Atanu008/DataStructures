package org.atanu.java.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//LeetCode 590
//https://leetcode.com/problems/n-ary-tree-postorder-traversal/
public class NArrayPostOrder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<Integer> resultList = new ArrayList<>();
    public List<Integer> postorderIterative(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        Stack<Node> inStack = new Stack<>();
        Stack<Node> outStack = new Stack<>();
        inStack.push(root);
        while(!inStack.isEmpty()) {
            Node poppedNode = inStack.pop();
            outStack.push(poppedNode);
            for(Node child : poppedNode.children){
                inStack.push(child);
            }
        }

        while(!outStack.isEmpty()){
            resultList.add(outStack.pop().val);
        }
        return resultList;
    }

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return resultList;
        }
        for (Node child : root.children) {
            postorder(child);
        }
        resultList.add(root.val);
        return resultList;
    }

}
