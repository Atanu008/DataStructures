package org.atanu.java.ds.graph;

//https://www.techiedelight.com/check-undirected-graph-contains-cycle-not/
//https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/27022082#announcements
// https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/26857748#overview

// This back-edge concept will not work for directed graphs (check few minutes from 2 min)
// Check https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/26857760#overview
// suppose there is a directed edge from 2 -> 1.
// We start DFS from 1 and mark it visited
// Now we start from 2 and goes to 1
// But one is visited and NOT 2's parent , so according to this algorithm this is a cycle
// Bit its not a cycle ,
// So this algorithm does not work for directed graphs

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
                // Back-edge denotes a cycle in graph
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
