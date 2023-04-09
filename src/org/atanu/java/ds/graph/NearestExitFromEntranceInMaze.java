package org.atanu.java.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/
//Leetcode 1926
public class NearestExitFromEntranceInMaze {

    //The idea is to perform simple breadth first search using a queue. While adding new elements, we perform a simple operation to check if the element being offered exists in first or last row OR first or last column.
    int[][] dirs = {{0,1}, {-1, 0}, {0,-1}, {1, 0}};
    public int nearestExit(char[][] maze, int[] entrance) {

        if(maze == null || maze.length == 0){
            return -1;
        }

        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        visited[entrance[0]][entrance[1]] = true;

        int step = 0;
        while(!queue.isEmpty()){

            step++;
            int size = queue.size();
            while(size --> 0){

                int[] current = queue.poll();
                int curRow = current[0];
                int curColumn = current[1];


                for(int[] dir : dirs){
                    int nextRow = curRow + dir[0];
                    int nextColumn = curColumn + dir[1];

                    //a invalid move
                    if(nextRow < 0 || nextColumn < 0 ||  nextRow >= m ||  nextColumn >= n || maze[nextRow][nextColumn]=='+' || visited[nextRow][nextColumn]){
                        continue;
                    }

                    //We are doing here as there is once corner case where we can exit from the entry point itself . otherwise we could have do it just after popping
                    //if we have reached the exit then current moves are the min moves to reach the exit
                    if(nextRow == 0 || nextColumn == 0 || nextRow == m-1 || nextColumn == n-1){
                        return step;
                    }


                    queue.offer(new int[]{nextRow, nextColumn});
                    visited[nextRow][nextColumn] = true;

                }
            }


        }

        return -1;
    }
}
