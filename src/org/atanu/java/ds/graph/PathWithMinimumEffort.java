package org.atanu.java.ds.graph;

// https://leetcode.com/problems/path-with-minimum-effort/description/
// Leetcode 1631

// If we observe, this problem is to find the shortest path from a source cell (0, 0) to a destination cell (m-1, n-1).
// Here, total path cost is defined as maximum absolute difference in heights between two consecutive cells of the path.

// Thus, we could use Dijikstra's algorithm which is used to find the shortest path in a weighted graph
// with a slight modification of criteria for the shortest path, which costs O(E log V),
// where E is number of edges E = 4*M*N, V is number of veritices V = M*N

// Why Dijkstra Works ?

// here, the total path cost is the maximum absolute difference, its a different kind of cost function compared to the vanilla adding all costs together along the path
// for Dijkstra, edge weight cannot be negative, but what does that really mean.
// It effectively means total path cost cannot go down when a new edge joins the path.
// In the vanilla Dijkstra, it's in the form of negative edge weight. If we translate that to this problem,
// we can see that the total path cost (maximum absolute difference) will never go down when a new edge joins the path

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        //Fill Distance arary
        int[][] distance = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        minHeap.offer(new int[]{0, 0, 0});
        distance[0][0] = 0;//Mark Initial starting distance as zero

        while(!minHeap.isEmpty()){

            int[] current = minHeap.poll();
            int row = current[0];
            int col = current[1];
            int dis = current[2];
            //Reached Target Node
            if(row == m - 1 && col == n - 1){
                return dis;
            }
            visited[row][col] = true;
            for(int[] dir : dirs){
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if(nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n){
                    // We Need to take the Max effort in the current path
                    // And need to put in the MinHeap
                    // As we need to take the minimum from all the Max efforts from all the paths
                    int newDis = Math.max(dis, Math.abs(heights[nextRow][nextCol] - heights[row][col]));
                    if(!visited[nextRow][nextCol] && newDis < distance[nextRow][nextCol]){
                        distance[nextRow][nextCol] = newDis;
                        minHeap.offer(new int[]{nextRow, nextCol, newDis});
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        PathWithMinimumEffort pathWithMinimumEffort = new PathWithMinimumEffort();
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        int effort = pathWithMinimumEffort.minimumEffortPath(heights);
        //Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
        //This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
        System.out.println(effort);
    }
}
