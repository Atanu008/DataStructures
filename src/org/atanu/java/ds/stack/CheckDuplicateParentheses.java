package org.atanu.java.ds.stack;

import java.util.Stack;

public class CheckDuplicateParentheses {


	public static boolean checkDuplicateParentheses(String exp)
	{
		Stack<Character> stack = new Stack();

		for(int i = 0; i < exp.length() ; i++)
		{
			char ch = exp.charAt(i);

			// if current char in the expression is a not a 
			// closing parenthesis
			if(ch != ')')
			{
				stack.push(ch);
			}
			// if current char in the expression is a closing parenthesis
			if(ch == ')')
			{
				// if we top element in the stack is an opening parenthesis,
				// the sub-expression of the form ((exp)) is found
				if(stack.peek() == '(')
				{
					return true;
				}

				// pop till '(' is found for current ')'
				while(stack.peek() != '(')
				{
					stack.pop();
				}

				// pop '('
				stack.pop();
			}
		}

		// if we reach here, then the expression does not have any
		// duplicate parenthesis
		return false;

	}


	public static void main(String[] args) {

		String exp = "((a+b))";

		boolean result = checkDuplicateParentheses(exp);

		System.out.println("Duplicate  "+ result);

	}

}
