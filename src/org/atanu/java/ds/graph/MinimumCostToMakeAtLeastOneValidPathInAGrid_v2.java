package org.atanu.java.ds.graph;

import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/
// Leetcode 1368

// Its a BFS Implementation
// While visiting the neighbours record the cost.
// If going in same direction then cost is zero otherwiese increment the cost
// Everytime record the cost in a PriorotyQueue in stead of a Queue.
// This will give us the minimum cost.
public class MinimumCostToMakeAtLeastOneValidPathInAGrid_v2 {

    public int minCost(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        boolean[][] traversed = new boolean[m][n];
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b)->(a.cost - b.cost));
        pq.add(new Tuple(0, 0, 0));

        while(!pq.isEmpty()) {
            Tuple top = pq.poll();
            int row = top.row, col = top.col;
            traversed[row][col] = true;
            if(row == m - 1 && col == n - 1) {
                return top.cost;
            }
            // traverse neighbors
            if(col + 1 != n && !traversed[row][col+1]) {
                pq.add(new Tuple(row, col+1, (grid[row][col] == 1 ? 0 : 1) + top.cost ));
            }
            if(col - 1 != -1 && !traversed[row][col-1]) {
                pq.add(new Tuple(row, col-1, (grid[row][col] == 2 ? 0 : 1) + top.cost ));
            }
            if(row + 1 != m && !traversed[row+1][col]) {
                pq.add(new Tuple(row+1, col, (grid[row][col] == 3 ? 0 : 1) + top.cost ));
            }
            if(row - 1 != -1 && !traversed[row-1][col]) {
                pq.add(new Tuple(row-1, col, (grid[row][col] == 4 ? 0 : 1) + top.cost ));
            }
        }
        return 0;
    }


    class Tuple {
        int row, col, cost;
        public Tuple(int r, int c, int co) {
            row = r;
            col = c;
            cost = co;
        }
    }
}
