package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/online-stock-span/
//LeetCode 901
//https://leetcode.com/problems/online-stock-span/discuss/640358/JAVA-Solution-With-visualization-and-easy-explained!
public class StockSpanner {

    //Could Be an array with two elements.
    private class Stock{
        int price;
        int span;
        Stock(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    //We should have a stack of a pair of (current  price, maximum number of consecutive days)
    //Since we don't have an access to the indicies.
    Stack<Stock> stack = null;
    public StockSpanner() {

        stack = new Stack<>();
    }

    public int next(int price) {

        int span = 1;
        //
        while(!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }

        stack.push(new Stock(price, span));

        return span;
    }
}
