package org.bgd.java.ds.graph;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
 *
 * Given a weighted, undirected, and connected graph with V vertices and E edges,
 * your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST)
 * of the graph. The graph is represented by an adjacency list,
 * where each element adj[i] is a vector containing pairs of integers.
 * Each pair represents an edge, with the first integer denoting the endpoint of the edge
 * and the second integer denoting the weight of the edge.
 *
 * Example 1:
 *
 * Input:
 * 3 3
 * 0 1 5
 * 1 2 3
 * 0 2 1
 *
 * Output:
 * 4
 */
public class MSTPrims {

    static class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Pair(0, 0));
        boolean[] visited = new boolean[V];
        int total = 0;
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            if (visited[top.node]) {
                continue;
            }
            visited[top.node] = true;
            total += top.weight;
            for (int[] neighbour : adj.get(top.node)) {
                int w = neighbour[1];
                int n = neighbour[0];
                if (!visited[n]) {
                    pq.offer(new Pair(n, w));
                }
            }
        }
        return total;
    }
}
