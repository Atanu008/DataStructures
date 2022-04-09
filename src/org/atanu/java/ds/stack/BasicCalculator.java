package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/basic-calculator/
//LeetCode 224

//Video : https://www.youtube.com/watch?v=081AqOuasw0
//Video : https://www.youtube.com/watch?v=BjDczS5uQ-g
public class BasicCalculator {

    public int calculate(String s) {

        int sign = 1;
        int sum = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(Character.isDigit(ch)){

                int num = ch - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }

                sum += num * sign;
            }

            else if(ch == '+'){
                sign = 1;
            }
            else if(ch == '-'){
                sign = -1;
            }
            else if(ch == '('){
                stack.push(sum);
                stack.push(sign);

                sum = 0;
                sign = 1;
            }
            else if(ch == ')'){

                int currentNumber = sum * stack.pop(); // this pop will hav ethe sign(1 or -1)
                int previousNumber = stack.pop();

                sum = currentNumber + previousNumber;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        String s = "(1+(4+5+2)-3)+(6+8)";
        int result = basicCalculator.calculate(s);
        System.out.println(result);
    }
}
