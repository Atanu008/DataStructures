package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/clone-graph/
//LeetCode 133
//Video : https://www.youtube.com/watch?v=e5tNvT1iUXs
public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Node, Node> cloneMap = new HashMap<>();
        return cloneGraph(node, cloneMap);
    }

    public Node cloneGraph(Node node, Map<Node, Node> cloneMap){

        if(cloneMap.containsKey(node)){
            return cloneMap.get(node);
        }

        Node clonnedNode = new Node(node.val);
        cloneMap.put(node, clonnedNode); //Map OLD node to NEW node
        for(Node neighbour : node.neighbors){
            clonnedNode.neighbors.add(cloneGraph(neighbour, cloneMap));
        }

        return clonnedNode;

    }
}
