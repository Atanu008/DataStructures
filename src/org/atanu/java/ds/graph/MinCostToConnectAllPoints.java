package org.atanu.java.ds.graph;

// https://leetcode.com/problems/min-cost-to-connect-all-points/description/
// Leetcode 1584

// We can imagine that every point is a node of the graph, connected to all other points,
// and the lenght of the edge is the manhattan distance between two points.

// To find the min cost, we therefore need to find the minimum spanning tree.

import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {

        if(points == null || points.length == 0){
            return -1;
        }

        int n = points.length;
        // We could sort the points also
        // Sort all edges in increasing order.
        // Collections.sort(allEdges, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                int[] pointX = points[i];
                int[] pointY = points[j];

                int distance = Math.abs(pointX[0] - pointY[0]) + Math.abs(pointX[1] - pointY[1]);
                minHeap.offer(new int[]{i, j, distance});
            }
        }

        UnionFind unionFind = new UnionFind(n);
        int edgeCount = 0;
        int minCost = 0;

        while(!minHeap.isEmpty() && edgeCount < n - 1){

            int[] current = minHeap.poll();
            int nodeA = current[0];
            int nodeB = current[1];
            int cost = current[2];
            int parentA = unionFind.find(nodeA);
            int parentB = unionFind.find(nodeB);

            if(parentA != parentB){
                unionFind.union(nodeA, nodeB);
                minCost += cost;
                edgeCount++;
            }
        }

        return minCost;
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
        MinCostToConnectAllPoints minCostToConnectAllPoints = new MinCostToConnectAllPoints();
        int[][] points = new int[][]{
                {0,0},{2,2},{3,10},{5,2},{7,0}
        };
        System.out.println(minCostToConnectAllPoints.minCostConnectPoints(points));
    }
}
