package org.atanu.java.ds.stack;

import java.util.Stack;

public class StackProblem13 {
	
	public static boolean checkPalindrome(String str) {
		
		
		if(str== null)
			return false;
		
		Stack<Character> stack = new Stack<>();
		
		int n = str.length();
		int i = 0;
		
		while(i < n)
		{
			stack.push(str.charAt(i++));
		}
		
		
		String reversedString = "";
		
		while(!stack.isEmpty())
			reversedString = reversedString+stack.pop();
		
		if(str.equals(reversedString))
			return true;
		
		return false;
		
	}

	public static void main(String[] args) {
		
		String str = "MADAM";
		boolean result = checkPalindrome(str);
		System.out.println(str +" is Palindrome "+ result);
		
		
		
	}
}
