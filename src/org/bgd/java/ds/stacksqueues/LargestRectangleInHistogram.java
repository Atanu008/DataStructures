package org.bgd.java.ds.stacksqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/description/">...</a>
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 * Example 1:
 *
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 */
public class LargestRectangleInHistogram {

    /**
     * Two pass with additional space approach
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int[] leftSmall = new int[heights.length];
        int[] rightSmall = new int[heights.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftSmall[i] = 0;
            } else {
                leftSmall[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            stack.pop();
        }

        for (int i = heights.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightSmall[i] = heights.length-1;
            } else {
                rightSmall[i] = stack.peek() - 1;
            }
            stack.push(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++) {
            max = Math.max(max, (rightSmall[i] - leftSmall[i] + 1) * heights[i]);
        }
        return max;
    }

    public int largestRectangleAreaOptimal(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxArea = -1;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = i - stack.peek() - 1;
                maxArea = Math.max(w * h, maxArea);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int h = heights[stack.pop()];
            int w = heights.length - stack.peek() - 1;
            maxArea = Math.max(w * h, maxArea);
        }
        return maxArea;
    }

    /**
     * Divide And Conquer Algorithm
     */
    public int largestRect(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        int index = start;
        int area = -1;
        for (int i = start; i <= end; i++) {
            if (heights[i] < heights[index]) {
                index = i;
            }
        }
        area = heights[index] * (end - start + 1);
        int largest = Math.max(largestRect(heights, start, index - 1), largestRect(heights, index + 1, end));
        return Math.max(area, largest);
    }
}
