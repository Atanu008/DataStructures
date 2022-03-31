package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/possible-bipartition/
//LeetCode 886
public class PossibleBipartition {

    //BFS Solution
    public boolean possibleBipartition(int n, int[][] dislikes) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] dislike : dislikes){
            int vertexA = dislike[0];
            int vertexB = dislike[1];

            adjList.putIfAbsent(vertexA, new ArrayList<>());
            adjList.get(vertexA).add(vertexB);

            adjList.putIfAbsent(vertexB, new ArrayList<>());
            adjList.get(vertexB).add(vertexA);
        }

        int[] colors = new int[n+1];
        for(int i = 1; i <= n; i++){

            if(adjList.get(i) == null){ //This for node which has no edge. Edge case
                continue;
            }
            if(colors[i] == 0 && !bfs(adjList, colors, i)){
                return false;
            }
        }

        return true;
    }

    public boolean bfs(Map<Integer, List<Integer>> adjList, int[] colors, int node) {

        colors[node] = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            //System.out.println("Current "+ current);
            for(int neighbour : adjList.get(current)){
                //Not Visited . Color it
                if(colors[neighbour] == 0) {
                    colors[neighbour] = - colors[current];
                    queue.offer(neighbour);
                }
                else if(colors[neighbour] == colors[current]) { // Visited and same color . NOt possible
                    return false;
                }
            }
        }

        return true;
    }


    //DFS Solution
    public boolean possibleBipartitionDFS(int n, int[][] dislikes) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] dislike : dislikes){
            int vertexA = dislike[0];
            int vertexB = dislike[1];

            adjList.putIfAbsent(vertexA, new ArrayList<>());
            adjList.get(vertexA).add(vertexB);

            adjList.putIfAbsent(vertexB, new ArrayList<>());
            adjList.get(vertexB).add(vertexA);
        }

        int[] colors = new int[n+1];
        for(int i = 1; i <= n; i++){

            if(adjList.get(i) == null){ //This for node which has no edge. Edge case
                continue;
            }
            if(colors[i] == 0 && !dfs(adjList, colors, i, 1)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> adjList, int[] colors, int node, int color) {

        colors[node] = color;

        for(int neighbour : adjList.get(node)) {
            //neighbour is not visited i.e color[neighbour] = 0. Try coloring it with different color
            if(colors[neighbour] == 0) {
                if(!dfs(adjList, colors, neighbour, -color)) {
                    return false;
                }
            }
            // Its already visited color[neighbour] != 0.
            //If its with same color as parent , then its not Bipartite . return false
            else if(colors[neighbour] == colors[node]) {
                return false;
            }
        }

        return true;
    }
}
