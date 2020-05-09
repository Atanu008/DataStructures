package org.atanu.java.ds.stack;

import java.util.Stack;

public class StackProblem12 {

	
	public static void reverseStack(Stack<Integer> stack) {
		
		if(stack.isEmpty())
			return;
		
		int top = stack.pop();
		
		reverseStack(stack);
		
		insertAtBottom(stack, top);
		
	}
	
	public static void insertAtBottom(Stack<Integer> stack , int data) {
		
		//System.out.println(data);
		if(stack.isEmpty())
		{
			stack.push(data);
			return;
		}
		
		//System.out.println("hewfhewkf");
		int topItem = stack.pop();
		
		insertAtBottom(stack, data);
		
		stack.push(topItem);
	}
	public static void main(String[] args) {
		

		Stack<Integer> stack = new Stack<>();
		
		stack.push(600);
		stack.push(500);
		stack.push(400);
		stack.push(100);
		
		System.out.println("Original Stack");
		while(!stack.isEmpty())
			System.out.print(stack.pop() +" ");
		
		//Pushing again to fillup the stack
		stack.push(600);
		stack.push(500);
		stack.push(400);
		stack.push(100);
		
		reverseStack(stack);
		
		System.out.println("\nReverse Stack");
		while(!stack.isEmpty())
			System.out.print(stack.pop() +" ");

	}

}
