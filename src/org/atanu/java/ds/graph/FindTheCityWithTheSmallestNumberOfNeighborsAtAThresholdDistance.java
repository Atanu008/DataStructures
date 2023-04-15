package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];
            adjList.get(source).add(new int[]{destination, weight});
            adjList.get(destination).add(new int[]{source, weight});
        }

        int currentThreshold = Integer.MAX_VALUE;
        int city = -1;
        for(int i = 0; i < n; i++){
            int count = dijkstra(adjList, i, n, distanceThreshold);
            if(count <= currentThreshold){
                currentThreshold = count;
                city = i;
            }
        }
        return city;
    }

    private int dijkstra(List<List<int[]>> adjList, int startNode, int N, int distanceThreshold){
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N]; // startNode is also the number of nodes
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{startNode, 0});
        distance[startNode] = 0;

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

        int cityCountHavingLessThanThreshold = 0;
        for(int j = 0; j < N; j++){
            if(distance[j] <= distanceThreshold){
                cityCountHavingLessThanThreshold++;
            }
        }
        return cityCountHavingLessThanThreshold;
    }
}
