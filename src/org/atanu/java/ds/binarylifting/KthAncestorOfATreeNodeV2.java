package org.atanu.java.ds.binarylifting;

public class KthAncestorOfATreeNodeV2 {

    public static void main(String[] args) {
        KthAncestorOfATreeNodeV3.TreeAncestor treeAncestor = new KthAncestorOfATreeNodeV3.TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));
    }
    private class TreeAncestor {

        int up[][]; // This is basically the parse/up table we will build while traverssiing the array
        int LOG;

        public TreeAncestor(int n, int[] parent) {
            //max height of the tree
            LOG = (int)(Math.log(n)/Math.log(2)) + 1;
            // For ith Node it will store 2^j parent - j From 0 To LOG
            up = new int[n][LOG];

            //This is where we are for every nodes its 1st ancestor first i.e parent first
            //So even if the child having greater parent no issues
            for(int j = 0; j < LOG; j++){

                for(int v = 0; v < n; v++){
                    if(j == 0){
                        up[v][j] = parent[v];
                    }
                    else{
                        if(up[v][j-1] != -1){
                            up[v][j] = up[up[v][j-1]][j-1];
                        }
                        else{
                            up[v][j] = -1;
                        }
                    }
                }
            }

        }

        public int getKthAncestor(int node, int k) {

            //Try from MAX height , if the max bit is set then jump there
            //suppose k = 9 i.e   1001 - 4th bit and 0th bit is set
            // In that case we would first jump to 2^4 th ancestor and there 2^0 ancester i.e immediate parent
            // So we need to find left most set bit
            for(int mask = LOG - 1; mask >= 0; mask--){
                if((k & (1 << mask)) != 0){
                    node = up[node][mask];
                    if(node == -1){
                        return -1;
                    }
                }
            }
            return node;
        }
    }
}
