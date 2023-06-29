package org.atanu.java.ds.stack;

// https://leetcode.com/problems/valid-parentheses/description/
// Leetcode 20

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }else if(ch == ')' || ch == '}' || ch == ']') {
                if(stack.isEmpty() || !openCloseMatching(stack.peek(), ch)){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private boolean openCloseMatching(char open, char close){

        if(open == '(' && close == ')'){
            return true;
        }else if(open == '{' && close == '}'){
            return true;
        }else if(open == '[' && close == ']'){
            return true;
        }

        return false;
    }

    // Check the validation using Map
    public boolean isValid_v2(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }else if(ch == ')' || ch == '}' || ch == ']') {
                if(stack.isEmpty() || map.get(stack.peek()) != ch){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "()[]{}";
        System.out.println(validParentheses.isValid(s));
        s = "(]";
        System.out.println(validParentheses.isValid(s));

    }
}
