package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/
//LeetCode 739
//Monotic Decreasing Stack. Same Solution as Stock Spanner
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {

            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }

            //Record Index
            stack.push(i);
        }
        return result;
    }

    //Exactly Same Solution as StockSpanner :)
    public int[] dailyTemperaturesV2(int[] temperatures) {

        Stack<int[]> stack = new Stack<>(); //Store Temprature and Index
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {

            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int index = stack.pop()[1];
                result[index] = i - index;
            }

            stack.push(new int[]{temperatures[i], i});
        }
        return result;
    }
}
