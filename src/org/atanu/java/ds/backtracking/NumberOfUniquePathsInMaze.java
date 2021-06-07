package org.atanu.java.ds.backtracking;

//https://www.techiedelight.com/find-total-number-unique-paths-maze-source-destination/
//Same as Rate in maze. just need to maintain count in base case
public class NumberOfUniquePathsInMaze {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int count = 0;
    private static final int N = 4;

    private void  move(int[][] maze, int[][] visited, int x, int y, int targetX, int targetY) {

        //Just Mark it when visiting
        visited[x][y] = 1;
        if(x == targetX && y == targetY){
            count++;
            //return true;
        }

        for(int[] dir : dirs) {
            int nextRow = x + dir[0];
            int nextColumn = y + dir[1];
            //Make move if possible
            if(isSafe(maze, visited, nextRow, nextColumn)){
                move(maze, visited, nextRow, nextColumn, targetX, targetY);
            }
        }

        //Unmark
        visited[x][y] = 0;
    }

    private boolean isSafe(int[][] maze, int[][] visited, int row, int column) {
        if(row < 0 || row >= maze.length || column < 0 || column >= maze[0].length || visited[row][column] == 1 || maze[row][column] == 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] maze =
                {
                        { 1, 1, 1, 1 },
                        { 1, 1, 0, 1 },
                        { 0, 1, 0, 1 },
                        { 1, 1, 1, 1 }
                };

        NumberOfUniquePathsInMaze numberOfUniquePathsInMaze = new NumberOfUniquePathsInMaze();
        int[][] visited = new int[N][N];
        numberOfUniquePathsInMaze.move(maze, visited, 0, 0, N-1, N-1);
        System.out.println("The total number of unique paths are " + numberOfUniquePathsInMaze.count);
    }
}
