package org.atanu.java.ds.graph;

public class DetectCycleDirectedDFSV1 {

    private static boolean hasCycle(Graph graph, int v, boolean[] visited, boolean[] inRecursion) {

        //If it is in recursion return True
        //if node is currently in recursion stack that means we have found a cycle
        if (inRecursion[v]) {
            return true;
        }
        //if it is already visited (and not in Stack) then there is no cycle
        if(visited[v]) {
            return false;
        }
        //Mark in recursion
        inRecursion[v] = true;
        //Mark it visited. We can mark after the while as well.
        visited[v] = true;

        //run cyclic function recursively on each neighbour path
        for (int u : graph.adjList.get(v)) {
            if (hasCycle(graph, u, visited, inRecursion)) {
                return true;
            }

        }

        // Make the recursion is false again
        inRecursion[v] = false;
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
        graph.addEdge(new Edge(2, 0), true);
        graph.addEdge(new Edge(2, 3), true);
        graph.addEdge(new Edge(3, 3), true);

        for (int i = 0; i < N; i++) {

            if (!visited[i] && hasCycle(graph, i, visited, inResurssion)) {
                System.out.println("This Graph Has Cycle"); // Will Print True for each connected component. you can return hergi
            }
            if (!visited[i]) {
                boolean result = hasCycle(graph, i, visited, inResurssion);
                System.out.println(result + " " + i); // Printing the cycle check for non conncted components
            }
        }
    }
}