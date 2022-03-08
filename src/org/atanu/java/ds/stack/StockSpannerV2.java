package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/online-stock-span/
//LeetCode 901
//https://leetcode.com/problems/online-stock-span/discuss/640358/JAVA-Solution-With-visualization-and-easy-explained!
public class StockSpannerV2 {
    Stack<int[]> stack = null;
    public StockSpannerV2() {

        stack = new Stack<>();
    }

    public int next(int price) {

        int span = 1; //Initial Span is 1

        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }
}
