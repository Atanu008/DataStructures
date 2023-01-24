package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/maximal-network-rank/description/
//Leetcode 1615
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] road : roads){
            adjList.get(road[0]).add(road[1]);
            adjList.get(road[1]).add(road[0]);
        }

        int maximalNetworkRank = 0;

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                int networkRank = adjList.get(i).size() + adjList.get(j).size();

                if(adjList.get(i).contains(j)){
                    --networkRank;
                }

                maximalNetworkRank = Math.max(maximalNetworkRank, networkRank);
            }
        }

        return maximalNetworkRank;
    }
}
