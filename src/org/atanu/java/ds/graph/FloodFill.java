package org.atanu.java.ds.graph;

import java.util.Arrays;

//https://leetcode.com/problems/flood-fill/
//LletCode 733
public class FloodFill {

    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int row = image.length;
        int column = image[0].length;
        boolean[][] visited = new boolean[row][column];
        int oldColor = image[sr][sc];
        dfs(image, oldColor, newColor, visited, sr,  sc);
        return image;
    }

    public void dfs(int[][] image, int oldColor, int newColor, boolean[][] visited, int row, int column){

        if(row < 0 || row >= image.length || column < 0 || column >= image[0].length || image[row][column] != oldColor || visited[row][column]){
            return;
        }

        visited[row][column] = true;
        image[row][column] = newColor;
        for(int[] dir : dirs){
            int newRow = row + dir[0];
            int newCloumn = column + dir[1];
            dfs(image, oldColor, newColor, visited,newRow,  newCloumn);
        }
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
        //Output: [[2,2,2],[2,2,0],[2,0,1]]
        //Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
        //Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
        floodFill.floodFill(image, sr,sc, newColor);
        System.out.println(Arrays.deepToString(image));
    }
}
