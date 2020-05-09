package org.atanu.java.ds.stack;

import java.util.Stack;

public class NextMinimum {

	
	public static void getNextMinimum(int[] array) {
		
		Stack<Integer> stack = new Stack();
		
		int[] nse = new int[array.length];
		
		for (int i = array.length -1 ; i >= 0; i--) 
		{
			
			while(!stack.isEmpty() && array[i] < stack.peek() )
				stack.pop();
			
			nse[i] = stack.isEmpty() ? -1 : stack.peek();
			
			stack.push(array[i]);
		}
		
		for (int i = 0; i < array.length; i++) {
			
			System.out.println("Smallest of "+ array[i] +"  "+ nse[i]);
		}
	}
	public static void main(String[] args) {

		int input[] = { 10, 4, 5, 90, 120, 80 }; 
		
		getNextMinimum(input);

	}

}
