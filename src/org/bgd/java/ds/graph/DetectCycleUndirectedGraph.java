package org.bgd.java.ds.graph;

import java.util.ArrayList;

/**
 * https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 *
 * Given an undirected graph with V vertices labelled from 0 to V-1 and E edges,
 * check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i]
 * contains all the nodes ith node is having edge with.
 *
 * Input:
 * V = 5, E = 5
 * adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}
 * Output: 1
 *
 * Input:
 * V = 4, E = 2
 * adj = {{}, {2}, {1, 3}, {2}}
 * Output: 0
 *
 */
public class DetectCycleUndirectedGraph {
    ArrayList<ArrayList<Integer>> list;

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        list = adj;

        boolean[] visited = new boolean[V];
        boolean result = false;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                result = dfs(i, -1, visited);
                if (result) {
                    return true;
                }
            }
        }
        return result;
    }

    private boolean dfs(int node, int parent, boolean[] visited) {

        visited[node] = true;
        for (int n : list.get(node)) {
            if (!visited[n]) {
                if (dfs(n, node, visited)) {
                    return true;
                }
            } else if (n != parent) {
                return true;
            }

        }
        return false;
    }

}
