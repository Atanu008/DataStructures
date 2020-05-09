package org.atanu.java.ds.stack;

import java.util.Stack;

public class StackProblem15 {

	
	public static String reverseStringSol1(String str) {
		
		int i = 0;
		int j = str.length() - 1;
		char[] chArray = str.toCharArray();
		
		while(i<j)
			swap(chArray , i++ , j--);
		
		return new String(chArray);
	}

	private static void swap(char[] chArray, int i, int j) {

		char temp = chArray[i];
		chArray[i] = chArray[j];
		chArray[j] = temp;
		
	}
	
	public static String reverseStringSol2(String str) {
		
		Stack<Character> stack = new Stack<>();
		
		int i = 0;
		int j = str.length();
		
		while(i<j)
		{
			stack.push(str.charAt(i++));
		}
		
		String reversed = "";
		
		while(!stack.isEmpty())
			reversed = reversed+stack.pop();
		
		return reversed;
	}

	public static void main(String[] args) {

		String str = "Madan Mit";
		//String reslut = reverseStringSol1(str);
		
		String reslut = reverseStringSol2(str);
		System.out.println(reslut);

	}

}
