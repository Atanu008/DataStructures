package org.atanu.java.ds.graph;

//LeetCode 329
//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// yet to Implement using Longest Path in DAG. Topological Sort
public class LongestIncreasingPath {
    int[][] dir ={{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int longestPath = 0;
        //Map<String, Integer> cache = new HashMap<>();
        int[][] cache = new int[row][column];
        for(int i = 0; i< row; i++) {
            for(int j = 0; j < column; j++) {
                int length = dfs(matrix, i, j, row, column, cache);
                longestPath = Math.max(length,longestPath);
            }
        }
        return longestPath;
    }

    private int dfs(int[][] matrix, int i , int j, int row, int column, int[][] cache) {
        //String key = i+" "+j;
        //if(cache.containsKey(key)){
        //    return cache.get(key);
        //}
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        int max = 0;
        for(int[] direction: dir) {
            int x = i + direction[0];
            int y = j + direction[1];
            if(x >= 0 && y >= 0 && x < row && y < column && matrix[x][y] > matrix[i][j]){
                max = Math.max(max,dfs(matrix, x, y, row, column, cache));
            }
        }
        cache[i][j] = max + 1;
        //cache.put(key, max + 1);
        return max + 1;
    }

    public static void main(String[] args) {
        LongestIncreasingPath longestIncreasingPath = new LongestIncreasingPath();
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        int longestPath = longestIncreasingPath.longestIncreasingPath(matrix);
        System.out.println("Longest Increasing Path Length "+ longestPath);
    }
}
