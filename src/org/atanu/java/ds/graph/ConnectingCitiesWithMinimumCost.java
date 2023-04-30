package org.atanu.java.ds.graph;

// https://leetcode.com/problems/connecting-cities-with-minimum-cost/description/
// Leetcode 1135

/*

There are n cities labeled from 1 to n. You are given the integer n and an array connections where
connections[i] = [xi, yi, costi] indicates that the cost of connecting city xi and city yi
(bidirectional connection) is costi.

Return the minimum cost to connect all the n cities such that there is at least one path between each pair
of cities. If it is impossible to connect all the n cities, return -1,

The cost is the sum of the connections' costs used.

Example 1:
Input: n = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
Output: 6
Explanation: Choosing any 2 edges will connect all cities so we choose the minimum 2.


TC : o(ElogV)
SC: o(n)

 */

// Minimum Spanning Tree: In an undirected weighted graph, there is a tree (N nodes, N - 1 edges so no circle) that connects all nodes in the graph,
// and the sum of path weights are minimum.

// Kruskal's Algorithm: The approach to find the Minimum Spanning Tree in the Graph.
// We sort the edges by weight in non - descending order and loop sorted edges, pick the edge as long as there are no connectivity already set up between two nodes and add this edge weight to the total weight.

// Disjoint Set: The data structure used to check the connectivity of graph efficiently in dynamic by union the nodes into one set,
// and find the number of disconnected sets.

import java.util.Arrays;

public class ConnectingCitiesWithMinimumCost {

    public int minimumCost(int n, int[][] connections) {

        UnionFind unionFind = new UnionFind(n + 1); // n + 1, as it starts from 1

        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int connectedEdgeCount = 0;
        int minCost = 0;
        for(int[] connection : connections){

            int nodeA = connection[0];
            int nodeB = connection[1];
            int cost = connection[2];

            int parentA = unionFind.find(nodeA);
            int parentB = unionFind.find(nodeB);

            if(parentA != parentB){

                unionFind.union(nodeA, nodeB);
                connectedEdgeCount++;
                minCost += cost;
            }

        }

        return connectedEdgeCount == n - 1 ? minCost : -1;
    }

    private static class UnionFind {

        int[] root;
        int[] size;

        public UnionFind(int n){
            root = new int[n];
            size = new int[n];

            for(int i = 0; i < n ; i++){
                root[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            if(x == root[x]){
                return x;
            }
            return root[x] = find(root[x]);
        }

        private void union(int x, int y){

            int rootX = find(x);
            int rootY = find(y);

            // x and y are already connected
            // they are in same component, No need to connect
            if(rootX == rootY){
                return ;
            }

            if(size[rootX] > size[rootY]){
                root[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            else{ // Dont need else if as this will cover both  < and == . In both cases we are making rootY as parent
                root[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }
    }

    public static void main(String[] args) {
        ConnectingCitiesWithMinimumCost connectingCitiesWithMinimumCost = new ConnectingCitiesWithMinimumCost();
        int n = 3;
        int[][] edges = new int[][]{
                {1,2,5} ,{1,3,6},{2,3,1}
        };
        //Output: 6
        //Explanation: Choosing any 2 edges will connect all cities so we choose the minimum 2.
        System.out.println(connectingCitiesWithMinimumCost.minimumCost(n,edges));

        n = 4;
        edges = new int[][]{
                {1,2,3} ,{3,4,4}
        };
        //Output: -1
        //Explanation: There is no way to connect all cities even if all edges are used.
        System.out.println(connectingCitiesWithMinimumCost.minimumCost(n,edges));
    }
}
