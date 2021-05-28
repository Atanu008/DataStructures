package org.atanu.java.ds.backtracking;

public class RatInMazeV2 {

    private boolean  move(int[][] maze, int[][] visited, int x, int y, int targetX, int targetY) {
        if(x == targetX && y == targetY){
            visited[x][y] = 1;//Mark the target cell
            printPath(visited);
            return true;
        }

        if(isSafe(maze, visited, x, y)){

            visited[x][y] = 1;
            //right
            if(move(maze, visited, x, y+1, targetX, targetY))
                return true;
            //left
            if(move(maze, visited, x, y-1, targetX, targetY))
                return true;
            //bottom
            if(move(maze, visited, x+1, y, targetX, targetY))
                return true;
            //up
            if(move(maze, visited, x-1, y, targetX, targetY))
                return true;
            //If none of the above movements work then perform backtracking to unmark x, y as part of solution path
            visited[x][y] = 0;
            //return false; we may not need this. This is covered by last return i.e line 30
        }
        return false; // No movement leads to result
    }

    private void printPath(int[][] visited) {
        for(int[] path : visited){
            for(int a: path) {
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }

    private boolean isSafe(int[][] grid, int[][] visited, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0 || visited[row][column] != 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        RatInMazeV2 ratInMazeV2 = new RatInMazeV2();
        int[][] maze = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };
        int[][] visited = new int[maze.length][maze[0].length];
        int targetX = maze.length -1;
        int targetY = maze[0].length -1;
        ratInMazeV2.move(maze, visited, 0, 0, targetX, targetY);
    }
}
