package org.atanu.java.ds.stack;

import java.util.Stack;

public class FindCelebrity {

	   // Person with 2 is celebrity 
    static int MATRIX[][] = { { 0, 0, 1, 0 }, 
                            { 0, 0, 1, 0 }, 
                            { 0, 0, 0, 0 },  
                            { 0, 0, 1, 0 } }; 
  
    // Returns true if a knows  
    // b, false otherwise 
    static boolean knows(int a, int b)  
    { 
        boolean res = (MATRIX[a][b] == 1) ?  
                                     true :  
                                     false; 
        return res; 
    } 
  
    // Returns -1 if celebrity  
    // is not present. If present, 
    // returns id (value from 0 to n-1). 
    static int findCelebrity(int n)  
    { 
    	
    	Stack<Integer> stack = new Stack();
    	
    	for(int i = 0; i < n ; i++)
    	{
    		stack.push(i);
    	}
    	
    	while(stack.size() > 1)
    	{
    		int a = stack.pop();
    		int b = stack.pop();
    		
    		if(knows(a, b))
    		{
    			stack.push(b);
    		}
    		else
    		{
    			stack.push(a);
    		}
    		
    	}
    	
    	int c = stack.pop();
    	
    	for(int i = 0 ; i< n ;i++)
    	{
    		if( i != c && ( knows(c, i) || !knows(i, c) ))
    			return -1; 
    	}
    	return c;
    }
	public static void main(String[] args) {
		
		int n = 4; 
        int result = findCelebrity(n); 
        if (result == -1)  
        { 
            System.out.println("No Celebrity"); 
        }  
        else
            System.out.println("Celebrity ID " +  
                                        result); 

	}

}
