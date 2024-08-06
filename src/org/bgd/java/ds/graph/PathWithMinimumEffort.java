package org.bgd.java.ds.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/path-with-minimum-effort/description/">...</a>
 *
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 *
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 *
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 *
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 *
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
 *
 *
 */
public class PathWithMinimumEffort {
    /*
    Backtracking solution with DFS
    Starts from 0, 0 and goes till end and compares the efforts while backtracking if a path with smaller effort is found
     */

    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
    int maxSoFar = Integer.MAX_VALUE;

    public int minimumEffortPathBackTrack(int[][] heights) {
        return backtrack(heights, 0, 0, 0);
    }

    private int backtrack(int[][] heights, int x, int y, int maxDifference) {
        if (x == heights.length - 1 && y == heights[0].length - 1) {
            maxSoFar = Math.min(maxSoFar, maxDifference);
            return maxDifference;
        }
        int currentHeight = heights[x][y];
        int minEffort = Integer.MAX_VALUE;
        heights[x][y] = -1;

        for (int[] d : directions) {
            int newx = x + d[0];
            int newy = y + d[1];
            if (isValid(newx, newy, heights.length, heights[0].length) && heights[newx][newy] != -1) {
                int diff = Math.abs(heights[newx][newy] - currentHeight);
                int maxCurrDifference = Math.max(maxDifference, diff);
                if (maxCurrDifference < maxSoFar) {
                    int result = backtrack(heights, newx, newy, maxCurrDifference);
                    minEffort = Math.min(minEffort, result);
                }
            }
        }
        heights[x][y] = currentHeight;
        return minEffort;
    }

    private boolean isValid(int x, int y, int r, int c) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }

    /**
     * Binary search approach
     */

    public int minimumEffortPathP(int[][] heights) {
        int l = 0, r = 1000000;
        int min = r;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (canReachDestination(heights, m)) {
                min = Math.min(min, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return min;
    }

    private boolean canReachDestination(int[][] h, int k) {
        int r = h.length;
        int c = h[0].length;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node top = q.poll();
            if (top.x == r - 1 && top.y == c - 1) {
                return true;
            }
            for (int[] d : directions) {
                int newx = top.x + d[0];
                int newy = top.y + d[1];
                if (isValid(newx, newy, r, c) && !visited[newx][newy]) {
                    int diff = Math.abs(h[top.x][top.y] - h[newx][newy]);
                    if (diff <= k) {
                        visited[newx][newy] = true;
                        q.offer(new Node(newx, newy));
                    }
                }
            }
        }
        return false;
    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Priority Queue based approach
     */

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int columns = heights[0].length;
        int[][] dist = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                dist[i][j] = (int) 1e9;
            }
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.diff - y.diff);
        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };

        while (pq.size() != 0) {
            Tuple current = pq.peek();
            int diff = current.diff;
            int r = current.r;
            int c = current.c;
            pq.remove();

            if (r == rows - 1 && c == columns - 1) {
                return diff;
            }

            for (int i = 0; i < 4; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < rows && ncol < columns) {
                    int curr_diff = Math.max(diff, Math.abs(heights[r][c] - heights[nrow][ncol]));
                    if (curr_diff < dist[nrow][ncol]) {
                        dist[nrow][ncol] = curr_diff;
                        pq.add(new Tuple(curr_diff, nrow, ncol));
                    }

                }
            }

        }
        return 0;
    }
}

class Tuple {
    int diff;
    int r;
    int c;

    public Tuple(int diff, int r, int c) {
        this.diff = diff;
        this.r = r;
        this.c = c;
    }
}

