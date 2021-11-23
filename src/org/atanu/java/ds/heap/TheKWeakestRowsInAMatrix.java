package org.atanu.java.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
//LeetCode 1337
public class TheKWeakestRowsInAMatrix {

    //Using Min Heap
    public int[] kWeakestRows(int[][] matrix, int k) {

        int row = matrix.length;
        int column = matrix[0].length;
        // Create a Priority Queue that measures firstly on strength and then indexes.
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.soldier != b.soldier) return a.soldier - b.soldier;
            else return a.row - b.row;
        });

        for (int i = 0; i < row; i++) {
            int j = 0;
            for (; j < column; j++) {
                if (matrix[i][j] == 0) {
                    break;
                }
            }
            int soldier = j + 1;
            pq.offer(new Node(soldier, i));
        }

        int[] weakest = new int[k];
        for (int i = 0; i < k; i++) {
            Node weakestRow = pq.poll();
            weakest[i] = weakestRow.row;
        }

        return weakest;
    }

    //Using Max Heap
    public int[] kWeakestRowsV2(int[][] matrix, int k) {
        int row = matrix.length;
        int column = matrix[0].length;
        // Create a Priority Queue that measures firstly on strength and then indexes.
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.soldier != b.soldier) return b.soldier - a.soldier;
            else return b.row - a.row;
        });

        // Add strength/index pairs to the pq. Whenever length > k, remove the largest.
        for (int i = 0; i < row; i++) {
            int j = 0;
            for (; j < column; j++) {
                if (matrix[i][j] == 0) {
                    break;
                }
            }
            int soldier = j + 1;
            pq.offer(new Node(soldier, i));
            if(pq.size() > k){
                pq.poll();
            }
        }

        // Pull the indexes out of the priority queue.
        int[] weakest = new int[k];
        for (int i = k-1; i >=0; i--) {
            Node weakestRow = pq.poll();
            weakest[i] = weakestRow.row;
        }

        return weakest;
    }

    static class Node {
        int soldier;
        int row;

        public Node(int soldier, int row) {
            this.soldier = soldier;
            this.row = row;
        }
    }

    public static void main(String[] args) {
        TheKWeakestRowsInAMatrix theKWeakestRowsInAMatrix = new TheKWeakestRowsInAMatrix();
        int[][] mat =
                        {{1,1,0,0,0},
                        {1,1,1,1,0},
                        {1,0,0,0,0},
                        {1,1,0,0,0},
                        {1,1,1,1,1}};
        int k = 3;
        //Output: [2,0,3]
        //Explanation:
        //The number of soldiers in each row is:
        //- Row 0: 2
        //- Row 1: 4
        //- Row 2: 1
        //- Row 3: 2
        //- Row 4: 5
        //The rows ordered from weakest to strongest are [2,0,3,1,4].

        int[] weakestRows = theKWeakestRowsInAMatrix.kWeakestRows(mat,k);
        System.out.println(k+" weakest rows in the matrix ordered from weakest to strongest. \n"+ Arrays.toString(weakestRows));
    }
}
