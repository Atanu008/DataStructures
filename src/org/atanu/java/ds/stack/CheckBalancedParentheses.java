package org.atanu.java.ds.stack;

import java.util.Stack;

public class CheckBalancedParentheses {

    public static boolean checkBalancedParentheses(String exp) {

        Stack<Character> stack = new Stack();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty() || !isMatchingPair(stack.peek(), ch)) {
                    return false;
                } else {
                    stack.pop();
                }

            }


        }


        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }


    public static boolean isMatchingPair(char character1, char character2) {

        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else if (character1 == '[' && character2 == ']')
            return true;
        else
            return false;

    }

    public static void main(String[] args) {


        String exp = "{x+y*(a+b)}";

        boolean result = checkBalancedParentheses(exp);

        System.out.println("Balanced " + result);

    }

}
