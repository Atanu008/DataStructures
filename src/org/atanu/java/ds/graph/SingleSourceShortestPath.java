package org.atanu.java.ds.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class SingleSourceShortestPath {

    public void shortestPath(Graph graph, int source, int destination, boolean[] visited){

        int V = graph.adjList.size();
        int[] distance = new int[V];
        int[] parent = new int[V];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visited[source] = true;
        distance[source] = 0;
        parent[source] = source;

        while(!queue.isEmpty()){

            int current = queue.poll();

            for(int u : graph.adjList.get(current)){
                if(!visited[u]){
                    queue.offer(u);
                    visited[u] = true;
                    distance[u] = distance[current] + 1;
                    parent[u] = current;
                }
            }
        }

        // Minimum Distance from Source to destination
        for (int i = 0; i < V; i++) {
            System.out.println("Minimum Distance form Root to "+ i+ " is "+ distance[i]);
        }

        //Print the Path between source and destination
        int current = destination;
        StringBuilder path = new StringBuilder("");
        while(current != source){
            path.append(current + "--");
            System.out.print(current + " -- ");
            current = parent[current];
        }
        System.out.println(source);

        System.out.println("++++");
        path.append(source);
        System.out.println(path.reverse().toString());

    }

    public static void main(String[] args) {

        SingleSourceShortestPath bfsShortestPath = new SingleSourceShortestPath();
        int N = 7;
        Graph graph = new Graph(N);
        graph.addEdge(0,1, false);
        graph.addEdge(1,2, false);
        graph.addEdge(2,3, false);
        graph.addEdge(3,5, false);
        graph.addEdge(5,6, false);
        graph.addEdge(4,5, false);
        graph.addEdge(0,4, false);
        graph.addEdge(3,4, false);

        boolean[] visited = new boolean[N];
        bfsShortestPath.shortestPath(graph, 1, 6, visited);

    }
}
