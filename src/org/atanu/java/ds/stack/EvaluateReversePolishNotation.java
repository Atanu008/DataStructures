package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/
//LeetCode 150
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            String ch = tokens[i];

            if("+".equals(ch)){
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(operand2 + operand1);
            }
            else if("-".equals(ch)){
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(operand2 - operand1);
            }
            else if("*".equals(ch)){
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(operand2 * operand1);
            }
            else if("/".equals(ch)){
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(operand2 / operand1);
            }

            else{
                stack.push(Integer.parseInt(ch));
            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        String[] tokens = {"2","1","+","3","*"};
        int result = evaluateReversePolishNotation.evalRPN(tokens);
        //Output: 9
        //Explanation: ((2 + 1) * 3) = 9
        System.out.println(result);

        tokens = new String[]{"4","13","5","/","+"};
        result = evaluateReversePolishNotation.evalRPN(tokens);
        //Output: 6
        //Explanation: (4 + (13 / 5)) = 6
        System.out.println(result);
    }
}
