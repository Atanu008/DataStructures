package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/find-paths-given-source-destination/
//This code work for cycle as we are skipping it using visited.
public class AllPathsFromSourcetoTargetGraphV2 {
    // A directed graph using
// adjacency list representation
    private static class Graph {

        // No. of vertices in graph
        private int v;

        // adjacency list
        private ArrayList<Integer>[] adjList;

        // Constructor
        public Graph(int vertices) {

            // initialise vertex count
            this.v = vertices;

            // initialise adjacency list
            initAdjList();
        }

        // utility method to initialise
        // adjacency list
        @SuppressWarnings("unchecked")
        private void initAdjList() {
            adjList = new ArrayList[v];

            for (int i = 0; i < v; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        // add edge from u to v
        public void addEdge(int u, int v) {
            // Add v to u's list.
            adjList[u].add(v);
        }
    }
        // A recursive function to print
        // all paths from 'u' to 'd'.
        // isVisited[] keeps track of
        // vertices in current path.
        // localPathList<> stores actual
        // vertices in the current path
        private void printAllPaths(Graph graph, Integer u, Integer d,
                                       boolean[] isVisited,
                                       List<Integer> localPathList)
        {

            if (u.equals(d)) {
                System.out.println(localPathList);
                // if match found then no need to traverse more till depth
                return;
            }

            // Mark the current node
            isVisited[u] = true;

            // Recur for all the vertices
            // adjacent to current vertex
            for (Integer i : graph.adjList[u]) {
                if (!isVisited[i]) {
                    // store current node
                    // in path[]
                    localPathList.add(i);
                    printAllPaths(graph, i, d, isVisited, localPathList);
                    // remove current node
                    // in path[]
                    localPathList.remove(i);
                }
            }

            // Mark the current node
            isVisited[u] = false;
        }

        // Driver program
        public static void main(String[] args)
        {
            // Create a sample graph
            Graph graph = new Graph(4);
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(0, 3);
            graph.addEdge(2, 0);
            graph.addEdge(2, 1);
            graph.addEdge(1, 3);

            // arbitrary source
            int s = 2;

            // arbitrary destination
            int d = 3;

            AllPathsFromSourcetoTargetGraphV2 pathFinder = new AllPathsFromSourcetoTargetGraphV2();
            System.out.println(
                    "Following are all different paths from "
                            + s + " to " + d);

            boolean[] isVisited = new boolean[graph.v];
            ArrayList<Integer> pathList = new ArrayList<>();

            // add source to path[]
            pathList.add(s);

            pathFinder.printAllPaths(graph, s, d, isVisited, pathList);
        }


}
