package org.atanu.java.ds.graph;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/shortest-bridge/
//LeetCode 934
//Video : https://www.youtube.com/watch?v=gkINMhbbIbU&list=PLot-Xpze53ldBT_7QA8NVot219jFNr_GI&index=29
public class ShortestBridge {

    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int shortestBridge(int[][] grid) {

        int row = grid.length;
        int column = grid[0].length;

        boolean[][] visited = new boolean[row][column];
        Queue<int[]> queue = new ArrayDeque<>();
        boolean found = false;
        //dfs to find an island, mark it in `visited`
        // We will pit all the coordinate oh that island in queuue To start BFS from them
        for(int i = 0; i < row; i++) {
            if(found){
                break;
            }
            for(int j = 0; j < column; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, visited, queue);
                    found = true;
                    break;
                }
            }
        }

        // bfs to expand this island
        return bfs(grid, visited, queue);
    }

    // BFS level order traversal: to count number of levels before finding the second island
    public int bfs(int[][] grid, boolean[][] visited, Queue<int[]> queue){

        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size --> 0) {
                int[] currentCoOrdinate = queue.poll();
                int currentRow = currentCoOrdinate[0];
                int currentColumn = currentCoOrdinate[1];

                for(int[] dir : dirs) {
                    int newRow = currentRow + dir[0];
                    int newColumn = currentColumn + dir[1];
                    if(newRow < 0 || newRow >= grid.length || newColumn < 0 || newColumn >= grid[0].length || visited[newRow][newColumn]) {

                        continue;
                    }

                    if(grid[newRow][newColumn] == 1){
                        return level;
                    }
                    visited[newRow][newColumn] = true;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }

            level++;
        }

        return -1;
    }

    public void dfs(int[][] grid, int row, int column, boolean[][] visited, Queue<int[]> queue){

        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || visited[row][column] || grid[row][column] == 0) {
            return;
        }

        visited[row][column] = true;
        queue.offer(new int[]{row, column});

        for(int[] dir : dirs) {
            int newRow = row + dir[0];
            int newColumn = column + dir[1];
            dfs(grid, newRow, newColumn, visited, queue);
        }

    }
}
