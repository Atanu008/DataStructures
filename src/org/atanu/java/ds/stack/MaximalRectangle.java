package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/maximal-rectangle/
//LeetCode 85

//PreRequisite
//https://leetcode.com/problems/largest-rectangle-in-histogram/
//LeetCode 84
//https://www.youtube.com/watch?v=MhQPpAoZbMc&t=410s
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {

        int row = matrix.length;
        int column = matrix[0].length;


        int[][] dp = new int[row][column];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                dp[i][j] = matrix[i][j] - '0';
                if(dp[i][j] > 0 && i > 0 ) {
                    dp[i][j] += dp[i-1][j];
                }
            }
        }

        int maximalRectangleArea = 0;
        for(int[] histogram: dp){
            maximalRectangleArea = Math.max(maximalRectangleArea, largestRectangleArea(histogram));
        }

        return maximalRectangleArea;
    }

    public int largestRectangleArea(int[] histogram) {

        int n = histogram.length;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int currentAreaWithPopped = 0;
        while(i < n) {
            //Keep Increassing Monotonic Stack
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
