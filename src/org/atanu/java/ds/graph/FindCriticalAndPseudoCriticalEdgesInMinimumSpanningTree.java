package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/description/
// Leetcode 1489
public class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        int row = edges.length;
        int col = edges[0].length;
        int[][] edgesWithOriginalIndexes = new int[row][col + 1];
        List<Integer> criticals = new ArrayList<>();
        List<Integer> pseduos = new ArrayList<>();

        for(int i = 0; i < row; i++){
            edgesWithOriginalIndexes[i][0] = edges[i][0];
            edgesWithOriginalIndexes[i][1] = edges[i][1];
            edgesWithOriginalIndexes[i][2] = edges[i][2];
            edgesWithOriginalIndexes[i][3] = i;
        }

        Arrays.sort(edgesWithOriginalIndexes, (a, b) -> a[2] - b[2]);
        // get original MST cost
        int minCost = buildMST(n, edgesWithOriginalIndexes, null, null);
        //System.out.println("Min Cost "+ minCost);

        for(int[] edge : edgesWithOriginalIndexes){
            int index = edge[3];
            // get MST cost by excluding ith edge
            int costWithout = buildMST(n, edgesWithOriginalIndexes, null, edge);
            //System.out.println("costWithout "+ costWithout);
            // if excluding the edge increase MST cost, that means that edge is the critical edge
            if(costWithout > minCost){
                criticals.add(index);
            } else{
                // get MST cost by including ith edge
                int costWith = buildMST(n, edgesWithOriginalIndexes, edge, null);
                //System.out.println("costWith "+ costWith);
                // in case there is no change in MST cost after including the edge
                // that means it is a pseudo-critical edge i.e. if we remove it, there as alternate path
                // with same weight which can lead to MST cost
                if(costWith == minCost){
                    pseduos.add(index);
                }
            }
        }
        return Arrays.asList(criticals, pseduos);
    }

    private int buildMST(int n, int[][] edges, int[] pick, int[] skip){
        UnionFind unionFind = new UnionFind(n);
        int cost = 0;
        if(pick != null){
            unionFind.union(pick[0], pick[1]);
            cost += pick[2];
        }

        for(int[] edge : edges){
            if(edge == skip){
                continue;
            }
            int nodeA = edge[0];
            int nodeB = edge[1];
            int weight = edge[2];
            int rootNodeA = unionFind.find(nodeA);
            int rootNodeB = unionFind.find(nodeB);

            if(rootNodeA != rootNodeB){
                unionFind.union(nodeA, nodeB);
                cost += weight;
            }
        }

        // This is important , if suppose all nodes are not connected via Kruskal if we remove some edge, because that edge might be bridge
        // In that case we might get wrong cost, a cost which is not minimum spanning tree vale
        // In those cases where spanning tree is not possible( number of component != 1)
        // Return Integer.MAX_VALUE , it will indicate for that edge removal no spanning tre pissible
        return unionFind.getNumberOfComponent() == 1? cost : Integer.MAX_VALUE;
    }

    private static class UnionFind {
        int[] root;
        int[] size;

        public UnionFind(int n){
            root = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++){
                root[i] = i;
                size[i] = 1; // The initial "size" of each vertex is 1, because each of them is having one size initially
            }
        }

        public int find(int x){

            if(root[x] == x){
                return x;
            }
            return root[x] = find(root[x]); // path compression
        }

        public void union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            if(size[rootX] > size[rootY]){
                root[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            else{ // Dont need else if as this will cover both  < and == . In both cases we are making rootY as parent
                root[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }

        public int getNumberOfComponent() {
            int count = 0;
            for (int i = 0; i < root.length; i++) {
                if (root[i] == i) { //If the same element is root i.e it belengs to its same set , if its diffeent that means this element have differner root
                    count++;
                }
            }

            return count;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}
        };
        System.out.println(new FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree()
                .findCriticalAndPseudoCriticalEdges(5,edges));
    }
}
