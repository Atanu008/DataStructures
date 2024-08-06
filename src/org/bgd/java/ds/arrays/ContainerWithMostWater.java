package org.bgd.java.ds.arrays;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/editorial/">...</a>
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            int w = r - l;
            max = Math.max(max, h * w);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
