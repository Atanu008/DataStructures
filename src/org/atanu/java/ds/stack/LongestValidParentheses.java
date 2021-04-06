package org.atanu.java.ds.stack;

import java.util.Stack;

//LeetCode 32
//https://leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {

        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(-1); // If the longest valid starts from the first index.

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{

                stack.pop();
                if(!stack.isEmpty()){
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
                else{
                    stack.push(i); // Push closing bracket index only if it is invalid at that point. It helps to calculate teh next longest
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        String s = "(()";
        int maxLength = longestValidParentheses.longestValidParentheses(s);
        System.out.println("Longest valid Parentheses Length for "+s +" is "+ maxLength);

    }
}
