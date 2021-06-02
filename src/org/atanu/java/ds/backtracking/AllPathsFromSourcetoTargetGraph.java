package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//LeetCode 797
//https://leetcode.com/problems/all-paths-from-source-to-target/
//This code is good for DAG. for cycle we may need a visited array
public class AllPathsFromSourcetoTargetGraph {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(graph, 0, path, result);
        return result;
    }

    public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result){

        //Reached the last node
        if(node == graph.length - 1){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int neighbour : graph[node]){
            //Add the neighbour
            path.add(neighbour);
            //Recurse for that neighbour
            dfs(graph, neighbour, path, result);
            //Remove it from Path. //backtracking
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        AllPathsFromSourcetoTargetGraph paths = new AllPathsFromSourcetoTargetGraph();
        List<List<Integer>> result = paths.allPathsSourceTarget(graph);
        result.forEach(System.out::println);
    }
}
