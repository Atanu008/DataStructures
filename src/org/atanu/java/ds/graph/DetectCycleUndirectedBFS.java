package org.atanu.java.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUndirectedBFS {

    public static boolean hasCycle(Graph graph, int src, int N)
    {
        // to keep track of whether a vertex is discovered or not
        boolean[] visited = new boolean[N];
        // mark the source vertex as discovered
        visited[src] = true;
        // create a queue for doing BFS and
        // enqueue source vertex
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(src, -1));

        while (!queue.isEmpty()){
            Node currentNode = queue.poll();
            // do for every edge (v, u)
            for(int neighbour: graph.adjList.get(currentNode.node)){
                if(!visited[neighbour]){
                    // mark it as discovered
                    visited[neighbour] = true;
                    // construct the queue node containing info
                    // about vertex and enqueue it
                    queue.offer(new Node(neighbour, currentNode.node));
                }
                // `neighbour` is discovered, and `neighbour` is not a parent
                else if (neighbour != currentNode.parent){
                    // we found a cross-edge, i.e., the cycle is found
                    System.out.println("neighbour "+ neighbour + " currentNode.node "+ currentNode.node + " currentNode.parent "+ currentNode.parent);
                    return true;
                }
            }
        }
        // no cross-edges were found in the graph
        return false;
    }

    public static void main(String[] args) {
        int N = 5;
        //boolean[] visited = new boolean[N]; // take primitive only as in primitive default value is false, where as in  wrapper Boolean its null

        Graph graph = new Graph(N);
        graph.addEdge(new Edge(0, 1), false);
        graph.addEdge(new Edge(1, 2), false);
        graph.addEdge(new Edge(2, 3), false);
        graph.addEdge(new Edge(3, 4), false);
        //graph.addEdge(new Edge(1, 4), false);//This forms a cycle

        if(hasCycle(graph, 0, N)){
            System.out.println("The graph contains a cycle");
        }
        else {
            System.out.println("The graph doesn't contain any cycle");
        }
    }
    private static class Node{
        int node;
        int parent;

        public Node(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}
