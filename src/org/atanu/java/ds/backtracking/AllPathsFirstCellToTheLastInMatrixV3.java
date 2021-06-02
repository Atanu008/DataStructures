package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//https://www.techiedelight.com/find-all-paths-from-source-to-destination-in-matrix/
public class AllPathsFirstCellToTheLastInMatrixV3 {
    List<List<Integer>> result = new ArrayList<>();
    public void findPath(int[][] grid, int row, int column, LinkedList<Integer> path){
        int M = grid.length;
        int N = grid[0].length;

        if(row == M -1 && column == N -1){
            path.addLast(grid[row][column]); // We need to also add it here . as we are not adding it in Dir loop
            result.add(new ArrayList<>(path));
            path.removeLast();// Remove after teh path is added to result
            return;
        }
        //Add Path
        path.addLast(grid[row][column]);
        if(row >= 0 && row < M && column + 1 >= 0 && column + 1 < N)
            findPath(grid, row, column + 1, path);
        if(row + 1 >= 0 && row + 1 < M && column >= 0 && column < N)
            findPath(grid, row+1, column, path);
        //Remove the path
        path.removeLast();
    }

    public static void main(String[] args) {
        int[][] grid =
                {
                        { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 }
                };

        AllPathsFirstCellToTheLastInMatrixV3 lastInMatrixV3 = new AllPathsFirstCellToTheLastInMatrixV3();
        LinkedList<Integer> path = new LinkedList<>();
        // start from `(0, 0)` cell
        int x = 0, y = 0;
        lastInMatrixV3.findPath(grid, x , y, path);
        System.out.println("AllPathsFirstCellToTheLastInMatrix V3");
        lastInMatrixV3.result.forEach(System.out::println);
    }
}
