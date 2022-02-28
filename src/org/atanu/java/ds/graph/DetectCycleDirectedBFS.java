package org.atanu.java.ds.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleDirectedBFS {

    public boolean hasCycle(int vertices, List<List<Integer>> adjList) {

        int[] inDegree = new int[vertices];
        for(int node = 0; node < vertices; node++) {
            for(int neighbour : adjList.get(node)) {
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

        int count = 0;
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            count++;
            //iterate over the nbrs of this node and reduce their indegree by 1
            for(int neighbour : adjList.get(currentNode)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return !(vertices == count);
    }

    public static void main(String[] args) {

        DetectCycleDirectedBFS detectCycleDirectedBFS = new DetectCycleDirectedBFS();
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

        boolean hasCycle = detectCycleDirectedBFS.hasCycle(N, graph.adjList);
        System.out.println("Has Cycle "+ hasCycle);

    }
}
