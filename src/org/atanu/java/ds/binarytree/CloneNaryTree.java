package org.atanu.java.ds.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/clone-n-ary-tree/
//LeetCode 1490
//Same DFS solution As Graph Clone
public class CloneNaryTree {

    public Node cloneTree(Node root) {

        Map<Node, Node> cloneMap = new HashMap<>();

        return cloneTree(root, cloneMap);
    }

    public Node cloneTree(Node node, Map<Node, Node> cloneMap) {

        if(node == null){
            return null;
        }

        if(cloneMap.containsKey(node)){
            return cloneMap.get(node);
        }

        Node clonnedNode = new Node(node.val);

        for(Node neighbour : node.children){
            clonnedNode.children.add(cloneTree(neighbour, cloneMap));
        }

        return clonnedNode;
    }

    static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
