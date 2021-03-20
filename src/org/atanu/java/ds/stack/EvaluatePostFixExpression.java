package org.atanu.java.ds.stack;

import java.util.Stack;

public class EvaluatePostFixExpression {


    public static int evaluatePostFixExpression(String exp) {

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (isNumeric(ch)) {
                stack.push(ch - '0'); // make it Integer
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                int result = performOperation(operand1, operand2, ch);
                stack.push(result);
            }


        }

        return stack.pop();
    }

    public static int performOperation(int a, int b, char operator) {

        if (operator == '+') {
            return (a + b);
        } else if (operator == '-') {
            return (a - b);
        } else if (operator == '*') {
            return (a * b);
        } else if (operator == '/') {
            return (a / b);
        } else {
            System.out.println("Are you kidding . Its just a simple Program");
            return -1;
        }
    }

    public static boolean isNumeric(char ch) {

        return Character.isDigit(ch);

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //System.out.println(isNumeric("-K908"));

        //String exp = "138*+";

        String exp = "231*+9-";

        System.out.println("PostFix Evalution is  " + evaluatePostFixExpression(exp));
    }

}
