package org.atanu.java.ds.graph;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/is-graph-bipartite/
//LeetCode 785
public class IsGraphBipartite {

    //Two color Implementation
    public boolean isBipartite(int[][] graph) {

        int nodes = graph.length;
        int[] colors = new int[nodes];

        for(int i = 0; i < nodes; i++) {
            if(colors[i] == 0 && !dfs(graph, colors, i, 1)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int[][] graph, int[] colors, int node, int color) {

        colors[node] = color;

        for(int neighbour : graph[node]) {
            //neighbour is not visited i.e color[neighbour] = 0. Try coloring it with different color
            if(colors[neighbour] == 0) {
                if(!dfs(graph, colors, neighbour, -color)) {
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

    //It was Initial version. visited array is not needed.
    //Only color array is sufficient
    public boolean isBipartiteV2(int[][] graph) {

        int nodes = graph.length;
        boolean[] visited = new boolean[nodes];
        int[] colors = new int[nodes];

        for(int i = 0; i < nodes; i++) {
            if(colors[i] == 0 && !visited[i] && !dfsV2(graph, colors, visited, i, 1)){
                return false;
            }
        }

        return true;
    }

    public boolean dfsV2(int[][] graph, int[] colors, boolean[] visited, int node, int color) {

        colors[node] = color;
        visited[node] = true;

        for(int neighbour : graph[node]) {
            if(!visited[neighbour]) {
                if(!dfsV2(graph, colors, visited, neighbour, -color)) {
                    return false;
                }
            }
            else if(colors[neighbour] == colors[node]) {
                return false;
            }
        }

        return true;
    }


    //BFS Solution
    //Video : https://www.youtube.com/watch?v=0ACfAqs8mm0
    public boolean isBipartiteBFS(int[][] graph) {

        int nodes = graph.length;
        int[] colors = new int[nodes];

        for(int i = 0; i < nodes; i++) {
            if(colors[i] == 0 && !bfs(graph, colors, i)){
                return false;
            }
        }

        return true;
    }

    public boolean bfs(int[][] graph, int[] colors, int node) {

        colors[node] = 1; // Color the node with One. in while we will try to color with negative of this color
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);

        while(!queue.isEmpty()) {

            int curr = queue.poll();
            for(int neighbour : graph[curr]) {
                if(colors[neighbour] == colors[curr]) { //Odd Length Cycle. neighbour has the same color . Not Biparte
                    return false;
                }
                else if(colors[neighbour] == 0){ //Un Visited Node . color with -ve color than this
                    colors[neighbour] = - colors[curr];
                    queue.offer(neighbour);
                }
            }
        }

        return true;
    }
}
