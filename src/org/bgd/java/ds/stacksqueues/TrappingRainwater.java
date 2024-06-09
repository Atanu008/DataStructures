package org.bgd.java.ds.stacksqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/">...</a>
 *
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 */

public class TrappingRainwater {

    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxL = 1, maxR = 1;

        int ans = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                maxL = Math.max(maxL, height[l]);
                ans += maxL - height[l];
                l++;
            } else {
                maxR = Math.max(maxR, height[r]);
                ans += maxR - height[r];
                r--;
            }
        }
        return ans;
    }

    public int trapWithStack(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int answer = 0;
        while (i < height.length) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()] - height[top]);
                answer += width * boundedHeight;
            }
            stack.push(i);
            i++;
        }
        return answer;
    }
}
