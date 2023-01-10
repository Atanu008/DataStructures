package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//For the graph to be a valid tree, it must have exactly n - 1 edges.
//Any less, and it can't possibly be fully connected. Any more, and it has to contain cycles.
//Additionally, if the graph is fully connected and contains exactly n - 1 edges,
//it can't possibly contain a cycle, and therefore must be a tree!
public class GraphValidTreeV1 {
    public boolean validTree(int n, int[][] edges) {
        // Condition 1: The graph must contain n - 1 edges.
        if (edges.length != n - 1) return false;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        // We return true iff no cycles were detected,
        // AND the entire graph has been reached.
        return dfs(0, -1, adjacencyList, seen) && seen.size() == n;
    }

    public boolean dfs(int node, int parent, List<List<Integer>> adjacencyList, Set<Integer> seen) {
        seen.add(node);
        for (int neighbour : adjacencyList.get(node)) {
            if(!seen.contains(neighbour))
            {
                if(!dfs(neighbour, node, adjacencyList, seen)){
                    return false;
                }
            }
            else if (parent != neighbour) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GraphValidTreeV1 graphValidTree = new GraphValidTreeV1();
        int n = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        boolean result = graphValidTree.validTree(n, edges);
        //Output: true
        System.out.println(result);

        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        result = graphValidTree.validTree(n, edges);
        //Output: false .
        System.out.println(result);
    }
}
