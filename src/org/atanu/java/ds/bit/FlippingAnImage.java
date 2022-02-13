package org.atanu.java.ds.bit;

import java.util.Arrays;
//https://leetcode.com/problems/flipping-an-image/
//LeetCode 832
//https://www.educative.io/courses/grokking-the-coding-interview/3j7zEJzL2y9
public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] image) {
        int C = image[0].length;
        for (int[] row: image) {
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        FlippingAnImage flippingAnImage = new FlippingAnImage();
        int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        int[][] result = flippingAnImage.flipAndInvertImage(arr);
        System.out.println(Arrays.deepToString(result));

        int[][] arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        result = flippingAnImage.flipAndInvertImage(arr2);
        System.out.println(Arrays.deepToString(result));
    }
}
