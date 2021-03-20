package org.atanu.java.ds.graph;

public class DetectCycleDirectedOne {

    private static boolean hasCycle(Graph graph, int v, boolean[] discovered, boolean[] inResurssion) {

        //If it is in recurssion return True
        if (inResurssion[v] == true) {
            return true;
        }

        //Mark in recursion
        inResurssion[v] = true;
        //Mark it visited. We can mark after the while as well.
        discovered[v] = true;
        for (int u : graph.adjList.get(v)) {
            if (hasCycle(graph, u, discovered, inResurssion)) {
                return true;
            }

        }

        // Make the recurssion is false again
        inResurssion[v] = false;
        return false;

    }

    public static void main(String[] args) {

        int N = 4;
        boolean[] discovered = new boolean[N];
        boolean[] inResurssion = new boolean[N];

        Graph graph = new Graph(N);
        graph.addEdge(new Edge(0, 1), true);
        graph.addEdge(new Edge(0, 2), true);
        graph.addEdge(new Edge(1, 2), true);
        graph.addEdge(new Edge(2, 0), true);
        graph.addEdge(new Edge(2, 3), true);
        graph.addEdge(new Edge(3, 3), true);

        for (int i = 0; i < N; i++) {

            if (!discovered[i] && hasCycle(graph, i, discovered, inResurssion)) {
                System.out.println("This Graph Has Cycle"); // Will Print True for each connected component. you can return hergi
            }
            if (!discovered[i]) {
                boolean result = hasCycle(graph, i, discovered, inResurssion);
                System.out.println(result + " " + i); // Printing the cycle check for non conncted components
            }
        }
    }
}