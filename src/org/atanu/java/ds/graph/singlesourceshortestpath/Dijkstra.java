package org.atanu.java.ds.graph.singlesourceshortestpath;

import java.util.*;

public class Dijkstra {

    public int dijkstraShortestPath(Graph graph, int source, int destination){

        int V = graph.V;
        int[] distances = new int[V];
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        distances[source] = 0;
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()){

            Node current = minHeap.poll();
            int currnetNode = current.destination;
            int currentDistance = current.weight;

            if(currnetNode == destination){
                return distances[currnetNode];
            }

            visited[currnetNode] = true;

            for(Node neighbour : graph.adjList.get(currnetNode)){

                int nextNode = neighbour.destination;
                int nextWeight = neighbour.weight;
                int nextDistance = currentDistance + nextWeight;

                if(!visited[nextNode] && nextDistance < distances[nextNode]){
                    distances[nextNode] = nextDistance;
                    parent[nextNode] = currnetNode;
                    //minHeap.remove(neighbour);
                    minHeap.offer(new Node(nextNode, nextDistance));
                }
            }
        }

        return -1; // destination not found;
    }

     static class Graph{
        int V;
        List<List<Node>> adjList;
          Graph(int v){
              V = v;
              adjList = new ArrayList<>();
              for(int i = 0; i < V; i++){
                  adjList.add(new ArrayList<>());
              }
        }

        void addEdge(int source, int destination, int weight, boolean directed){

              adjList.get(source).add(new Node(destination, weight));
              if(!directed){
                  adjList.get(destination).add(new Node(source, weight));
              }
        }
    }

     static class Node{
        int destination;
        int weight;

        public Node(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }


    public static void main(String[] args) {

        Dijkstra dijkstra = new Dijkstra();

        Graph graph = new Graph(5);
        graph.addEdge(0,1,1, false);
        graph.addEdge(1,2,1, false);
        graph.addEdge(0,2,4, false);
        graph.addEdge(0,3,7, false);
        graph.addEdge(3,2,2, false);
        graph.addEdge(3,4,3, false);

        System.out.println(dijkstra.dijkstraShortestPath(graph,0,4));
    }
}
