package org.atanu.java.ds.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/the-maze-ii/description/
//Leetcode 505

// Dijkstra Like Solution
public class TheMazeII_Dijkstra {
    int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        // Min Heap Based On Distance . less distance will be picked first
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        int startX = start[0];
        int startY = start[1];
        minHeap.offer(new int[]{startX, startY, 0});

        int[][] distance = new int[m][n];
        // All nodes having impossible distance start
        for(int[] row : distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[startX][startY] = 0; // distance of start Node is always zero

        while(!minHeap.isEmpty()){
            // Take the edge with minimum Distance
            int[] current = minHeap.poll();
            // Return if the current node is the destination
            if(current[0] == destination[0] && current[1] == destination[1]){
                return current[2];
            }
            // Skip if already visited/explored/relaxed :)
            if(visited[current[0]][current[1]]){
                continue;
            }
            // If the vertex is not visited, mark it visited as
            visited[current[0]][current[1]] = true;

            // For each adjacent node of the vertex,
            // Relax the distance to the adjacent edge
            for(int[] dir : dirs){
                int currentX = current[0];
                int currentY = current[1];
                int step = current[2];
                // keep going until we hit a wall
                while(currentX >= 0 && currentX < m && currentY >= 0 && currentY < n && maze[currentX][currentY] == 0){
                    currentX += dir[0];
                    currentY += dir[1];
                    step++;
                }
                // Roll Back - When the program break from while loop above,
                // it meas that x, y has been added dir[0], dir[1] one more time.
                // so we should minus dir[0] and dir[1] here.
                currentX -= dir[0];
                currentY -= dir[1];
                step--;
                // If V i.e [currentX][currentY]  has not been visited,
                // update its distance if it is smaller than the current distance of V i.e distance[currentX][currentY].
                if(!visited[currentX][currentY] && step < distance[currentX][currentY]){
                    minHeap.offer(new int[]{currentX, currentY, step});
                    distance[currentX][currentY] = step;
                }
            }

        }

        return -1;
    }
}
