package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/find-if-path-exists-in-graph/
//LeetCode 1971
public class FindIfPathExistsInGraph {

    //BFS Solution
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            adjList.put(i, new ArrayList<>());
        }
        //Make Bi-Directional Graph
        for(int[] edge : edges){
            int vertexA = edge[0];
            int vertexB = edge[1];
            adjList.get(vertexA).add(vertexB);
            adjList.get(vertexB).add(vertexA);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        queue.offer(source);
        visited[source] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == destination) {
                return true;
            }
            for(int neighbour : adjList.get(current)){
                if(!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        return false;
    }

    //DFS Solution
    public boolean validPathV2(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            adjList.put(i, new ArrayList<>());
        }
        //Make Bi-Directional Graph
        for(int[] edge : edges){
            int vertexA = edge[0];
            int vertexB = edge[1];
            adjList.get(vertexA).add(vertexB);
            adjList.get(vertexB).add(vertexA);
        }

        boolean[] visited = new boolean[n];

        return dfs(adjList, visited, source, destination);

        //Alternativly we could have traverse the graph and not return from the method and return visited[destination] . As it will be true if we can traverse it.
    }

    private boolean dfs(Map<Integer, List<Integer>> adjList, boolean[] visited, int node, int destination) {

        if(visited[node]){
            return false;
        }
        if(node == destination){
            return true;
        }

        visited[node] = true;
        for(int neighbour : adjList.get(node)) {
            if(dfs(adjList, visited, neighbour, destination)){
                return true;
            }
        }

        return false;
    }


    //DFS . But not early return . Traverse teh full Graph .
    //And return the visited state of destination
    public boolean validPathV3(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            adjList.put(i, new ArrayList<>());
        }
        //Make Bi-Directional Graph
        for(int[] edge : edges){
            int vertexA = edge[0];
            int vertexB = edge[1];
            adjList.get(vertexA).add(vertexB);
            adjList.get(vertexB).add(vertexA);
        }

        boolean[] visited = new boolean[n];

        dfs(adjList, visited, source);

        return visited[destination];
    }

    private void dfs(Map<Integer, List<Integer>> adjList, boolean[] visited, int node) {

        if(visited[node]){
            return;
        }

        visited[node] = true;
        for(int neighbour : adjList.get(node)) {
            dfs(adjList, visited, neighbour);
        }
    }
}
