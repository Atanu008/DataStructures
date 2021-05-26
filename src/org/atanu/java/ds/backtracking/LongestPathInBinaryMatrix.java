package org.atanu.java.ds.backtracking;

//https://www.techiedelight.com/find-longest-possible-route-matrix/#:~:text=Given%20a%20rectangular%20path%20in,cycles%20in%20the%20output%20path.
// Longest Path can only be found by Backtracking. as we need to see al possible combinations
public class LongestPathInBinaryMatrix {
    int maxPath = Integer.MIN_VALUE;

    private void longestPathBinaryMatrix(int[][] grid, int[][] visited, int row, int column, int x, int y, int dist, int move){
        if(row == x && column == y){
            maxPath = Math.max(maxPath, dist);
            // For this input 12 is the minumum Path. printing the path
            if(dist == 22) {
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
                longestPathBinaryMatrix(grid, visited, nextRow, nextCol, x, y, dist + 1, move);
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
                        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                        { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                        { 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
                };

        int[][] visited = new int[grid.length][grid[0].length];
        visited[0][0] = 1; // Mark the starting Point
        int x = 5;
        int y = 7;
        LongestPathInBinaryMatrix path = new LongestPathInBinaryMatrix();

        path.longestPathBinaryMatrix(grid,  visited, 0, 0, x, y, 0 , 1);
        System.out.println(path.maxPath);

        //x = 3;
       // y = 4;
        //path.shortestPathBinaryMatrix(mat,  visited, 0, 0, x, y, 0 , 0);
        //System.out.println(path.minPath);


    }
}
