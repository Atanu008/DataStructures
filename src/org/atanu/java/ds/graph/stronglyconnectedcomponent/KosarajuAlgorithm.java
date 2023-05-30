package org.atanu.java.ds.graph.stronglyconnectedcomponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgorithm {

    public List<List<Integer>> stronglyConnectedComponent(int n, List<List<Integer>> edges){
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        // build the graph with direction
        buildGraph(n, edges, adjList);

        // do the topological sort with stack
        boolean[] visited = new boolean[n];
        Stack<Integer> topoOrder = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                topologicalDFS(i, adjList, visited, topoOrder);
            }
        }

        List<List<Integer>> reversedGraph = new ArrayList<>();
        transposeGraph(n, adjList, reversedGraph);
        // mark all nodes not visited for next round of DFS
        Arrays.fill(visited, false);

        while (!topoOrder.isEmpty()){

            int current = topoOrder.pop();
            List<Integer> connectedComponent = new ArrayList<>();
            if(!visited[current]){
                dfs(current, reversedGraph, visited, connectedComponent);
                result.add(connectedComponent);
            }
        }

        return result;
    }

    private void dfs(int currentNode, List<List<Integer>> reversedGraph, boolean[] visited, List<Integer> connectedComponent) {

        visited[currentNode] = true;
        connectedComponent.add(currentNode);
        for(int child : reversedGraph.get(currentNode)){
            if(!visited[child]){
                dfs(child, reversedGraph, visited, connectedComponent);
            }
        }
    }

    private void topologicalDFS(int currentNode, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> topoOrder) {

        visited[currentNode] = true;

        for(int child : adjList.get(currentNode)){
            if(!visited[child]){
                topologicalDFS(child, adjList, visited, topoOrder);
            }
        }
        topoOrder.push(currentNode); // topo sort
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

    private void transposeGraph(int n, List<List<Integer>> orginalGraph, List<List<Integer>> reversedGraph){

        for(int i = 0; i < n; i++){
            reversedGraph.add(new ArrayList<>());
        }
        for(int node = 0; node < n; node++){
            for(int child : orginalGraph.get(node)){
                reversedGraph.get(child).add(node);
            }
        }
    }

    public static void main(String[] args) {

        KosarajuAlgorithm kosarajuAlgorithm = new KosarajuAlgorithm();
        // Create a graph given in the above diagram
        List<List<Integer>> edges = new ArrayList<>();
        int n = 5;
        edges.add(Arrays.asList(1, 0));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 1));
        edges.add(Arrays.asList(0, 3));
        edges.add(Arrays.asList(3, 4));

        System.out.println("SSC in first graph ");
        List<List<Integer>> result = kosarajuAlgorithm.stronglyConnectedComponent(n , edges);
        result.forEach(System.out::println);
        edges.clear();

        n = 4;
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(2, 3));
        System.out.println("\nSSC in second graph ");
        result = kosarajuAlgorithm.stronglyConnectedComponent(n , edges);
        result.forEach(System.out::println);
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
        result = kosarajuAlgorithm.stronglyConnectedComponent(n , edges);
        result.forEach(System.out::println);
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
        result = kosarajuAlgorithm.stronglyConnectedComponent(n , edges);
        result.forEach(System.out::println); // This print is not matching with GeeksForGeeks
    }
}
