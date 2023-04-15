package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/shortest-path-with-alternating-colors/description/
//Leetcode 1129
// Approach :
// We already know that we can find the shortest path between any two nodes in a graph using BFS
// Since we can visit all nodes in a graph using BFS traversal,
// we can update the shortest distance for every node when visiting that particular node.
// The shortest distance between source node and target node is the distance
// when we first visit the target node starting from source (when distance[nextNode] == -1)

// First, we construct an adjacency matrix with the given red_edges and blue_edges.
//  It is important for us to keep in mind the fact that there can be at most two directed edges(in the same direction) between any two nodes(a blue edge and a red edge )
// Here I am using a pair of int and int to keep track of the node index and the color of the edge respectively ( 0 for a red edge and 1 for a blue edge)
// I am keeping track of three values in the queue, the first one to denote the node index, the second one for the distance and the third one for color ( the color is -1 only for the source node)
// Use a BFS traversal and keep updating the dist only when it is not visited. Here I am updating the node value in the adjacency matrix to -1 to denote that the node has already been visited.

public class ShortestPathWithAlternatingColors {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int[] edge : redEdges){
            adjList.computeIfAbsent(edge[0], value -> new ArrayList<>()).
                    add(new int[]{edge[1], 0}); // 0 - Red Edge
        }

        for(int[] edge : blueEdges){
            adjList.computeIfAbsent(edge[0], value -> new ArrayList<>()).
                    add(new int[]{edge[1], 1}); // 1 - Blue Edge
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][2];// One Node can have possible Two edges [n][2] will record both state
        // Mark the first Node visited
        visited[0][0] = true;
        visited[0][1] = true;

        queue.offer(new int[]{0, 0, -1}); // Node,Distance,Color : First Node does not have any color : -1 as invalid color

        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[0] = 0; // Distance of source node is always zero

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDistance = current[1];
            int currentColor = current[2];

            if(!adjList.containsKey(currentNode)){
                continue;
            }
            for(int[] neighbourEdges : adjList.get(currentNode)){
                int nextNode = neighbourEdges[0];
                int nextColor = neighbourEdges[1];

                // If the nextNode state[can be atmost two state RED and BLUE ] is not visited
                // And nextColor is not same as the previousNode Color (nextColor != currentColor)
                // Push it to the Queue.
                // Update the Result Distance array if visiting for the first time

                if(!visited[nextNode][nextColor] && nextColor != currentColor){
                    visited[nextNode][nextColor] = true;
                    int nextDistance = currentDistance + 1;
                    // distance[nextNode] == -1 Means we are first time visiting the node
                    // This is the shortest distance
                    if(distance[nextNode] == -1){
                        distance[nextNode] = nextDistance;
                    }
                    queue.offer(new int[]{nextNode, nextDistance, nextColor});
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[][] red = new int[][]{{0,1},{1,2}}, blue = new int[][]{};

        int[] res = new ShortestPathWithAlternatingColors().shortestAlternatingPaths(3,red,blue);
        Arrays.stream(res).forEach(e -> System.out.print(e +" "));
    }
}
