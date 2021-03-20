package org.atanu.java.ds.graph;

public class DetectCycleDirectedTwo {

    enum Status {
        UNVISITED, INRECURSSION, VISITED
    }

    public static boolean hasCycle(Graph graph, int v, Status[] discovered) {

        // May be redundant
        if (discovered[v] == Status.INRECURSSION) {
            return true;
        }

        if (discovered[v] == Status.VISITED) {
            return false;
        }

        //Mark the node in Recursion
        discovered[v] = Status.INRECURSSION;

        for (int u : graph.adjList.get(v)) {
            //Return True if the neighbour is in recursion
            if (discovered[u] == Status.INRECURSSION) {
                return true;
            }

            //Deep in recursion for non visited neighbours
            if (discovered[u] == Status.UNVISITED && hasCycle(graph, u, discovered)) {
                return true;
            }
        }
        //Mark visited after visting all the neighbours
        discovered[v] = Status.VISITED;
        return false;

    }

    public static void main(String[] args) {

        int N = 4;
        Status[] discovered = new Status[N];

        Graph graph = new Graph(N);
        graph.addEdge(new Edge(0, 1), true);
        graph.addEdge(new Edge(0, 2), true);
        graph.addEdge(new Edge(1, 2), true);
        graph.addEdge(new Edge(2, 0), true);
        graph.addEdge(new Edge(2, 3), true);
        graph.addEdge(new Edge(3, 3), true);

        for (int i = 0; i < N; i++) {
            discovered[i] = Status.UNVISITED;
        }
        for (int i = 0; i < N; i++) {

            if (discovered[i] == Status.UNVISITED && hasCycle(graph, i, discovered)) {
                System.out.println("This Graph Has Cycle with Starting Index " + i);
            }
            /*if (discovered[i] == Status.UNVISITED) {
                boolean result = hasCycle(graph, i, discovered);
                System.out.println(result + " " + i); // Printing the cycle check for non conncted components
            }*/
        }

    }

}