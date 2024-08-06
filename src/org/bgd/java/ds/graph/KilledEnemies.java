package org.bgd.java.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class KilledEnemies {
    public int maxKilledEnemies(char[][] grid) {

        List<int[]> empty = new ArrayList<>();

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    empty.add(new int[] { i, j });
                    int killed = maxKilled(i, j, grid);
                    max = Math.max(max, killed);
                }
            }
        }
        return max;
    }

    private int maxKilled(int row, int col, char[][] grid) {
        int enemyCount = 0;
        int r = row;
        int c = col;

        // to left
        for (int i = c - 1; i >= 0; i--) {
            if (grid[r][i] == 'W') {
                break;
            }
            if (grid[r][i] == 'E') {
                enemyCount += 1;
            }
        }

        // to right
        for (int i = c + 1; i < grid[0].length; i++) {
            if (grid[r][i] == 'W') {
                break;
            }
            if (grid[r][i] == 'E') {
                enemyCount += 1;
            }
        }

        // to down

        for (int i = r + 1; i < grid.length; i++) {
            if (grid[i][c] == 'W') {
                break;
            }
            if (grid[i][c] == 'E') {
                enemyCount += 1;
            }
        }

        // to up
        for (int i = r - 1; i >= 0; i--) {
            if (grid[i][c] == 'W') {
                break;
            }
            if (grid[i][c] == 'E') {
                enemyCount += 1;
            }
        }
        return enemyCount;
    }
}
