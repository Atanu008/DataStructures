package org.atanu.java.ds.binarylifting;


import java.util.ArrayList;
import java.util.List;

public class KthAncestorOfATreeNodeV3 {
    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));
    }

    static class TreeAncestor {

        //[] -  2^0 , 2^1 , 2^2, 2^3
        int up[][]; // This is basically the parse/up table we will build while traverssiing the array
        int LOG;
        List<List<Integer>> graph;

        public TreeAncestor(int n, int[] parent) {
            //max height of the tree
            LOG = (int) (Math.log(n) / Math.log(2)) + 1;
            // For ith Node it will store 2^j parent - j From 0 To LOG
            up = new int[n][LOG];
            graph = new ArrayList<>();

            //Build the Graph
            for (int v = 0; v < n; v++) {
                graph.add(new ArrayList<>());
            }

            for (int v = 0; v < n; v++) {
                if (parent[v] != -1) {
                    graph.get(parent[v]).add(v); //Parent to child adjacency List
                }
            }

            dfs(0, parent[0]); // DFS has to be from Top i.e root. upper nodes will have the parent info first

        }

        public int getKthAncestor(int node, int k) {

            //Try from MAX height , if the max bit is set then jump there
            //suppose k = 9 i.e   1001 - 4th bit and 0th bit is set
            // In that case we would first jump to 2^4 th ancestor and there 2^0 ancester i.e immediate parent
            // So we need to find left most set bit
            for (int mask = LOG - 1; mask >= 0; mask--) {
                if ((k & (1 << mask)) != 0) {
                    node = up[node][mask];
                    if (node == -1) {
                        return -1;
                    }
                }
            }
            return node;
        }

        private void dfs(int node, int parent) {
            up[node][0] = parent;

            for (int j = 1; j < LOG; j++) {
                //If the ancestor exist then go above
                //2^x -> 2^x-1 + 2^x-1
                if (up[node][j - 1] != -1) {
                    up[node][j] = up[up[node][j - 1]][j - 1];
                } else {
                    up[node][j] = -1; // ancestor does not exist
                }
            }
            //Recur for the child nodes
            for (int child : graph.get(node)) {
                if (child != parent) {
                    dfs(child, node);
                }
            }
        }
    }

}
