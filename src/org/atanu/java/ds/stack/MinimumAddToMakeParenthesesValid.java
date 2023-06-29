package org.atanu.java.ds.stack;

// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
// Leetcode 921

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    // Algorithm :
    // 1. If it is opening bracket push it to the Stack
    // 2. if it is closing bracket
    //    2a. If stack is EMPTY that means we dont have any opening bracket for this closing bracket.
    //        So we need one opening bracket. increment missingBracketCount
    //    2b. If stack is NOT empty that means we have matching opening bracket.
    //        just pop the opening bracket from stack
    // After the loop is done
    // a.stack will have opening brackets that does not have any closing
    // b missingBracketCount will have the number of closing bracket which does not have any opening bracket
    // return the summation of them

    public int minAddToMakeValid(String s) {

        Stack<Character> stack = new Stack<>();
        int missingBracketCount = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){ // ()) : for the last
                    missingBracketCount++;
                }else{
                    stack.pop();
                }
            }
        }

        return missingBracketCount + stack.size();
    }

    // Same algorithm as above
    // But we actually dont need a stack
    public int minAddToMakeValid_v2(String s) {
        int missingBracketCount = 0;
        int bracketBalance = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                bracketBalance++;
            }else{
                if(bracketBalance == 0){
                    missingBracketCount++;
                }else{
                    bracketBalance--;
                }
            }
        }
        return missingBracketCount + bracketBalance;
    }
}
