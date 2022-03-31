package org.atanu.java.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1
public class MinimumKnightMoves {

    int[][] dirs = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    public int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N)
    {
        int x = TargetPos[0];
        int y = TargetPos[1];

        int originX = KnightPos[0];
        int originY = KnightPos[1];
        //String originCordinateString = originX +"," + originY;

        Queue<int[]> queue = new LinkedList<>();
        //Set<String> visited = new HashSet<>();
        queue.add(new int[]{originX,originY});
        boolean[][] visited = new boolean[N+1][N+1];
        visited[originX][originY] = true;
        //visited.add(originCordinateString);

        int move = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            while(size --> 0){
                int[] currentCoordinate = queue.poll();
                int row = currentCoordinate[0];
                int column = currentCoordinate[1];
                if(row ==x && column == y){
                    return move;
                }
                for(int dir[] : dirs){
                    int newRow = row + dir[0];
                    int newColumn = column + dir[1];
                    //String coridinateString = newRow +"," + newColumn;
                    if(isInside(newRow, newColumn, N) && !visited[newRow][newColumn]) {
                        queue.add(new int[]{newRow,newColumn});
                        //visited.add(coridinateString);
                        visited[newRow][newColumn] = true;
                    }
                }
            }

            move++;
        }

        return -1;
    }

    public boolean isInside(int x, int y, int N)
    {
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }

    public static void main(String[] args) {
        MinimumKnightMoves minimumKnightMoves = new MinimumKnightMoves();
        int N=6;
        int[] knightPos = {4, 5};
        int[] targetPos = {1, 1};

        int minMove = minimumKnightMoves.minStepToReachTarget(knightPos, targetPos, N);
        System.out.println("Minimum Move "+ minMove);
    }
}
