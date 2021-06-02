package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;
//https://www.geeksforgeeks.org/find-paths-given-source-destination/ -- Implementation is Different
//This visited Matrix is needed for Cycle check only. Not needed in case of DAG
public class AllPathsFromSourcetoTargetGraphV3 {
    List<List<Integer>> result = new ArrayList<>(); // This result will be updated
    public void printAllPaths(List<List<Integer>> graph, int node, int destination, boolean[] visited, List<Integer> path){
        if(node == destination){
            result.add(new ArrayList<>(path));
        }

        for(int u : graph.get(node)){
            if (!visited[u]) {
                visited[u] = true;
                path.add(u);
                printAllPaths(graph, u, destination, visited, path);
                visited[u] = false;
                path.remove(path.size() -1);
            }

        }
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1 ,1},
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        AllPathsFromSourcetoTargetGraphV3  allPathsFromSourcetoTargetGraphV3 = new AllPathsFromSourcetoTargetGraphV3();

        //Prepare the Adjacency List
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < grid.length ; i++){
            List<Integer> connection = new ArrayList<>();
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] != 0)
                    connection.add(j);
            }
            graph.add(new ArrayList<>(connection));
        }

        int source = 2;
        int destination = 3;
        List<Integer> path = new ArrayList<>();
        //Create a visited Matrix . This visited Matrix is needed for Cycle check only. Not needed in case of DAG
        boolean[] visited = new boolean[graph.size()]; // Size of the Total Node

        //Add Source as starting point in path. Mark Visited
        path.add(source);
        visited[source] = true;
        //Print Path
        allPathsFromSourcetoTargetGraphV3.printAllPaths(graph, source, destination, visited, path);
        allPathsFromSourcetoTargetGraphV3.result.forEach(System.out::println);
    }
}
