package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/
//LeetCode 1319
// To Do : Using DisjointSet Union
public class NumberOfOperationsToMakeNetworkConnected {

    //We need at least n - 1 cables to connect all nodes (like a tree).
    //If connections.size() < n - 1, we can directly return -1.
    //One trick is that, if we have enough cables,
    //we don't need to worry about where we can get the cable from.
    //We only need to count the number of connected networks.
    //To connect two unconneccted networks, we need to set one cable.
    //The number of operations we need = the number of connected networks(components) - 1
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n-1){
            return -1;
        }

        List<List<Integer>> graph = new ArrayList<>();
        //Create Graph
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        //Add Edges
        for(int i = 0; i < connections.length; i++){
            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(connections[i][0]);
        }

        boolean[] visited = new boolean[n];
        int connectedComponent = 0;
        for(int node = 0; node < n; node++){
            if(!visited[node]){
                dfs(graph, node, visited);
                connectedComponent++;
            }
        }

        return connectedComponent -1;
    }

    private void dfs(List<List<Integer>> graph, int node, boolean[] visited){

        visited[node] = true;
        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                dfs(graph, neighbour, visited);
            }

        }

    }
}
