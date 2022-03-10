package org.atanu.java.ds.stack;

//https://leetcode.com/problems/score-of-parentheses/
//LeetCode 856
//Video : https://www.youtube.com/watch?v=zy7WmYm1KMo&t=538s
import java.util.Stack;

public class ScoreOfParentheses {

    public int scoreOfParentheses(String s) {

        Stack<String> stack = new Stack<>();
        int score = 0;
        for(char ch : s.toCharArray()) {
            if(stack.isEmpty() || ch == '(') {
                stack.push(ch +"");
            }
            else if(ch == ')') {
                int innerScore = 0;
                while(!stack.isEmpty() && !"(".equals(stack.peek())) {
                    innerScore += Integer.parseInt(stack.pop());
                }
                stack.pop();
                stack.push(innerScore == 0 ? 1+"" : (innerScore * 2) +"");
            }
        }

        while(!stack.isEmpty()) {
            score += Integer.parseInt(stack.pop());
        }

        return score;
    }
}
