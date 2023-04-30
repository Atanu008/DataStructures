package org.atanu.java.ds.graph;

// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/
// Leetcode 2359

import java.util.Arrays;


// Initialize variables n to the size of the edges array, ans to -1, and minDist to the maximum value of an int.
// Create two arrays dist1 and dist2 of size n and initialize all elements to 0. Also, create two arrays visited1 and visited2 of size n and initialize all elements to false.
// Run the depth-first search (DFS) algorithm from node1 and update the dist1 and visited1 arrays accordingly.
// Run the DFS algorithm from node2 and update the dist2 and visited2 arrays accordingly.
// Iterate through all nodes currNode in the graph.
// For each node, check if it has been visited by both DFS calls,
// and if its maximum distance from node1 and node2 (i.e. max(dist1[currNode], dist2[currNode])) is less than the current value of minDist.
// If the above conditions are met, update the value of minDist and ans to the current node's distance and index, respectively.
// Return ans as the result.
// This algorithm finds the closest meeting point between two given nodes in a graph
// by using DFS to calculate the distance from each node to all other nodes in the graph.
// It only considers nodes that are reachable from both given nodes,
// and chooses the one that has the smallest maximum distance from the two given nodes.

public class FindClosestNodeToGivenTwoNodes {

    public int closestMeetingNode(int[] edges, int node1, int node2) {

        int n = edges.length;

        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];

        int[] distance1 = new int[n];
        int[] distance2 = new int[n];

        int ans = -1;
        int maxDistance = Integer.MAX_VALUE;

        dfs(edges, node1, visited1, distance1);
        dfs(edges, node2, visited2, distance2);

        System.out.println(Arrays.toString(distance1));
        System.out.println(Arrays.toString(distance2));

        for(int currentNode = 0; currentNode < n; currentNode++){

            if(visited1[currentNode] && visited2[currentNode]){
                int maxNumberOfEdgeFromCurrentNode = Math.max(distance1[currentNode], distance2[currentNode]);
                if(maxNumberOfEdgeFromCurrentNode < maxDistance){
                    maxDistance = maxNumberOfEdgeFromCurrentNode;
                    ans = currentNode;
                }
            }
        }

        return ans;
    }

    private void dfs(int[] edges, int node, boolean[] visited, int[] distance){

        visited[node] = true;
        int neighbour = edges[node];

        if(neighbour != -1 && !visited[neighbour]){
            distance[neighbour] = distance[node] + 1; // Increment the edge count , parents count + 1(for the current edge)
            dfs(edges, neighbour, visited, distance);
        }
    }
}
