package org.atanu.java.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
//Leetcode 1091
public class ShortestPathInBinaryMatrix {

    int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        //Base Case. Invalid Start Or End
        if(grid[0][0]==1 || grid[m-1][n-1]==1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        int level = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!queue.isEmpty()){

            int size = queue.size();

            while(size -->0){

                int[] currentCoordinate = queue.poll();
                int row = currentCoordinate[0];
                int column = currentCoordinate[1];

                if(row == m-1 && column == n-1){
                    return level + 1;
                }

                for(int[] dir : dirs){
                    int newRow = row + dir[0];
                    int newColumn = column + dir[1];

                    if(newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n && grid[newRow][newColumn] == 0 && !visited[newRow][newColumn]){
                        queue.offer(new int[]{newRow, newColumn});
                        visited[newRow][newColumn] = true;
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
