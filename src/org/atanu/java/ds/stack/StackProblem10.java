package org.atanu.java.ds.stack;

import java.util.Stack;

public class StackProblem10 {


    public static int findMaxRectangle(int[] histogram) {


        Stack<Integer> stack = new Stack<>();
        int n = histogram.length;
        int max_area = 0;
        int area_withTop;

        int i = 0;

        while (i < n) {
            if (stack.isEmpty() || histogram[stack.peek()] <= histogram[i]) {
                stack.push(i++);
            } else {
                int top = stack.peek();
                stack.pop();

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
            int top = stack.peek();
            stack.pop();

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

    public static void main(String[] args) {


        int hist[] = {2, 4, 5, 1, 2};
        int max_area = findMaxRectangle(hist);

        System.out.println("Maximum area is " + max_area);
    }

}
