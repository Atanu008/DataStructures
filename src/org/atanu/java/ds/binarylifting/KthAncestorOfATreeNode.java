package org.atanu.java.ds.binarylifting;

//Resources Binary Lifting
//Udemy :
//https://www.udemy.com/course/graph-theory-algorithms-for-competitive-programming/learn/lecture/27085922#announcements
//https://github.com/coding-minutes/graph-algorithms-for-competitive-coding/blob/master/Graphs%20Java/src/LCA/sparseTable.java

// Erichhto
//https://www.youtube.com/watch?v=oib-XsjFa-M

//https://www.youtube.com/watch?v=FAfSArGC8KY

public class KthAncestorOfATreeNode {

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

            //Initialize the immediate parent of node
            //If we dont do that and if a node have parent hige than its
            //Like 3's parent is 5 and in the next loop we are iterating from 0-N nodes
            // so when 3 comes it will look for 5 is ancestors , but we dont have 5th nodes data yet
            // and the program will fail , so initailize parent first
            // Another solution is reversing the order of next for loops , essentially same thing
            for(int v = 0; v < n; v++){
                up[v][0] = parent[v];  // it means that V's 2^0 ancester i.e Firest ancester is parent itself
            }

            for(int v = 0; v < n; v++){
                //Now we need to build for other ancesters
                for(int j = 1; j < LOG; j++){
                    if(up[v][j-1] != -1){
                        up[v][j] = up[up[v][j-1]][j-1];
                    }
                    else{
                        up[v][j] = -1;
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
