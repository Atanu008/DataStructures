package org.atanu.java.ds.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/pacific-atlantic-water-flow/
//LeetCode 417
public class PacificAtlanticWaterFlow {

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1 , 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int row = heights.length;
        int column = heights[0].length;

        boolean[][] pacificFlow = new boolean[row][column];
        boolean[][] atlanticFlow = new boolean[row][column];

        //Traverse from the Borders
        for(int i = 0; i < column; i++) {
            dfs(heights, pacificFlow, 0, i); //Top Row . Pacific Border
            dfs(heights, atlanticFlow,row -1, i); // Bottom Row Atlantic
        }

        for(int i = 0; i < row; i++) {
            dfs(heights, pacificFlow, i, 0); //Left Column . Pacific
            dfs(heights, atlanticFlow, i, column -1); //Right Column . Atlantic
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(pacificFlow[i][j] && atlanticFlow[i][j]) {
                    List<Integer> coordinate = new ArrayList<>();
                    coordinate.add(i);
                    coordinate.add(j);
                    result.add(coordinate);
                }
            }
        }
        //System.out.println(Arrays.deepToString(pacificFlow));
        //System.out.println(Arrays.deepToString(atlanticFlow));
        return result;
    }

    public void dfs(int[][] heights, boolean[][] visited, int row, int column){

        //Base Case
        //This is kida redundant as we are checking it inside loop
        //might be useful for first call
        if(row < 0 || row >= heights.length || column < 0 || column >= heights[0].length || visited[row][column]) {
            return;
        }

        visited[row][column] = true;

        for(int[] dir : dirs) {
            int newRow = row + dir[0];
            int newColumn = column + dir[1];

            //heights[newRow][newColumn] < heights[row][column] condition is Imp
            //We are traversing inside the matrix from shore. All the border elements will be flown to ocean
            //But inside elements have to be larger than the elements near to border.
            //Then ony they will flow to the ocean . If its is less continue .
            //If the cell has more height then do recurse
            if(newRow < 0 || newRow >= heights.length || newColumn < 0 || newColumn >= heights[0].length
                    || visited[newRow][newColumn] || heights[newRow][newColumn] < heights[row][column]) {
                continue;
            }

            dfs(heights, visited, newRow, newColumn);
        }
    }



    //BFS Version
    public List<List<Integer>> pacificAtlanticV2(int[][] heights) {

        int row = heights.length;
        int column = heights[0].length;

        boolean[][] pacificFlow = new boolean[row][column];
        boolean[][] atlanticFlow = new boolean[row][column];

        //Traverse from the Borders
        Queue<int[]> pacificQueue = new ArrayDeque<>();
        Queue<int[]> atlanticQueue = new ArrayDeque<>();
        for(int i = 0; i < column; i++) {

            pacificQueue.offer(new int[]{0, i}); //Top Row . Pacific Border
            atlanticQueue.offer(new int[]{row - 1, i}); // Bottom Row Atlantic
        }

        for(int i = 0; i < row; i++) {

            pacificQueue.offer(new int[]{i, 0}); //Left Column . Pacific
            atlanticQueue.offer(new int[]{i, column - 1}); //Right Column . Atlantic
        }

        //Calling BFS inside the loop was giving TLE
        //added border coordinate in the queue and calliing BFS here
        bfs(heights, pacificFlow, pacificQueue);
        bfs(heights, atlanticFlow, atlanticQueue);

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(pacificFlow[i][j] && atlanticFlow[i][j]) {
                    List<Integer> coordinate = new ArrayList<>();
                    coordinate.add(i);
                    coordinate.add(j);
                    result.add(coordinate);
                }
            }
        }
        return result;
    }

    public void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue){

        while(!queue.isEmpty()) {

            int[] currentCell = queue.poll();
            int currentRow = currentCell[0];
            int currentColumn = currentCell[1];

            visited[currentRow][currentColumn] = true; //Mark Visited

            for(int[] dir : dirs) {
                int newRow = currentRow + dir[0];
                int newColumn = currentColumn + dir[1];

                //heights[newRow][newColumn] < heights[row][column] condition is Imp
                //We are traversing inside the matrix from shore. All the border elements will be flown to ocean
                //But inside elements have to be larger than the elements near to border.
                //Then ony they will flow to the ocean . If its is less continue .
                //If the cell has more height then do recurse
                if(newRow < 0 || newRow >= heights.length || newColumn < 0 || newColumn >= heights[0].length
                        || visited[newRow][newColumn] || heights[newRow][newColumn] < heights[currentRow][currentColumn]) {
                    continue;
                }

                queue.add(new int[]{newRow, newColumn});
            }

        }
    }
}
