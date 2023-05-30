package org.atanu.java.ds.graph.singlesourceshortestpath;

import java.util.Arrays;

// https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/27022506#overview
// https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/27022508#overview

public class BellmanFord {

    public void bellmanFord(int n, int[][] edges, int source){

        int[] distance = new int[n];
        // Step 1:
        // Initialize distances from src to all , i.e Infinite at first
        // distance of source is zero
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for(int i = 0; i < n - 1; i++){
            for(int[] edge : edges){
                int src = edge[0];
                int dest = edge[1];
                int weight = edge[2];
                // Integer.MAX_VALUE check just to avoid overflow , Integer.MAX_VALUE + weight will go negative
                if(distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]){
                    distance[dest] = distance[src] + weight;
                }
            }
        }

        // Step 3: check for negative-weight cycles. The
        // above step guarantees shortest distances if graph
        // doesn't contain negative weight cycle. If we get
        // a shorter path, then there is a cycle.
        boolean isNegativeWeightCyclePresent = false;
        for(int[] edge : edges){
            int src = edge[0];
            int dest = edge[1];
            int weight = edge[2];
            if(distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]){
                System.out.println("Graph contains negative weight cycle");
                isNegativeWeightCyclePresent =true;
                break;
            }
        }

        if(!isNegativeWeightCyclePresent)
            print(n, source, distance);
    }

    private void print(int n, int src, int[] distance) {
        System.out.println("Vertex Distance from Source : "+src);
        for(int i=0;i<n;i++){
            System.out.println(i +" -- distance :: "+ distance[i]);
        }
    }

    public static void main(String[] args) {
        BellmanFord bellmanFord = new BellmanFord();
        // Eg : https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
        int n = 5;
        int[][] edges = new int[][]{
                {0, 1, -1},{0, 2, 4},{1, 2, 3},{1, 3, 2},{1, 4, 2},{3, 2, 5},{3, 1, 1},{4, 3, -3}
        };

        bellmanFord.bellmanFord(n,edges,0);
    }
}
