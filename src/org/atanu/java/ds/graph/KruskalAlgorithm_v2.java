package org.atanu.java.ds.graph;

import java.util.Arrays;

// Algorithm of Kruskal's:

// Sort all the edges of the graph in ascending order of their weights.
// Check the edge with minimum weight, if including it in the answer forms a cycle discard it,
// otherwise include it in the answer.
// Repeat the above step until we have chosen V−1 edges.

//Sudo Code :

//MST_Kruskal(Edges, V, E):
//    e=0, i=0
//    sum=0
//    Sort(Edges)
//    while(e<V-1):
//        u=Edges[i].u
//        v=Edges[i].v
//        if(Adding edge {u, v} do not form cycle):
//            Print(Adding edge {u, v} to MST)
//            sum+=Edges[i].weight
//            e+=1
//        i+=1

// Complexity Analysis
//--------
// Time Complexity -
// Sorting of E edges costs us O(E∗log(E)) time.
// For each edge, we are using the Union-Find algorithm which costs us O(E∗α(V)) time.
// As discussed in DSU, for practical values of i.e. V≤10^80
//
// we can write
// O(E∗α(V)) as O(E) because O(α(V)) ≃ O(1).
// Hence, the overall time complexity is O(E∗log(E)+E) ≃ O(E∗log(E))
// Space Complexity - We are using a List/Vector to store the
// E edges of the given graph so the space complexity is O(E).

public class KruskalAlgorithm_v2 {

    public static void main(String[] args) {

        KruskalAlgorithm_v2 kruskalAlgorithm = new KruskalAlgorithm_v2();

        int[][] edges = new int[][]{
                {0,1,7},{0,2,8},{1,2,3},{1,4,6},{2,3,3},{2,4,4},{3,4,2},{3,5,2},{4,5,2}
        };
        int n = 6;
        kruskalAlgorithm.minimumSpanningTree(edges, n);
    }

    public void minimumSpanningTree(int[][] edges, int n){

        int minCost = 0;

        // Sorting edges using minimum edge cost
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        UnionFind unionFind = new UnionFind(n);
        int edgeCount = 0;
        int edgeIndex = 0;

        while(edgeCount < n - 1){

            int[] edge = edges[edgeIndex++];
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            int parentU =unionFind.find(u);
            int parentV =unionFind.find(v);

            // If u and v does not form a cycle connect them , i.e they belong to different connected component
            // connect them
            if(parentU != parentV) {
                System.out.println("Adding edge "+ u +" <---> "+ v +" to MST");
                // Including the edge.
                unionFind.union(u, v);
                // Adding the weight of current edge to total
                // weight of the MST
                minCost += cost;
                // Increasing the edge count.
                edgeCount++;
            }
        }

        System.out.println("MST has a cost/weight of "+minCost);
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

            // x and y were in different component, now we have connected them to same component
            //
            return false;
        }

    }
}
