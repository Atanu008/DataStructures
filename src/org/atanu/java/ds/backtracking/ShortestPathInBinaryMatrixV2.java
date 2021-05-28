package org.atanu.java.ds.backtracking;

//https://www.techiedelight.com/find-shortest-path-in-maze/
//https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
public class ShortestPathInBinaryMatrixV2 {

    private long shortestPathBinaryMatrix(int[][] grid, int[][] visited, int row, int column, int x, int y){

        if(!isValid(grid, visited, row, column)) {
            return Integer.MAX_VALUE; // Returning Max_Value other teh than the Target cell.
        }
        if(row == x && column == y){
            printPath(visited);
            return 0;
        }

        visited[row][column] = 1;
        long top = shortestPathBinaryMatrix(grid, visited, row -1, column, x, y);
        long left = shortestPathBinaryMatrix(grid, visited, row, column-1, x, y);
        long bottom = shortestPathBinaryMatrix(grid, visited, row+1, column, x, y);;
        long right = shortestPathBinaryMatrix(grid, visited, row, column + 1, x, y);
        //System.out.println(top +" "+left+ " "+ bottom+ " "+right);
        long minPath = Math.min(right, Math.min(left, Math.min(top,bottom)));
        visited[row][column] = 0;

        // +1 for Including
        // Integer.MAX_VALUE + 1 would yeild to negative value. Changed the method signature to accomodate that.
        return  minPath + 1;
    }

    private boolean isValid(int[][] grid, int[][] visited, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0 || visited[row][column] != 0)
            return false;
        return true;
    }

    private void printPath(int[][] visited) {
        for(int[] path : visited){
            for(int a: path) {
                System.out.print(a+" ");
            }
            System.out.println();
        }
        System.out.println("++++++=");
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
        ShortestPathInBinaryMatrixV2 path = new ShortestPathInBinaryMatrixV2();
        int[][] visited = new int[grid.length][grid[0].length];
        int x = 7;
        int y = 5;
        long res = path.shortestPathBinaryMatrix(grid,visited, 0, 0, x, y);
        System.out.println(res);


    }
}
