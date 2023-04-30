package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/path-with-maximum-probability/description/
// Leetcode 1514

// Just Dijkstra implementation , will calculate Max probability :)

public class PathWithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        List<List<Node>> adjList = new ArrayList<>();
        //Create for all nodes
        for(int i = 0; i < n; i++){
            adjList.add(i, new ArrayList<>());
        }

        //Zero based Indexing, only create edge for given data
        for(int i = 0; i < edges.length; i++){
            adjList.get(edges[i][0]).add(new Node(edges[i][1], succProb[i]));
            adjList.get(edges[i][1]).add(new Node(edges[i][0], succProb[i]));
        }

        //Default probabilities would be zero as initially all nodes are not reachable
        double[] probablities = new double[n];
        probablities[start] = 1.0; //Start node probability is always One , as we already there :)

        boolean[] visited = new boolean[n];
        //Max Heap As we need max Probability
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.probablity, a.probablity));
        maxHeap.offer(new Node(start, 1.0));

        while(!maxHeap.isEmpty()){

            Node current = maxHeap.poll();
            int currentNode = current.node;
            double currentProbablity = current.probablity;

            if(visited[currentNode]){
                continue;
            }
            if(currentNode == end){
                return probablities[currentNode];
            }
            visited[currentNode] = true;

            for(Node neighbour : adjList.get(currentNode)){
                int nextNode = neighbour.node;
                double nextNodeProbablity = neighbour.probablity;
                double nextNodeReachingProbablity = currentProbablity * nextNodeProbablity;

                if(!visited[nextNode] && nextNodeReachingProbablity > probablities[nextNode]){
                    probablities[nextNode] =  nextNodeReachingProbablity;
                    maxHeap.offer(new Node(nextNode, nextNodeReachingProbablity));
                }

            }
        }

        return 0.0;

    }

    class Node{
        int node;
        double probablity;

        Node(int node, double probablity){
            this.node = node;
            this.probablity = probablity;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0;
        int end = 2;


    }
}
