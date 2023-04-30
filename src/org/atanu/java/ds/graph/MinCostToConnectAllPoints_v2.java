package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/min-cost-to-connect-all-points/description/
// Leetcode 1584

// We can imagine that every point is a node of the graph, connected to all other points,
// and the lenght of the edge is the manhattan distance between two points.

// To find the min cost, we therefore need to find the minimum spanning tree.

public class MinCostToConnectAllPoints_v2 {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        ArrayList<int[]> allEdges = new ArrayList<>();

        // Storing all edges of our complete graph.
        for (int currNext = 0; currNext < n; ++currNext) {
            for (int nextNext = currNext + 1; nextNext < n; ++nextNext) {
                int weight = Math.abs(points[currNext][0] - points[nextNext][0]) +
                        Math.abs(points[currNext][1] - points[nextNext][1]);

                int[] currEdge = {weight, currNext, nextNext};
                allEdges.add(currEdge);
            }
        }

        // Sort all edges in increasing order.
        Collections.sort(allEdges, (a, b) -> Integer.compare(a[0], b[0]));

        UnionFind uf = new UnionFind(n);
        int mstCost = 0;
        int edgesUsed = 0;

        for (int i = 0; i < allEdges.size() && edgesUsed < n - 1; ++i) {
            int node1 = allEdges.get(i)[1];
            int node2 = allEdges.get(i)[2];
            int weight = allEdges.get(i)[0];

            if (!uf.union(node1, node2)) {
                mstCost += weight;
                edgesUsed++;
            }
        }

        return mstCost;
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

        private boolean union(int x, int y){

            int rootX = find(x);
            int rootY = find(y);

            // x and y are already connected
            // they are in same component, No need to connect
            if(rootX == rootY){
                return true;
            }

            if(size[rootX] > size[rootY]){
                root[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            else{ // Dont need else if as this will cover both  < and == . In both cases we are making rootY as parent
                root[rootX] = rootY;
                size[rootY] += size[rootX];
            }

            return false;
        }
    }

    public static void main(String[] args) {
        MinCostToConnectAllPoints_v2 minCostToConnectAllPoints =  new MinCostToConnectAllPoints_v2();
        int[][] points = new int[][]{
                {0,0},{2,2},{3,10},{5,2},{7,0}
        };
        System.out.println(minCostToConnectAllPoints.minCostConnectPoints(points));
    }
}
