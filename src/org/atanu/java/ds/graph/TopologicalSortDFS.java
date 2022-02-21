package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSortDFS {

    public List<Integer> topoLogicalSort(int vertices, List<List<Integer>> adjList) {

        //Could have used a stack , In that case we dont have reverse it. now we have to reverse it
        List<Integer> sortedOrder = new ArrayList<>();
        boolean[] visited = new boolean[vertices];

        for(int node = 0; node < vertices; node++) {
            if(!visited[node]) {
                dfs(node, adjList, sortedOrder, visited);
            }
        }

        Collections.reverse(sortedOrder);
        return sortedOrder;
    }

    public void dfs(int node, List<List<Integer>> adjList, List<Integer> sortedOrder, boolean[] visited) {

        visited[node] = true;

        for (int neighbour : adjList.get(node)) {
            if(!visited[neighbour]) {
                dfs(neighbour, adjList, sortedOrder, visited);
            }
        }

        sortedOrder.add(node);
    }

    public static void main(String[] args) {
        TopologicalSortDFS topologicalSort = new TopologicalSortDFS();

        // Create a graph given in the above diagram
        Graph graph = new Graph(6);
        graph.addEdge(5, 2, true);
        graph.addEdge(5, 0, true);
        graph.addEdge(4, 0, true);
        graph.addEdge(4, 1, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 1, true);

        List<Integer> sortedOrder = topologicalSort.topoLogicalSort(graph.V, graph.adjList);
        System.out.println(sortedOrder);

        Graph graph1 = new Graph(4);
        graph1.addEdge(3, 2, true);
        graph1.addEdge(3, 0, true);
        graph1.addEdge(2, 0, true);
        graph1.addEdge(2, 1, true);
        sortedOrder = topologicalSort.topoLogicalSort(graph1.V, graph1.adjList);
        System.out.println(sortedOrder);

        Graph graph2 = new Graph(7);
        graph2.addEdge(6, 4, true);
        graph2.addEdge(6, 2, true);
        graph2.addEdge(5, 3, true);
        graph2.addEdge(5, 4, true);
        graph2.addEdge(3, 0, true);
        graph2.addEdge(3, 1, true);
        graph2.addEdge(3, 2, true);
        graph2.addEdge(4, 1, true);
        sortedOrder = topologicalSort.topoLogicalSort(graph2.V, graph2.adjList);
        System.out.println(sortedOrder);
    }
}
