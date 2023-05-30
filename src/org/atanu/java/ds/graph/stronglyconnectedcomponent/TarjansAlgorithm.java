package org.atanu.java.ds.graph.stronglyconnectedcomponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// Back edges :  point from a node to one of its ancestors in the DFS tree.
// Forward edges : point from a node to one of its descendants.
// Cross edges : point from a node to a previously visited node that is neither an ancestor nor a descendant.

// https://www.topcoder.com/thrive/articles/tarjans-algorithm-for-strongly-connected-components (why stack is needed explained)
// https://www.baeldung.com/cs/scc-tarjans-algorithm
// https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/
// https://gist.github.com/SuryaPratapK/41adc04cc89a3ffb6e8d2398f6fd2a8d
// Video : https://www.youtube.com/watch?v=ZeDNSeilf-Y

// ALGORITHM:
// To cope with the random traversal order of the DFS,
// Tarjan’s algorithm maintains a stack of valid nodes from which to update low-link values.
// Nodes are added to the stack of valid nodes as they are explored for the first time.
// Nodes are removed from the stack each time a complete SCC is found.

// UPDATE CONDITION FOR LOW-LINK
// If u and v are nodes in a graph and we were currently exploring u, then our new low-link update condition is:
// To update node u to node v low-link there has to be a path of edges from u to v and node v must be on the stack.

// Algorithm
// 1. A dfs is run over the nodes and the subtrees of SCCs are removed and recorded as they are encounered.

// 2. Two values dfs_discovered(u) and dfs_low(u) are maintained for each of the users.
//    dfs_discovered(u) is the value of the counter when the node u is explored for the first time.
//    dfs_low(u) stores the lowest dfs_discovered reachable from u which is not the part of another SCC.

// 3. As the nodes are explored, they are pushed onto a stack.
// 4. The unexplored children of a node are explored and dfs_low(u) is accordingly updated.
//    A node is encountered with dfs_low(u) == dfs_discovered(u) is the first explored node in its strongly connected component
//    and all the nodes above it in the stack are popped out and assigned the appropriate SCC number.

public class TarjansAlgorithm {

    private int time = 1; // class level var is needed to track time
    public void stronglyConnectedComponent(int n, List<List<Integer>> edges){

        // Discovered Time : Time at which current node was discovered during DFS
        int[] discovered = new int[n];
        // Initializing discovered for all nodes as -1 ,
        // Its like not visited. In this was we don't have to maintain a separate Array for visited
        Arrays.fill(discovered, -1);
        // Lowest Time : it is the discovered time of a node which can be traversed by at most one back-edge in current subtree
        int[] low = new int[n];
        Arrays.fill(low, -1); // its not necessary

        boolean[] inStack = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> adjList = new ArrayList<>();
        //Build Directed Graph
        buildGraph(n , edges, adjList);

        for(int i = 0; i < n; i++){
            if(discovered[i] == -1){
                findComponent(i, adjList, discovered, low, inStack, stack);
            }
        }

        System.out.println(Arrays.toString(discovered));
        System.out.println(Arrays.toString(low));
    }

    private void findComponent(int currentNode, List<List<Integer>> adjList, int[] discovered, int[] low, boolean[] inStack, Stack<Integer> stack) {

        inStack[currentNode] = true;
        stack.push(currentNode);
        discovered[currentNode] = time;
        low[currentNode] = time;
        time++;

        for(int child : adjList.get(currentNode)){

            if(discovered[child] == -1){
                findComponent(child, adjList, discovered, low, inStack, stack);
                // Check if the subtree rooted with child has a connection to one of the ancestors of currentNode
                low[currentNode] = Math.min(low[currentNode], low[child]);
            }
            // Successor child is in stack S and hence in the current SCC
            // If w is not on stack, then (currentNode, child) is an edge pointing to an SCC already found and must be ignored
            // it does not necessarily have to be a back-edge . Doubt ? why so. looks like considering cross-edge

            // update low currentNode as child is in stack means for child in not in different SSC (check step 2 in Algorithm)
            // Check fourth Graph for better understanding
            else if(inStack[child]){

                low[currentNode] = Math.min(low[currentNode], discovered[child]);
            }
        }

        // For starting node of the cycle discovered[currentNode] == low[currentNode]
        // all the other nodes low will be less than the discovered time for back-edge, only the head/start will have them same
        // do back track to get the cycle,
        if(discovered[currentNode] == low[currentNode]){
            while (stack.peek() != currentNode){
                int poppedNode = stack.pop();

                System.out.print( poppedNode+ " ");
                inStack[poppedNode] = false; // mark it as a part of SSC
            }
            inStack[stack.peek()] = false; // mark it as a part of SSC
            System.out.println(stack.pop() + " "); // pop currentNode
        }

        //inStack[currentNode] = false; , we should not do this, only found SSC items will be marked not is stack
    }

    public static void main(String[] args) {

        TarjansAlgorithm tarjansAlgorithm = new TarjansAlgorithm();
        // Create a graph given in the above diagram
        List<List<Integer>> edges = new ArrayList<>();
        int n = 5;
        edges.add(Arrays.asList(1, 0));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 1));
        edges.add(Arrays.asList(0, 3));
        edges.add(Arrays.asList(3, 4));

        //System.out.println("SSC in first graph ");
        //tarjansAlgorithm.stronglyConnectedComponent(n , edges);
        edges.clear();

        n = 4;
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(2, 3));
        //System.out.println("\nSSC in second graph ");
        //tarjansAlgorithm.stronglyConnectedComponent(n , edges);
        edges.clear();

        n = 7;
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(2, 0));
        edges.add(Arrays.asList(1, 3));
        edges.add(Arrays.asList(1, 4));
        edges.add(Arrays.asList(1, 6));
        edges.add(Arrays.asList(3, 5));
        edges.add(Arrays.asList(4, 5));
        //System.out.println("\nSSC in third graph ");
        //tarjansAlgorithm.stronglyConnectedComponent(n , edges);
        edges.clear();

        n = 11;
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 3));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(1, 4));
        edges.add(Arrays.asList(2, 0));
        edges.add(Arrays.asList(2, 6));
        edges.add(Arrays.asList(3, 2));
        edges.add(Arrays.asList(4, 5));
        edges.add(Arrays.asList(4, 6));
        edges.add(Arrays.asList(5, 6));
        edges.add(Arrays.asList(5, 7));
        edges.add(Arrays.asList(5, 8));
        edges.add(Arrays.asList(5, 9));
        edges.add(Arrays.asList(6, 4));
        edges.add(Arrays.asList(7, 9));
        edges.add(Arrays.asList(8, 9));
        edges.add(Arrays.asList(9, 8));
        System.out.println("\nSSC in fourth graph ");
        tarjansAlgorithm.stronglyConnectedComponent(n , edges); // This print is not matching with GeeksForGeeks
    }

    private void buildGraph(int n, List<List<Integer>> connections, List<List<Integer>> adjList) {

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.size(); i++) {
            int nodeA = connections.get(i).get(0);
            int nodeB = connections.get(i).get(1);
            adjList.get(nodeA).add(nodeB);
        }
    }
}
