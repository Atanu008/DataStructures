package org.atanu.java.ds.graph;

//https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/description/
//Leetcode 1284

//Explanation
//-----------
//the idea is to use BFS to generate all combinations using flip and put it in queue.
//once a level of combination is generated, we check
//    1. if it reaches the target, if yes, returm the total steps of flip required.
//    2. if not then, check whether any of the combination is visited already or not,
//        if not visited, then add to visited set and add in queue.
//Here one level means all combination from a specific mat[][] orientation.
//TC : o(m*n * 2^(m*n))
//SC : o(2^m*n)
// */

import java.util.*;

public class MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix {
    public int minFlips(int[][] mat) {
        if(checkZeroMatrix(mat)){
            return 0;
        }

        Queue<int[][]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(mat);
        visited.add(serializeMatrix(mat));
        int level = 0;

        while(!queue.isEmpty()){

            int size = queue.size();
            while(size --> 0){

                int[][] current = queue.poll();
                if(checkZeroMatrix(current)){
                    return level;
                }
                List<int[][]> children = getAllChildren(current);

                for(int[][] child : children){
                    String nextChild = serializeMatrix(child);
                    if(!visited.contains(nextChild)){
                        queue.offer(child);
                        visited.add(nextChild);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private List<int[][]> getAllChildren(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        List<int[][]> children = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                children.add(flip(mat, i, j));
            }
        }
        return children;
    }

    private int[][] flip(int[][] mat, int row, int col){
        int m = mat.length;
        int n = mat[0].length;
        int[][] flippedMatrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if((i == row && j == col) || (i == row -1 && j == col) || (i == row + 1 && j == col)
                        || (i == row && j == col - 1) || (i == row && j == col + 1) ){
                    flippedMatrix[i][j] = 1 - mat[i][j];
                }
                else{
                    flippedMatrix[i][j] = mat[i][j];
                }
            }

        }
        return flippedMatrix;
    }
    private String serializeMatrix(int[][] mat){
        StringBuilder sb = new StringBuilder();
        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                sb.append(mat[i][j]+"");
            }
            sb.append("#");
        }

        return sb.toString();
    }
    private boolean checkZeroMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {0,0},{0,1}
        };
        System.out.println(new MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix().minFlips(mat));
    }
}
