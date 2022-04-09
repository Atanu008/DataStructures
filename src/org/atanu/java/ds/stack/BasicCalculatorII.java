package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/basic-calculator-ii/
//LeetCode 227
public class BasicCalculatorII {

    public int calculate(String s) {

        int currentNumber = 0;
        char sign = '+'; //This is actually denote Previous Sign
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){

            char currentCharacter = s.charAt(i);

            if(Character.isDigit(currentCharacter)){
                int num = currentCharacter - '0';
                while(i +1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num*10 +  s.charAt(i+1) - '0';
                    i++;
                }

                currentNumber = num;
            }


            if(isOperator(currentCharacter) || i == s.length() - 1){
                if(sign == '+'){
                    stack.push(currentNumber);
                }
                else if(sign == '-'){
                    stack.push(-currentNumber);
                }
                else if(sign == '*'){
                    stack.push(stack.pop() * currentNumber);
                }
                else if(sign == '/'){
                    stack.push(stack.pop() / currentNumber);
                }

                sign = currentCharacter;
                currentNumber = 0;
            }

        }

        int result = 0;
        for(int a : stack){
            result += a;
        }

        return result;
    }

    private boolean isOperator(char ch){

        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
