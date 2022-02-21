package org.atanu.java.ds.graph;

import java.util.List;

public class DetectCycleDirectedOneV2 {

    public boolean hasCycleDFS(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] inRecursion) {

        inRecursion[node] = true;
        visited[node] = true;

        for(int neighbour : adjList.get(node)) {
            //Return True if the neighbour is in recursion
            if(inRecursion[neighbour]) {
                return true;
            }
            //Deep In Recursion if one has cycle
            else if(!visited[neighbour] && hasCycleDFS(neighbour, adjList, visited, inRecursion)) {
                return true;
            }
        }

        inRecursion[node] = false;
        return false;
    }

    public boolean hasCycle(int vertices, List<List<Integer>> adjList) {
        DetectCycleDirectedOneV2 detectCycle = new DetectCycleDirectedOneV2();
        boolean[] visited = new boolean[vertices];
        boolean[] inRecursion = new boolean[vertices];

        for(int node = 0; node < vertices; node++) {
            if(!visited[node]) {
                if(hasCycleDFS(node, adjList, visited, inRecursion)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int N = 4;
        boolean[] visited = new boolean[N];
        boolean[] inResurssion = new boolean[N];

        Graph graph = new Graph(N);
        graph.addEdge(new Edge(0, 1), true);
        graph.addEdge(new Edge(0, 2), true);
        graph.addEdge(new Edge(1, 2), true);
        graph.addEdge(new Edge(2, 0), true); //Comment this for No Cycle
        graph.addEdge(new Edge(2, 3), true);
        graph.addEdge(new Edge(3, 3), true); //Comment this for No Cycle

        DetectCycleDirectedOneV2 detectCycle = new DetectCycleDirectedOneV2();
        boolean result = detectCycle.hasCycle(N, graph.adjList);
        System.out.println("Has Cycle "+ result);
    }
}
