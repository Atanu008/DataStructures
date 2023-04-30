package org.atanu.java.ds.graph.stronglyconnectedcomponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://www.topcoder.com/thrive/articles/tarjans-algorithm-for-strongly-connected-components
// https://www.baeldung.com/cs/scc-tarjans-algorithm
// https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/
// https://gist.github.com/SuryaPratapK/41adc04cc89a3ffb6e8d2398f6fd2a8d
// Video : https://www.youtube.com/watch?v=ZeDNSeilf-Y
public class TarjansAlgorithm {

    public void stronglyConnectedComponent(int n, List<List<Integer>> edges){

        // Discovered Time : Time at which current node was discovered during DFS
        int[] discovered = new int[n];
        // Initializing discovered for all nodes as -1 ,
        // Its like not visited. In this was we don't have to maintain a separate Array for visited
        Arrays.fill(discovered, -1);
        // Lowest Time : it is the discovered time of a node which can be traversed by at most one back-edge in current subtree
        int[] low = new int[n];
        Arrays.fill(discovered, -1); // its not necessary

        boolean[] inRecursion = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> adjList = new ArrayList<>();
        //Build Dirested Graph
        buildGraph(n , edges, adjList);

        for(int i = 0; i < n; i++){
            if(discovered[i] == -1){
                findComponent(i, adjList, discovered, low, inRecursion, stack, 1);
            }
        }

    }

    private void findComponent(int currentNode, List<List<Integer>> adjList, int[] discovered, int[] low, boolean[] inRecursion, Stack<Integer> stack, int time) {

        inRecursion[currentNode] = true;
        stack.push(currentNode);
        discovered[currentNode] = time;
        low[currentNode] = time;
        time++;

        for(int child : adjList.get(currentNode)){

            if(discovered[child] == -1){
                findComponent(child, adjList, discovered, low, inRecursion, stack, time);
                // Check if the subtree rooted with child has a connection to one of the ancestors of currentNode
                low[currentNode] = Math.min(low[currentNode], low[child]);
            }
            // If child is still in recursion tree then there is cycle via a back-edge
            // update low
            else if(inRecursion[child]){
                // As there can be many back-edges, finds the ancestor with the least discovery time
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
                inRecursion[poppedNode] = false; // I dint think this is necessary , as we are doing inRecursion is false in last dfs statement line 68
            }
            inRecursion[stack.peek()] = false; // I dint think this is necessary , as we are doing inRecursion is false in last dfs statement line 68
            System.out.println(stack.pop() + " "); // pop currentNode
        }

        inRecursion[currentNode] = false;
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

        System.out.println("SSC in first graph ");
        tarjansAlgorithm.stronglyConnectedComponent(n , edges);
        edges.clear();

        n = 4;
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(2, 3));
        System.out.println("\nSSC in second graph ");
        tarjansAlgorithm.stronglyConnectedComponent(n , edges);
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
        System.out.println("\nSSC in third graph ");
        tarjansAlgorithm.stronglyConnectedComponent(n , edges);
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
