package org.atanu.java.ds.graph;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/walls-and-gates/
//LeetCode 286
//Video : https://logicmojo.com/sub_videos/38
public class WallsAndGates {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    static class Node{
        int row;
        int column;
        int distance;
        public Node(int row, int column, int distance){
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }
    public void wallsAndGates(int[][] rooms) {

        Queue<Node> queue = new ArrayDeque<>();

        // add all gates to the queue
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[i].length; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new Node(i,j,0));
                }
            }
        }

        // update distance from gates
        while(!queue.isEmpty()){

            Node currentNode = queue.poll();
            int row = currentNode.row;
            int column = currentNode.column;

            for(int[] dir : dirs){
                int newRow = row + dir[0];
                int newColumn = column + dir[1];
                if(newRow < 0 || newRow > rooms.length -1 || newColumn < 0
                        || newColumn > rooms[0].length -1 || rooms[newRow][newColumn] != Integer.MAX_VALUE){
                    continue;
                }

                rooms[newRow][newColumn] = rooms[row][column] + 1;
                queue.offer(new Node(newRow,newColumn,rooms[row][column] + 1));
            }
        }
    }
}
