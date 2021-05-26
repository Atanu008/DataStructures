package org.atanu.java.ds.backtracking;

//https://www.techiedelight.com/find-shortest-path-in-maze/
//https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
//Ideal solution is BFS
public class ShortestPathInBinaryMatrix {

    int minPath = Integer.MAX_VALUE;

    private void shortestPathBinaryMatrix(int[][] grid, int[][] visited, int row, int column, int x, int y, int dist, int move){
        if(row == x && column == y){
            minPath = Math.min(minPath, dist);
            // For this input 12 is the minumum Path. printing the path
            if(dist == 12) {
                printPath(visited);
            }
            return;
        }

        int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0, 1}};
        for(int[] dir: dirs){
            int nextRow = dir[0] + row;
            int nextCol = dir[1] + column;
            if(isValid(grid, visited, nextRow, nextCol)){
                move++;
                visited[nextRow][nextCol] = move;
                shortestPathBinaryMatrix(grid, visited, nextRow, nextCol, x, y, dist + 1, move);
                move--;
                visited[nextRow][nextCol] = 0;

            }
        }
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

    private boolean isValid(int[][] grid, int[][] visited, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0 || visited[row][column] != 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] grid =
                {
                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                        { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
                        { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                        { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                        { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
                };
        int[][] mat =
        {
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };
        int[][] visited = new int[grid.length][grid[0].length];
        visited[0][0] = 1; // Mark the starting Point
        int x = 7;
        int y = 5;
        ShortestPathInBinaryMatrix path = new ShortestPathInBinaryMatrix();

        path.shortestPathBinaryMatrix(grid,  visited, 0, 0, x, y, 0 , 1);
        System.out.println(path.minPath);

        x = 3;
        y = 4;
        //path.shortestPathBinaryMatrix(mat,  visited, 0, 0, x, y, 0 , 0);
        //System.out.println(path.minPath);


    }
}
