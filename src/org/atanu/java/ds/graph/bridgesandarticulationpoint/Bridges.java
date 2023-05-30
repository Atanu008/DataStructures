package org.atanu.java.ds.graph.bridgesandarticulationpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Bridges : A bridge is an edge from vertex U to vertex V such that removing
// the edge increases the number of connected components in the graph.

// Amazing Udemy Graph Theory :
// https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/26934108#overview
// https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/26934112#overview
// https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/26934116#overview
// https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/26934118#overview
// https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/26934122#overview

// https://codeforces.com/blog/entry/71146
// https://www.codingninjas.com/codestudio/library/articulation-points-in-a-graph

public class Bridges {

    private int time = 1;

    public static void main(String[] args) {
        Bridges bridges = new Bridges();
        int n = 4;
        List<List<Integer>> edges =  new ArrayList<>();
        edges.add(Arrays.asList(0,1));
        edges.add(Arrays.asList(1,2));
        edges.add(Arrays.asList(2,0));
        edges.add(Arrays.asList(1,3));
        bridges.findBridges(n, edges);
        edges.clear();

        System.out.println("+++++++");
        n = 2;
        edges.add(Arrays.asList(0,1));
        bridges.findBridges(n, edges);
        edges.clear();

        System.out.println("+++++++");
        // Eg : https://www.geeksforgeeks.org/bridge-in-a-graph/
        n = 5;
        edges.add(Arrays.asList(1,0));
        edges.add(Arrays.asList(0,2));
        edges.add(Arrays.asList(2,1));
        edges.add(Arrays.asList(0,3));
        edges.add(Arrays.asList(3,4));
        bridges.findBridges(n, edges);
    }

    public void findBridges(int n, List<List<Integer>> edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        // Build the Graph from Connection
        buildGraph(n, edges, adjList);

        boolean[] visited = new boolean[n];
        // Discovered Time : Time at which current node was discovered during DFS
        int[] discovered = new int[n];
        // Lowest Time : it is the discovered time of a node which can be traversed by at most one back-edge in current subtree
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, -1, adjList, visited, discovered, low, bridges);
            }
        }

        bridges.forEach(System.out::println);
    }

    private void dfs(int currentNode, int parent, List<List<Integer>> adjList, boolean[] visited, int[] discovered, int[] low, List<List<Integer>> bridges) {

        visited[currentNode] = true;
        // set discovery time and low of current currentNode as time.
        discovered[currentNode] = time;
        low[currentNode] = time;
        time++; //increment the time variable

        for(int child : adjList.get(currentNode)){

            // the child_node has been not been visited before
            // Forward edge in the tree
            // Do DFS
            if(!visited[child]){
                dfs(child, currentNode, adjList, visited, discovered, low, bridges);
                // Check if the subtree rooted with child has a connection to one of the ancestors of currentNode
                // low[child] may point to ancestors of currentNode via any back-edge
                // i.e currentNode also can connect to that ancestors via this child and via the back-edge of the child
                // So once dfs is completed, we take the min low of neighbour and it own self
                // i.e low[child] might be an ancestor of currentNode
                low[currentNode] = Math.min(low[currentNode], low[child]);
                // in case the lowest reach time is greater than current node's inTime
                // that means we can't reach from neighbour to this current node if this current->next
                // edge is removed , so its a bridge edge
                if(low[child] > discovered[currentNode]){
                    bridges.add(Arrays.asList(currentNode, child));
                }
            }

            // if child node has been visited before it is not parent , means that we found an ancestor
            // then its a back-edge
            else if(child != parent){
                // As there can be many back-edges, finds the ancestor with the least discovery time
                low[currentNode] = Math.min(low[currentNode], discovered[child]);
            }
        }
    }

    private void buildGraph(int n, List<List<Integer>> connections, List<List<Integer>> adjList) {

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.size(); i++) {
            int nodeA = connections.get(i).get(0);
            int nodeB = connections.get(i).get(1);

            adjList.get(nodeA).add(nodeB);
            adjList.get(nodeB).add(nodeA);
        }
    }
}
