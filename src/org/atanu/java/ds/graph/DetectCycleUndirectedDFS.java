package org.atanu.java.ds.graph;

//https://www.techiedelight.com/check-undirected-graph-contains-cycle-not/
//https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/27022082#announcements
public class DetectCycleUndirectedDFS {

    private static boolean hasCycle(int node, int parent, Graph graph, boolean[] visited) {

        visited[node] = true;

        for(int neighbour : graph.adjList.get(node)){
            // if neighbour is not discovered
            if(!visited[neighbour]){
                if(hasCycle(neighbour, node, graph, visited)){
                    return true;
                }
            }
            // if neighbour is discovered, and neighbour is not a parent
            else if(neighbour != parent){
                // we found a back-edge (cycle)
                System.out.println("Node "+ node +" Parent "+parent+" Neighbour "+ neighbour);
                return true;
            }
        }
        // No back-edges were found in the graph
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
        graph.addEdge(new Edge(1, 4), false);//This forms a cycle

        //Check for different component
        //For one component this loop is not necessary
        for(int i = 0; i <N; i++){
            boolean[] visited = new boolean[N];
            if(hasCycle(i, -1, graph, visited)){
                System.out.println("Cycle Found");
                break;
            }
        }

    }


}
