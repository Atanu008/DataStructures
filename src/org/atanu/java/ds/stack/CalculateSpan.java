package org.atanu.java.ds.stack;

import java.util.Arrays;
import java.util.Stack;

public class CalculateSpan {

	private static void calculateSpan(int[] prices) {

		int span[] = new int[prices.length]; 

		// Create a stack and push index of first element 
		// to it 
		Stack<Integer> stack = new Stack();
		stack.push(0);


		// Span value of first element is always 1 
		span[0] = 1;

		// Pop elements from stack while stack is not 
		// empty and top of stack is smaller than 
		// price[i] 

		for (int i = 1; i < prices.length; i++) 
		{
			int cur = prices[i];

			// Pop elements from stack while stack is not 
			// empty and top of stack is smaller than 
			// price[i] 
			while(!stack.isEmpty() &&  prices[stack.peek()] <= cur)
			{
				stack.pop();
			}


			// If stack becomes empty, then price[i] is 
			// greater than all elements on left of it, i.e., 
			// price[0], price[1], ..price[i-1]. Else price[i] 
			// is greater than elements after top of stack 
			span[i] = stack.isEmpty() ? (i + 1 )  : (i - stack.peek());

			stack.push(i);

		}

		System.out.println(Arrays.toString(span));

	}


	public static void main(String[] args) {


		int prices[] = { 10, 4, 5, 90, 120, 80 }; 

		calculateSpan(prices); 

	}



}
