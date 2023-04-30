package org.atanu.java.ds.graph;

// https://leetcode.com/problems/find-all-groups-of-farmland/description/
// Leetcode 1992

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindAllGroupsOfFarmland {
    public int[][] findFarmland(int[][] land) {

        int m = land.length;
        int n = land[0].length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 1){
                    // For each staring of land do BFS and record the star and end point
                    bfs(land, i, j, list);
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    private void bfs(int[][] land, int i, int j, List<int[]> list){

        int m = land.length;
        int n = land[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int r2 = -1;
        int c2 = -1;
        // We only need to go forward(right and down)
        // dont need the other directions
        int[][] dirs = {{0, 1}, {1, 0}};

        land[i][j] = 0; // mark it no land
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            r2 = current[0];
            c2 = current[1];
            for(int[] dir : dirs){

                int nextRow = r2 + dir[0];
                int nextCol = c2 + dir[1];

                if(nextRow < m && nextCol < n && land[nextRow][nextCol] == 1){
                    land[nextRow][nextCol] = 0; // Mark it not land
                    queue.offer(new int[]{nextRow, nextCol});
                }

            }
        }

        list.add(new int[]{i, j, r2, c2});
    }
}
