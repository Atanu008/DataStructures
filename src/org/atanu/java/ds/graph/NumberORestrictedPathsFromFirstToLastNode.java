package org.atanu.java.ds.graph;

// https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/description/
// Leetcode 1786

// Create the graph. You can use a multitude of different data structures
// but you want to add all the edges in an undirected manner and keep track of the weights (you will use them later).

// Using Dijkstra's algorithm create the shortest path distance between vertex n and all other nodes.
// Now we have all the shortest paths from each node to the end, we will call this distanceToEnd(node)

// Start a DFS traversal from the start node 1 and travel as many different paths that you can.
// HOWEVER the requirement is that
// you can only move from a node to its neighbor if distanceToEnd(node) > distanceToEnd(nei).

//It is possible that we can travel multiple paths that reach the same node in its path,
//so we save those calculations for faster lookups.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberORestrictedPathsFromFirstToLastNode {


    public int countRestrictedPaths(int n, int[][] edges) {

        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];
            adjList.get(source).add(new int[]{destination, weight});
            adjList.get(destination).add(new int[]{source, weight});
        }

        int[] distance = new int[n + 1];
        dijkstra(adjList, n, distance);
        System.out.println(Arrays.toString(distance));
        return dfs(1, n, adjList, distance, new Integer[n+1]);
    }
    private void dijkstra(List<List<int[]>> adjList, int destinationNode, int[] distance){
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[destinationNode + 1]; // destinationNode is also the number of nodes
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{destinationNode, 0});
        distance[destinationNode] = 0;

        while(!minHeap.isEmpty()){

            int[] current = minHeap.poll();
            int currentNode = current[0];
            int currentDistance = current[1];
            if(visited[currentNode]){
                continue;
            }

            visited[currentNode] = true;

            for(int[] edge : adjList.get(currentNode)){
                int nextNode = edge[0];
                int nextWeight = edge[1];
                int nextDistance = currentDistance + nextWeight;

                if(!visited[nextNode] && nextDistance < distance[nextNode]){
                    distance[nextNode] = nextDistance;
                    minHeap.offer(new int[]{nextNode, nextDistance});
                }
            }
        }
    }

    int dfs(int src, int n, List<List<int[]>> graph, int[] dist, Integer[] memo) {
        if (memo[src] != null) return memo[src];
        if (src == n) return 1; // Found a path to reach to destination
        int ans = 0;
        for (int[] nei : graph.get(src)) {
            int v = nei[0];
            if (dist[src] > dist[v])
                ans = (ans + dfs(v, n, graph, dist, memo)) % 1000000007;
        }
        return memo[src] = ans;
    }

    public static void main(String[] args) {
        NumberORestrictedPathsFromFirstToLastNode numberORestrictedPathsFromFirstToLastNode = new NumberORestrictedPathsFromFirstToLastNode();
        int[][] edges = {{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}};
        int n = 5;
        int result = numberORestrictedPathsFromFirstToLastNode.countRestrictedPaths(n, edges);
        System.out.println(result);
    }
}
