package org.atanu.java.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/as-far-from-land-as-possible/
//LeetCode 1162
public class AsFarFromLandAsPossible {

    int[][] dirs = {{1, 0}, {0, 1}, {-1 , 0}, {0, -1}};
    public int maxDistance(int[][] grid) {

        int row = grid.length;
        int column = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][column];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++) {
                if(grid[i][j] == 1){

                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        //Edge case . All land(all 1) . No water
        // Or No land . only water
        if(queue.size() == row * column || queue.size() == 0) {
            return -1;
        }

        int distance = 0;
        while(!queue.isEmpty()){


            int size = queue.size();
            //System.out.println("Size "+ size);
            while(size --> 0){
                int[] coordinate = queue.poll();
                int currentRow = coordinate[0];
                int currentColumn = coordinate[1];


                for(int[] dir : dirs){
                    int newRow = currentRow + dir[0];
                    int newColumn = currentColumn + dir[1];

                    if(newRow < 0 || newRow >= row || newColumn < 0 || newColumn >= column
                            || visited[newRow][newColumn] || grid[newRow][newColumn] == 1) {
                        continue;
                    }

                    queue.offer(new int[]{newRow, newColumn});
                    visited[newRow][newColumn] = true;
                }
            }

            distance++;
        }

        return distance - 1; //BFS would do one more useless loop in here, so need distance-1
    }
}
