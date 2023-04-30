package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
// Leetcode 1334

// Do Dijkstra from Each Node
// - Now calculate reachable nodes having distance ThresholdDistance
// Take the city which have minimum reachable nodes

// ToDo - Floyd Warshall's shortest path algorithm https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/solutions/491446/java-c-floyd-warshall-s-shortest-path-algorithm-clean-code/?orderBy=most_votes

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

    public static void main(String[] args) {

        int n = 4;
        int[][] edges = new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;

        FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance city = new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance();
        int minCity = city.findTheCity(n, edges, distanceThreshold);
        //Explanation: The figure above describes the graph.
        //The neighboring cities at a distanceThreshold = 4 for each city are:
        //City 0 -> [City 1, City 2]
        //City 1 -> [City 0, City 2, City 3]
        //City 2 -> [City 0, City 1, City 3]
        //City 3 -> [City 1, City 2]
        //Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.
        System.out.println(minCity);

    }
}
