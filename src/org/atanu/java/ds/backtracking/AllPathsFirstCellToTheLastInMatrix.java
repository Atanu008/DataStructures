package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://www.techiedelight.com/find-all-paths-from-source-to-destination-in-matrix/
public class AllPathsFirstCellToTheLastInMatrix {
    //Right and Down
    int [][] dirs = {{0,1}, {1,0}};
    List<List<Integer>> result = new ArrayList<>(); // This result will be updated
    public void findPath(int[][] grid, int row, int column, LinkedList<Integer> path){
        //Last Cell. Can be also passed as M and N
        if(row == grid.length -1 && column == grid[grid.length -1].length -1){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextColumn = column + dir[1];
            if(isSafe(grid, nextRow, nextColumn)){
                path.addLast(grid[nextRow][nextColumn]);
                findPath(grid, nextRow, nextColumn, path);
                path.removeLast();
            }
        }
    }

    private boolean isSafe(int[][] grid, int row, int column) {
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] grid =
                {
                        { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 }
                };
        AllPathsFirstCellToTheLastInMatrix cellToTheLastInMatrix = new AllPathsFirstCellToTheLastInMatrix();
        LinkedList<Integer> path = new LinkedList<>();
        // start from `(0, 0)` cell
        int x = 0, y = 0;
        //mark the starting Point
        path.add(grid[x][y]);
        cellToTheLastInMatrix.findPath(grid, x , y, path);
        System.out.println("AllPathsFirstCellToTheLastInMatrix V1");
        cellToTheLastInMatrix.result.forEach(System.out::println);
    }
}
