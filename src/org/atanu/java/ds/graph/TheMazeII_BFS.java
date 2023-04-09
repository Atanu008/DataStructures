package org.atanu.java.ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/the-maze-ii/description/
//Leetcode 505

// We start from the current position (k,l), try to traverse in a particular direction, obtain the corresponding distance for that direction,
// reaching an end position of (i,j) just near the boundary or a wall.
// If the position (i,j) can be reached in a lesser number of steps from the current route than any other previous route checked,
// indicated by distance[k][l] + count < distance[i][j], we need to update distance[i][j] as distance[k][l] + count.

public class TheMazeII_BFS {
    int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        int m = maze.length, n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1],0});

        int[][] distance = new int[m][n];
        // Initialize the distance array
        for(int[] row : distance){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int[] dir : dirs){

                int currentX = current[0];
                int currentY = current[1];
                int currentDistance = current[2];
                // keep going until we hit a wall
                while(currentX >= 0 && currentX < m && currentY >= 0 && currentY < n && maze[currentX][currentY] == 0){
                    currentX += dir[0];
                    currentY += dir[1];
                    currentDistance++;
                }
                // Roll Back - When the program break from while loop above,
                // it meas that x, y has been added dir[0], dir[1] one more time.
                // so we should minus dir[0] and dir[1] here.
                currentX -= dir[0];
                currentY -= dir[1];
                currentDistance--;
                // This is the CRUX of this problem
                // distance[currentX][currentY] if currentDistance is less that previous recorded one(Explained below)
                // If the position (currentX,currentY) can be reached in a lesser number of steps
                // from the current route than any other previous route checked,
                // Update the distance .
                // distance[i][j] will store the shortest distance of (i,j) from starting point
                if(currentDistance < distance[currentX][currentY]){
                    distance[currentX][currentY] = currentDistance;
                    queue.offer(new int[]{currentX, currentY, currentDistance});
                }
            }
        }

        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ?
                -1 : distance[destination[0]][destination[1]];
    }
}
