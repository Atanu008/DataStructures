package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// Similar Problem : Find if a given Directed Graph has a cycle in it or not.
//If we can’t determine the topological ordering of all the vertices of a directed graph, the graph has a cycle in it.
// i.e if(sortedOrder.size() != vertices) {
//            return new ArrayList<>();
//        }

//Time Complexity#
//In step ‘d’, each vertex will become a source only once and each edge will be accessed and removed once. Therefore, the time complexity of the above algorithm will be O(V+E)O(V+E), where ‘V’ is the total number of vertices and ‘E’ is the total number of edges in the graph.
//Space Complexity#
//The space complexity will be O(V+E)O(V+E), since we are storing all of the edges for each vertex in an adjacency list.
public class TopologicalSortKahnsAlgorithm {

    public List<Integer> topoLogicalSort(int vertices, List<List<Integer>> adjList) {

        int[] inDegree = new int[vertices];

        //Iterate over all the edges to find the right indegree
        for(int i = 0; i < vertices; i++) {
           for(int neighbour : adjList.get(i)) {
               inDegree[neighbour]++;
           }
        }

        //Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> queue = new LinkedList<>();
        for(int node = 0; node < vertices; node++) {
            if(inDegree[node] == 0){
                queue.offer(node);
            }
        }

        //For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        //if a child's in-degree becomes zero, add it to the sources queue
        List<Integer> sortedOrder = new ArrayList<>();

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            sortedOrder.add(currentNode);
            //iterate over the nbrs of this node and reduce their indegree by 1
            for(int neighbour : adjList.get(currentNode)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        // topological sort is not possible as the graph has a cycle
        if(sortedOrder.size() != vertices) {
            return new ArrayList<>();
        }

        return sortedOrder;
    }
    public static void main(String[] args) {
        TopologicalSortKahnsAlgorithm topologicalSort = new TopologicalSortKahnsAlgorithm();
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
