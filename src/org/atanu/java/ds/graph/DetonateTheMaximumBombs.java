package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/detonate-the-maximum-bombs/
//LeetCode 2101
//Video : https://www.youtube.com/watch?v=TpmSRsvWitU
public class DetonateTheMaximumBombs {

    //Build as a graph
    // count the number of detonation when starting with each bomb
    public int maximumDetonation(int[][] bombs) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, bombs);
        int maxBombs = 0;

        for(int startBomb = 0; startBomb < bombs.length; startBomb++){
            System.out.println(graph.get(startBomb));
            maxBombs = Math.max(maxBombs, bfs(startBomb, graph));
        }

        return maxBombs;
    }

    public void buildGraph(Map<Integer, List<Integer>> graph, int[][] bombs){

        //for(int node = 0; node < bombs.length; node++){
        //    graph.put(node, new ArrayList<>());
        // }

        for(int i = 0; i < bombs.length; i++){
            long X1 = bombs[i][0]; //Long for testcase [[1,1,100000],[100000,100000,1]]
            long Y1 = bombs[i][1];
            long R1 = bombs[i][2];

            List<Integer> neighbors = new ArrayList<>();
            for(int j = 0; j < bombs.length; j++){
                if(i != j){
                    long X2 = bombs[j][0];
                    long Y2 = bombs[j][1];

                    if((X1-X2)*(X1-X2) + (Y1-Y2)*(Y1-Y2) <= R1*R1){
                        neighbors.add(j);//Buidling the adjacency List
                    }
                }
            }

            graph.put(i, neighbors);
        }
    }

    public int bfs(int startBomb, Map<Integer, List<Integer>> graph){

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(startBomb);
        visited.add(startBomb);

        while(!queue.isEmpty()){

            int size = queue.size();
            while(size --> 0){

                int current = queue.poll();
                for(Integer neighbour : graph.get(current)){

                    if(!visited.contains(neighbour)){
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }

            }
        }
        return visited.size();
    }
}
