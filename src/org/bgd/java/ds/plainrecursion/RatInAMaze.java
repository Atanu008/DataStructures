package org.bgd.java.ds.plainrecursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <a href="https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1">...</a>
 *
 * Rat in a Maze Problem - I
 *
 * Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
 * Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.
 *
 * Example 1:
 *
 * Input:
 * N = 4
 * m[][] = {{1, 0, 0, 0},
 *          {1, 1, 0, 1},
 *          {1, 1, 0, 0},
 *          {0, 1, 1, 1}}
 * Output:
 * DDRDRR DRDDRR
 * Explanation:
 * The rat can reach the destination at
 * (3, 3) from (0, 0) by two paths - DRDDRR
 * and DDRDRR, when printed in sorted order
 * we get DDRDRR DRDDRR.
 */
public class RatInAMaze {
    static int size;

    static ArrayList<String> answer;

    public static ArrayList<String> findPath(int[][] m, int n) {
        answer = new ArrayList<>();
        size = n;
        int[][] visited = new int[n][n];
        for (int[] v : visited) {
            Arrays.fill(v, 0);
        }
        if (m[0][0] == 1)
            pathBacktrack(m, 0, 0, "", visited);
        return answer;
    }

    private static void pathBacktrack(int[][] m, int i, int j, String s, int[][] visited) {
        if (i == size - 1 && j == size - 1) {
            answer.add(s);
            return;
        }

        visited[i][j] = 1;
        // up
        if (i - 1 >= 0 && visited[i - 1][j] != 1 && m[i - 1][j] == 1) {

            pathBacktrack(m, i - 1, j, s + "U", visited);

        }

        // left
        if (j - 1 >= 0 && visited[i][j - 1] != 1 && m[i][j - 1] == 1) {

            pathBacktrack(m, i, j - 1, s + "L", visited);

        }

        //down
        if (i + 1 < size && visited[i + 1][j] != 1 && m[i + 1][j] == 1) {

            pathBacktrack(m, i + 1, j, s + "D", visited);

        }

        // right
        if (j + 1 < size && visited[i][j + 1] != 1 && m[i][j + 1] == 1) {

            pathBacktrack(m, i, j + 1, s + "R", visited);

        }
        visited[i][j] = 0;
    }
}
