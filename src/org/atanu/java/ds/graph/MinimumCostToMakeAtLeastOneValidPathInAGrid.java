package org.atanu.java.ds.graph;

// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/
// Leetcode 1368

import java.util.Arrays;
import java.util.PriorityQueue;

// Dijkstra Solution :
// For each Node go to all four direction and record the cost if any
// Return the minimum cost when reached last node
// i.e shortest path from first to last Node
public class MinimumCostToMakeAtLeastOneValidPathInAGrid {

    // This definition is alo Important
    // 0th Index  -> going right
    // 1st Index  -> going left
    // 2nd Index  -> going down(lower)
    // 3rd Index  -> going UP

    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int minCost(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.offer(new int[]{0, 0, 0});
        int[][] costs = new int[m][n];
        for(int[] arr : costs){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        costs[0][0] = 0;

        while(!minHeap.isEmpty()){

            int[] current = minHeap.poll();
            int row = current[0];
            int col = current[1];
            int cost = current[2];

            if(row == m - 1 && col == n - 1){
                return cost;
            }
            // We may not need this , as we will always be popping non visited nodes
            if(visited[row][col]){
                continue;
            }

            // Mark this node visited
            visited[row][col] = true;

            //System.out.println("row : "+ row + "  col :  "+ col +" newCost : "+cost);
            for(int i = 0; i < 4; i++){
                int[] dir = dirs[i];
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n){
                    // Here comes the trick
                    // If the direction of the current cell (grid[row][col]) os having the same direction as the current move
                    // i.e grid[row][col] == i + 1 (i + 1 because dirs array is zero based,  0 represent going right)
                    // Then we don't need to associate any cost
                    // When the cell and direction dont match then increment the cost
                    // i.e cost + (grid[row][col] == i + 1 ? 0 : 1);
                    int newCost = cost + (grid[row][col] == i + 1 ? 0 : 1);
                    // System.out.println("newRow : "+ newRow + "  newCol :  "+ newCol +" newCost : "+newCost);
                    if(!visited[newRow][newCol] && newCost < costs[newRow][newCol]){
                        costs[newRow][newCol] = newCost;
                        minHeap.offer(new int[]{newRow, newCol, newCost});
                    }
                }
            }

        }
        return -1;
    }
}
