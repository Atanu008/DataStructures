package org.bgd.java.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/flood-fill/description/">...</a>
 *
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 *
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 *
 * Return the modified image after performing the flood fill.
 *
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> q = new LinkedList<>();
        int original = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        q.offer(new Pair(sr, sc));
        if (original == color) {
            return image;
        }
        image[sr][sc] = color;
        int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int s = q.size();
            Pair top = q.poll();
            for (int i = 0; i < s; i++) {
                for (int[] d : directions) {
                    int newx = top.x + d[0];
                    int newy = top.y + d[1];
                    if (newx >= 0 && newx < m && newy >= 0 && newy < n && image[newx][newy] == original) {
                        image[newx][newy] = color;
                        q.offer(new Pair(newx, newy));
                    }
                }
            }
        }
        return image;
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
