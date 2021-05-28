package org.atanu.java.ds.backtracking;

public class RatInMaze {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private boolean  move(int[][] maze, int[][] visited, int x, int y, int targetX, int targetY) {
        if(x == targetX && y == targetY){
            printPath(visited);
            return true;
        }

        for(int[] dir : dirs) {
            int nextRow = x + dir[0];
            int nextColumn = y + dir[1];
            if(isSafe(maze, visited, nextRow, nextColumn)){
                visited[nextRow][nextColumn] = 1;
                if(move(maze, visited, nextRow, nextColumn, targetX, targetY)){
                    return true;
                }
                visited[nextRow][nextColumn] = 0;
            }
        }
        return false; // No movement leads to result
    }

    private boolean isSafe(int[][] maze, int[][] visited, int row, int column) {
        if(row < 0 || row >= maze.length || column < 0 || column >= maze[0].length || visited[row][column] == 1 || maze[row][column] == 0){
            return false;
        }
        return true;
    }

    private void printPath(int[][] visited) {
        for(int[] path : visited){
            for(int a: path) {
                System.out.print(a+" ");
            }
            System.out.println();
        }
        System.out.println("++++++++");
    }

    public static void main(String[] args) {
        RatInMaze ratInMaze = new RatInMaze();
        int[][] maze = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };
        int[][] visited = new int[maze.length][maze[0].length];
        int targetX = maze.length -1;
        int targetY = maze[0].length -1;
        visited[0][0] = 1;
        ratInMaze.move(maze, visited, 0, 0, targetX, targetY);
    }


}
