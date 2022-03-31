package org.atanu.java.ds.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/minimum-knight-moves/
//LeetCode 1197
// Video : https://www.youtube.com/watch?v=UqFXSGeFHTI&t=1211s (after 19minute imp)
public class MinimumKnightMovesInfiniteGrid {

    int[][] dirs = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    public int minKnightMoves(int x, int y) {

        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new int[]{0,0});
        visited.add("0,0");

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
                    String coridinateString = newRow +"," + newColumn;
                    if(!visited.contains(coridinateString) && newRow >= -1 && newColumn >= -1) {
                        queue.add(new int[]{newRow,newColumn});
                        visited.add(coridinateString);
                    }
                }
            }

            move++;
        }

        return move;
    }
}
