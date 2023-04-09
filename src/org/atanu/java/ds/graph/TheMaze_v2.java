package org.atanu.java.ds.graph;

//https://leetcode.com/problems/the-maze/description/
//Leetcode 490

// In order to implement this, we make use of a queue.
// We start with the ball at the start position.
// For every current position, we add all the new positions possible by traversing
// in all the four directions(till reaching the wall or boundary) into
// the queue to act as the new start positions and mark these positions as True in the visited array.
// When all the directions have been covered up, we remove a position value, position,
// from the front of the queue and again continue the same process with s acting as the new start position.

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze_v2 {

    int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int startX = start[0];
        int startY = start[1];
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        // Extreme Base Condition. When start and destination are same
        if(startX == destination[0] && startY == destination[1]){
            return true;
        }

        while(!queue.isEmpty()){

            int[] current = queue.poll();

            // Go all four directions
            for(int[] dir : dirs){
                int currentX = current[0];
                int currentY = current[1];
                // keep going until we hit a wall
                while(currentX >= 0 && currentX < m && currentY >= 0 && currentY < n && maze[currentX][currentY] == 0){
                    currentX += dir[0];
                    currentY += dir[1];
                }
                // Roll Back - When the program break from while loop above,
                // it meas that x, y has been added dir[0], dir[1] one more time.
                // so we should minus dir[0] and dir[1] here.
                currentX -= dir[0];
                currentY -= dir[1];

                // Its kinda some performance improvement from the previous one
                // Here before recording the position if we see the position is the target then
                // we do early exit. No need to wait for the popping up from queue and check
                if(currentX == destination[0] && currentY == destination[1]){
                    return true;
                }

                if(!visited[currentX][currentY]){
                    queue.offer(new int[]{currentX, currentY});
                    visited[currentX][currentY] = true;
                }
            }

        }
        return false;
    }
}
