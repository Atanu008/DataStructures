package org.atanu.java.ds.graph;

import java.util.Arrays;

//https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
//LeetCode 1101
public class TheEarliestMomentWhenEveryoneBecomeFriends {

    //sort logs array by timestamp
    //union: when two people know each other
    //when there is only one parent (one single connected component), return the timestamp as the final result.
    public int earliestAcq(int[][] logs, int n) {

        // In order to ensure that we find the _earliest_ moment,
        // first of all we need to sort the events in chronological order.
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        int connectedComponetCount = n;
        UnionFind unionFind = new UnionFind(n);

        for(int[] log: logs){
            int time = log[0];
            int friendA = log[1];
            int friendB = log[2];

            if(unionFind.union(friendA, friendB)){
                connectedComponetCount--;
            }
            // The moment when all individuals are connected to each other.
            if(connectedComponetCount == 1){
                return time;
            }
        }

        return -1;
    }

    static class UnionFind {
        private int[] root;
        private int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; i++){
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if(root[x] == x) {
                return x;
            }

            return root[x] = find(root[x]);
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            //No Union Needed Return false
            if(rootX == rootY) {
                return false;
            }

            if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            }
            else if(rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            }
            else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }

            return true;
        }
    }
}
