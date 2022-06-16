package org.atanu.java.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/map-of-highest-peak/
//LeetCode 1765
//Video : https://www.youtube.com/watch?v=sm1SAp_lj80
public class MapOfHighestPeak {

    //Since the height of all waters is 0, we start from waters with a height of 0;
    //The difference of all adjacent cells heights is at most 1, according to the rule of the problem;
    //Therefore, we can use BFS to assign heights to neighboring cells, each step increase height by 1.
    int[][] dirs = {{0,1}, {-1, 0}, {0, -1}, {1, 0}};
    public int[][] highestPeak(int[][] isWater) {

        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //its water .
                //mark the height as zero as If the cell is a water cell, its height must be 0
                if(isWater[i][j] == 1){
                    height[i][j] = 0; //Mark water
                    queue.offer(new int[]{i, j}); //Push water cell into queue
                }
                else{
                    height[i][j] = Integer.MAX_VALUE; //Mark Land
                }
            }
        }

        //Start BFS
        //Multi source BFS from water cells
        while(!queue.isEmpty()){

            int size = queue.size();
            while(size -->0){

                int[] current = queue.poll();
                int row = current[0];
                int column = current[1];
                for(int[] dir : dirs){
                    int currenrtRow = row + dir[0];
                    int currentColumn = column + dir[1];

                    if(currenrtRow >= 0 && currenrtRow < m && currentColumn >= 0 && currentColumn < n && height[currenrtRow][currentColumn] == Integer.MAX_VALUE){
                        height[currenrtRow][currentColumn] = height[row][column] + 1; //Raise level
                        queue.offer(new int[]{currenrtRow, currentColumn});
                    }
                }
            }
        }

        return height;
    }

    //Same as above . just with level
    public int[][] highestPeakV2(int[][] isWater) {

        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //its water .
                //mark the height as zero as If the cell is a water cell, its height must be 0
                if(isWater[i][j] == 1){
                    height[i][j] = 0; //Mark water
                    queue.offer(new int[]{i, j}); //Push water cell into queue
                }
                else{
                    height[i][j] = Integer.MAX_VALUE; //Mark Land
                }
            }
        }

        //Start BFS
        //Multi source BFS from water cells
        int level = 0;
        while(!queue.isEmpty()){

            level++;
            int size = queue.size();
            while(size -->0){

                int[] current = queue.poll();
                int row = current[0];
                int column = current[1];
                for(int[] dir : dirs){
                    int currenrtRow = row + dir[0];
                    int currentColumn = column + dir[1];

                    if(currenrtRow >= 0 && currenrtRow < m && currentColumn >= 0 && currentColumn < n && height[currenrtRow][currentColumn] == Integer.MAX_VALUE){
                        height[currenrtRow][currentColumn] = level; //Raise level
                        queue.offer(new int[]{currenrtRow, currentColumn});
                    }
                }
            }
        }

        return height;
    }
}
