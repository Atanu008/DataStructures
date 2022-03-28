package org.atanu.java.ds.graph;

import java.util.Arrays;

//https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
//LeetCode 1579
public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {

    //Intuition
    //Add Type3 first, then check Type 1 and Type 2.
    //
    //
    //Explanation
    //Go through all edges of type 3 (Alice and Bob)
    //If not necessary to add, increment res.
    //Otherwith increment e1 and e2.
    //
    //Go through all edges of type 1 (Alice)
    //If not necessary to add, increment res.
    //Otherwith increment e1.
    //
    //Go through all edges of type 2 (Bob)
    //If not necessary to add, increment res.
    //Otherwith increment e2.
    //
    //If Alice's'graph is connected, e1 == n - 1 should valid.
    //If Bob's graph is connected, e2 == n - 1 should valid.
    //In this case we return res,
    //otherwise return -1.
    //
    //
    //Complexity
    //Time O(E), if union find with compression and rank
    //Space O(E)
    public int maxNumEdgesToRemove(int n, int[][] edges) {

        UnionFind unionFindAlice = new UnionFind(n+1);
        UnionFind unionFindBob = new UnionFind(n+1);

        Arrays.sort(edges, (a, b) -> b[0] - a[0]); // This Imp. will greedily check for Type 3 first

        int canRemoveEdge = 0;
        int aliceEdge = 0;
        int bobEdge = 0;

        for(int[] edge : edges) {

            int EdgeType = edge[0];
            int vertexA = edge[1];
            int vertexB = edge[2];

            if(EdgeType == 3) {

                boolean uniteAliceGraph = unionFindAlice.union(vertexA, vertexB);
                boolean uniteBobGraph = unionFindBob.union(vertexA, vertexB);

                if(uniteAliceGraph){
                    aliceEdge++;
                }
                if(uniteBobGraph){
                    bobEdge++;
                }

                // edges already connected by Alice and Bob individually .
                // we can Remove the edge
                if(!uniteAliceGraph && !uniteAliceGraph) {
                    canRemoveEdge++;
                }
            }

            else if(EdgeType == 1) {
                boolean uniteAliceGraph = unionFindAlice.union(vertexA, vertexB);
                if(uniteAliceGraph){
                    aliceEdge++;
                }
                else{
                    canRemoveEdge++;// edges already connected by Alice and can be removed
                }
            }
            else {
                boolean uniteBobGraph = unionFindBob.union(vertexA, vertexB);
                if(uniteBobGraph){
                    bobEdge++;
                }
                else{
                    canRemoveEdge++; // edges already connected by Bob and can be removed
                }
            }
        }

        //It takes minimum  (N -1) to connect a graph with N node . MST concept
        return aliceEdge == n -1 && bobEdge == n -1 ? canRemoveEdge : -1;

    }

    static class UnionFind {

        int[] root;
        int[] rank;

        public UnionFind(int size) {

            root = new int[size];
            rank = new int[size];

            for(int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {

            if(root[x] == x){
                return x;
            }

            return root[x] = find(root[x]);
        }

        public boolean union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            if(rootX != rootY) {

                if(rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                }
                else if(rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                }
                else{

                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                return true; // Now connected
            }

            //They are already connected
            return false;
        }
    }
}
