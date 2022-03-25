package org.atanu.java.ds.graph;

//https://leetcode.com/problems/satisfiability-of-equality-equations/
//LeetCode 990
//Code is self explanatory
// Can refer : https://www.youtube.com/watch?v=uvSXZWtlwTo&t=505s
public class SatisfiabilityOfEqualityEquations {

    public boolean equationsPossible(String[] equations) {

        UnionFind unionFind = new UnionFind(26);

        //Union the operand if they are part of equal equation .
        // Now all the operand associated with "=" belongs to same state
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int operand1 = equation.charAt(0) - 'a';
                int operand2 = equation.charAt(3) - 'a';
                unionFind.union(operand1, operand2);
            }
        }

        // Now if two operand is assicated with "!" but also associate with "="
        //then its not stable equation. Return false.
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int operand1 = equation.charAt(0) - 'a';
                int operand2 = equation.charAt(3) - 'a';
                int rootPperand1 = unionFind.find(operand1);
                int rootPperand2 = unionFind.find(operand2);

                if (rootPperand1 == rootPperand2) {
                    return false;
                }
            }
        }

        return true; // once it comes here means the equation is stable
    }

    static class UnionFind {
        int[] root;
        int[] rank;// Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = i; // The initial "rank" of each vertex is 1, because each of them is
                // a standalone vertex with no connection to other vertices.
            }
        }

        public int find(int x) {
            if (root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]); // path compression
        }

        public void union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            // Always attach a smaller depth tree under the root of the deeper tree.
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }
    }
}
