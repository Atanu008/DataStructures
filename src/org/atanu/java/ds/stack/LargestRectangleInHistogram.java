package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/largest-rectangle-in-histogram/
//LeetCode 84
//https://www.youtube.com/watch?v=MhQPpAoZbMc&t=410s
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        int n = histogram.length;
        int max_area = 0;
        int area_withTop;

        int i = 0;

        while (i < n) {
            if (stack.isEmpty() || histogram[stack.peek()] <= histogram[i]) {
                stack.push(i++);
            } else {

                int top = stack.pop();
                if (stack.isEmpty()) {
                    area_withTop = histogram[top] * i;
                } else {
                    area_withTop = histogram[top] * (i - stack.peek() - 1);
                }

                if (max_area < area_withTop)
                    max_area = area_withTop;
            }

        }

        while (!stack.isEmpty()) {

            int top = stack.pop();
            if (stack.isEmpty()) {
                area_withTop = histogram[top] * i;
            } else {
                area_withTop = histogram[top] * (i - stack.peek() - 1);
            }

            if (max_area < area_withTop)
                max_area = area_withTop;
        }

        return max_area;
    }

    //Same as Above just using Ternary Operator
    public int largestRectangleAreaV2(int[] histogram) {
        int n = histogram.length;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int currentAreaWithPopped = 0;
        while(i < n) {
            //Keep Increasing Monotonic Stack
            if(stack.isEmpty() || histogram[stack.peek()] <= histogram[i] ){
                stack.push(i++);
            }
            else{
                int popped = stack.pop();
                currentAreaWithPopped = stack.isEmpty() ? histogram[popped] * i : histogram[popped] * (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, currentAreaWithPopped);
            }
        }

        while(!stack.isEmpty()){
            int popped = stack.pop();
            currentAreaWithPopped = stack.isEmpty() ? histogram[popped] * i : histogram[popped] * (i - stack.peek() - 1);
            maxArea = Math.max(maxArea, currentAreaWithPopped);
        }

        return maxArea;
    }
}
