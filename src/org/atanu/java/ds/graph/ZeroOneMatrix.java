package org.atanu.java.ds.graph;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/01-matrix/
//LeetCode 542
public class ZeroOneMatrix {

    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[][] updateMatrix(int[][] mat) {

        int row = mat.length;
        int column = mat[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;//Marking Non Visited
                }
            }
        }

        while(!queue.isEmpty()){


            int size = queue.size();
            while(size --> 0){
                int[] current = queue.poll();
                int currentRow = current[0];
                int currentColumn = current[1];

                for(int[] dir : dirs){
                    int newRow = currentRow + dir[0];
                    int newColumn = currentColumn + dir[1];

                    if(newRow >= 0 && newRow < row && newColumn >= 0 && newColumn < column && mat[newRow][newColumn] == -1){
                        mat[newRow][newColumn] = mat[currentRow][currentColumn] + 1;
                        queue.offer(new int[]{newRow,newColumn});
                    }
                }
            }
        }

        return mat;
    }

   // Same solution as above just using visited array and level .
    public int[][] updateMatrixV2(int[][] mat) {

        int row = mat.length;
        int column = mat[0].length;

        boolean[][] visited = new boolean[row][column];
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++; //each layer of BFS
            while(size --> 0){
                int[] current = queue.poll();
                int currentRow = current[0];
                int currentColumn = current[1];

                for(int[] dir : dirs){
                    int newRow = currentRow + dir[0];
                    int newColumn = currentColumn + dir[1];

                    if(newRow >= 0 && newRow < row && newColumn >= 0 && newColumn < column && !visited[newRow][newColumn]){
                        mat[newRow][newColumn] = level;
                        queue.offer(new int[]{newRow,newColumn});
                        visited[newRow][newColumn] = true;
                    }
                }
            }
        }

        return mat;
    }
}
