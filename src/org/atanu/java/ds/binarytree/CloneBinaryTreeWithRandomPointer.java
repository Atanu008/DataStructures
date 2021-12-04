package org.atanu.java.ds.binarytree;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/clone-binary-tree-with-random-pointer/
//LeetCode 1485
public class CloneBinaryTreeWithRandomPointer {

    public NodeCopy copyRandomBinaryTree(Node root) {

        if(root == null){
            return null;
        }

        Map<Node, NodeCopy> cloneMap = new HashMap<>();

        return copyRandomBinaryTree(root, cloneMap);

    }

    public NodeCopy copyRandomBinaryTree(Node node, Map<Node, NodeCopy> cloneMap){

        if(node == null){
            return null;
        }

        if(cloneMap.containsKey(node)){
            return cloneMap.get(node);
        }

        NodeCopy copy = new NodeCopy(node.val);
        cloneMap.put(node, copy);

        copy.left = copyRandomBinaryTree(node.left, cloneMap);
        copy.right = copyRandomBinaryTree(node.right, cloneMap);
        copy.random = copyRandomBinaryTree(node.random, cloneMap);

        return copy;

    }

    private class NodeCopy {
        public NodeCopy left;
        public NodeCopy right;
        public NodeCopy random;

        public NodeCopy(Object val) {
        }
    }

    private class Node {
        public Object val;
        public Node left;
        public Node right;
        public Node random;
    }
}
