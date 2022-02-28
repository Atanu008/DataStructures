package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/minimum-height-trees/
//LeetCode 310
//https://www.educative.io/courses/grokking-the-coding-interview/7nDN8y7JKVA
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int nodes, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();
        //Base Case
        if(nodes <= 0) {
            return minHeightTrees;
        }
        // with only one node, since its in-degree will be 0, therefore, we need to handle it separately
        if(nodes == 1) {
            minHeightTrees.add(0);
            return minHeightTrees;
        }

        //Define Graph and InDegree
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        //Initialize the graph
        for(int node = 0; node < nodes; node++) {
            adjList.put(node, new ArrayList<>());
            inDegree.put(node, 0);
        }

        // b. Build the graph
        // since this is an undirected graph, therefore, add a link for both the nodes
        // increment the in-degrees of both the nodes
        for(int[] edge : edges) {
            int vertexA = edge[0];
            int vertexB = edge[1];

            adjList.get(vertexA).add(vertexB);
            inDegree.put(vertexB, inDegree.get(vertexB) +1);

            adjList.get(vertexB).add(vertexA);
            inDegree.put(vertexA, inDegree.get(vertexA) +1);

        }
        //Find all leaves i.e., all nodes with only 1 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 1) {
                queue.add(entry.getKey());
            }
        }

        //Remove leaves level by level and subtract each leave's children's in-degrees.
        // Repeat this until we are left with 1 or 2 nodes, which will be our answer.
        // Any node that has already been a leaf cannot be the root of a minimum height tree, because
        // its adjacent non-leaf node will always be a better candidate.
        while(nodes > 2) {

            int size = queue.size();
            nodes -= size;

            while(size --> 0) {

                int node = queue.poll();
                for(int neighbour : adjList.get(node)) {
                    inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                    if(inDegree.get(neighbour) == 1) { // if the child has become a leaf
                        queue.add(neighbour);
                    }
                }
            }
        }

        minHeightTrees.addAll(queue);
        return minHeightTrees;
    }

    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();

        List<Integer> result = minimumHeightTrees.findMinHeightTrees(5,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
        System.out.println("Roots of MHTs: " + result);

        result = minimumHeightTrees.findMinHeightTrees(4,
                new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
        System.out.println("Roots of MHTs: " + result);

        result = minimumHeightTrees.findMinHeightTrees(4,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
        System.out.println("Roots of MHTs: " + result);

        result = minimumHeightTrees.findMinHeightTrees(6,
                new int[][] { new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 3, 4 }, new int[] { 5, 4 } });
        System.out.println("Roots of MHTs: " + result);
    }
}
