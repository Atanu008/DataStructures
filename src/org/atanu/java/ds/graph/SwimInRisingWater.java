package org.atanu.java.ds.graph;

import java.util.PriorityQueue;

// https://leetcode.com/problems/swim-in-rising-water/description/
// Leetco 778
// Intuition Video : https://www.youtube.com/watch?v=Wq1NibUMrNU

// Modified Dojkstra
// This problem is to find shortest path,
// the only thing we need to pay attention to is the weight of edge from grid[0][0] to grid[n-1][n-1].
// For each Path take the maximum value .
// We will consider the path which has minimum values among those maximums
public class SwimInRisingWater {

    int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public int swimInWater(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        int[] start = {0, 0, grid[0][0]};
        minHeap.offer(start);
        visited[0][0] = true;

        while(!minHeap.isEmpty()){

            int[] current = minHeap.poll();
            int x = current[0];
            int y = current[1];
            int maxTillCurrent = current[2];

            if(x == m - 1 && y == n - 1){
                return maxTillCurrent;
            }
            for(int[] dir : dirs){

                int nextRow = x + dir[0];
                int nextCol = y + dir[1];

                if(nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol]) {
                    int maxTillNext = Math.max(maxTillCurrent, grid[nextRow][nextCol]);
                    minHeap.offer(new int[]{nextRow, nextCol, maxTillNext});
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        int result = swimInRisingWater.swimInWater(grid);

        System.out.println(result);
    }
}
