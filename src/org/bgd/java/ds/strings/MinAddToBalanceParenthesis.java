package org.bgd.java.ds.strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 *
 * A parentheses string is valid if and only if:
 *
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "())"
 * Output: 1
 * Example 2:
 *
 * Input: s = "((("
 * Output: 3
 *
 */

public class MinAddToBalanceParenthesis {

    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (isMatching(stack.peek(), c)) {
                stack.poll();
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    private boolean isMatching(Character a, Character b) {
        return a == '(' && b == ')';
    }

    /**
     * Space optimised
     */

    private int minAddToMakeValidSpaceOptimised(String s) {
        int balance = 0;
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance += 1;
            } else {
                balance -= 1;
            }
            if (balance == -1) {
                balance += 1;
                answer += 1;
            }
        }
        return answer + balance;
    }
}
