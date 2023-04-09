package org.atanu.java.ds.graph;

import java.util.*;

public class MinimumScoreOfAPathBetweenTwoCities_BFS {

    public int minScore(int n, int[][] roads) {

        Map<Integer, List<int[]>> adjList = new HashMap<>();

        // Build the Graph
        for(int[] road : roads){
            int pointA = road[0];
            int pointB = road[1];
            int score = road[2];

            adjList.putIfAbsent(pointA, new ArrayList<>());
            adjList.get(pointA).add(new int[]{pointB, score});
            adjList.putIfAbsent(pointB, new ArrayList<>());
            adjList.get(pointB).add(new int[]{pointA, score});
        }

        int minScore = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()){

            int currentNode = queue.poll();

            for(int[] edge : adjList.get(currentNode)){
                int node = edge[0];
                int score = edge[1];
                minScore = Math.min(minScore, score);
                if(!visited[node]){
                    queue.offer(node);
                    visited[node] = true;
                }
            }
        }

        return minScore;
    }
}
