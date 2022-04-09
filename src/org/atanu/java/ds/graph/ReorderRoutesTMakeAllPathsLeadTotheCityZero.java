package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
//LeetCode 1466
public class ReorderRoutesTMakeAllPathsLeadTotheCityZero {

    //This is actually a directed graph. You are asked to change direction of some of the edges so that every city is directed towards zero.
//To simplify the question, we make the input graph BI-DIRECTIONAL. But if we make it bi-directional, we //would lose the information about direction. So we store that information wrt direction in a set.
    public int minReorder(int n, int[][] connections) {

        Set<String> edgeDirection = new HashSet<>();
        Map<Integer, Set<Integer>> adjList = new HashMap<>();

        //Build a undirected graph
        for(int[] edge : connections) {
            int source = edge[0];
            int destination = edge[1];
            //storing the direction as "source-destination"
            edgeDirection.add(source+"-"+destination);

            adjList.putIfAbsent(source, new HashSet<>());
            adjList.putIfAbsent(destination, new HashSet<>());

            adjList.get(source).add(destination);
            adjList.get(destination).add(source);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        queue.add(0);//will start from Zero
        visited[0] = true;

        int directionChangeNeeded = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int neighbour : adjList.get(current)) {
                if(!visited[neighbour]){
                    //if the direction is NOT from next to the current node, increment count => This is because inorder for every node to reach 0, we need to ensure that there is a path from each node to its previous node/parent node.
                    if(!edgeDirection.contains(neighbour+"-"+current)){
                        directionChangeNeeded++;
                    }

                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        return directionChangeNeeded;
    }

    public static void main(String[] args) {
        ReorderRoutesTMakeAllPathsLeadTotheCityZero reorderRoutesTMakeAllPathsLeadTotheCityZero = new ReorderRoutesTMakeAllPathsLeadTotheCityZero();
        int n = 6;
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int count = reorderRoutesTMakeAllPathsLeadTotheCityZero.minReorder(n, connections);
        System.out.println(count);
    }
}
