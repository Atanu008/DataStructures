package org.atanu.java.ds.stack;

import java.util.Stack;

public class StackProblem11 {

	public static int findMinInversionsSol1(String exp) {
		
		int length = exp.length();
		
		if(length%2 == 1)
			return Integer.MAX_VALUE;
		
		int count = 0;
		int inversions = 0;
		
		
		for(int i = 0 ; i< exp.length() ; i++) 
		{
		
			char ch = exp.charAt(i);
			
			if(ch == '{') 
			{
				++count;
			}
			else if(ch == '}') 
			{
				if(count > 0)
				{
					count = count -1;
				}
				else
				{
					++inversions;
					count = 1;
				}
			}
			
		}
		
		return inversions + count/2;
	}
	
	public static int findMinInversionsSol2(String exp) {
		
		int length = exp.length();
		
		if(length%2 == 1)
			return Integer.MAX_VALUE;
		
		int firstBarcCount = 0;
		int secBarcCount = 0;
		
		Stack<Character> stack = new Stack<>();
		
		
		for(int i = 0 ; i< exp.length() ; i++) 
		{
		
			char ch = exp.charAt(i);
			
			if(ch == '{')
			{
				stack.push(ch);
			}
			
			else if(ch == '}')
			{
				if(stack.peek() == '{')
				{
					stack.pop();
				}
				
				else
				{
					stack.push(ch);
				}
			}
				
			
		}
		
		int totalStackSize = stack.size();
		
	//	stack.forEach((ch) -> { if(ch == '{') firstBarcCount ++ ;}); Not possible for Lambda restrictions
		
		while(!stack.isEmpty())
		{
			if(stack.pop() =='{')
				firstBarcCount++;
		}
		
		System.out.println();
		secBarcCount = totalStackSize - firstBarcCount;
		
		return (firstBarcCount/2 + secBarcCount/2);
	}
	
	public static void main(String[] args) {
		
		//String exp = "{{}{{}{{";
		
		String exp = "{{}{}{{}";

		int inv = findMinInversionsSol2(exp);

		if (inv != Integer.MAX_VALUE) {
			System.out.print("Minimum number of inversions needed is " + inv);
		}
		else {
			System.out.print("Invalid input");
		}
	}

}
