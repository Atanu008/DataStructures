package org.atanu.java.ds.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class MessageRoute {

    public void findMessageRoute(Graph graph, int source, int destination){

        int V = graph.adjList.size();
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        parent[source] = source;
        visited[source] = true;

        while (!queue.isEmpty()){

            int currentVertex = queue.poll();
            for(int u : graph.adjList.get(currentVertex)){
                if(!visited[u]){
                    queue.offer(u);
                    parent[u] = currentVertex;
                    visited[u] = true;
                }
            }
        }

        if(parent[destination] == -1){
            System.out.println("\nIMPOSSIBLE TO SEND MESSAGE BETWEEN" + source +" and "+ destination);
            return;
        }
        //Destination is the last Node
        int current = destination;
        Stack<Integer> stack = new Stack<>();
        while(current != source){
            stack.push(current);
            current = parent[current];
        }
        stack.push(source); //push the source node at last

        //print the path
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " -- ");
        }
    }

    public static void main(String[] args) {
        MessageRoute messageRoute  = new MessageRoute();
        int N = 5;//Destination Node is 5
        //will create a graph of N=1
        Graph graph = new Graph(N+1);
        graph.addEdge(1,2, false);
        graph.addEdge(1,3, false);
        graph.addEdge(1,4, false);
        graph.addEdge(2,3, false);
        graph.addEdge(3,4, false);
        graph.addEdge(4,5, false);

        messageRoute.findMessageRoute(graph, 1, 5);
        messageRoute.findMessageRoute(graph, 0, 5);
    }
}
