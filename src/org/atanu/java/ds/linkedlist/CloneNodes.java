package org.atanu.java.ds.linkedlist;

import java.util.HashMap;

public class CloneNodes {

	// Structure of linked list Node  
	static class RandomNode  
	{  
	    int data;  
	    RandomNode next,random;  
	    RandomNode(int x)  
	    {  
	        data = x; 
	        next = random = null;
	    } 
	}
	
	private static RandomNode clone(RandomNode head) {
	
		RandomNode start = head;
		
		HashMap<RandomNode, RandomNode> map = new HashMap<>();
		
		while(start != null)
		{
			RandomNode clonedNode = new RandomNode(start.data);
			
			map.put(start, clonedNode);
			
			start = start.next;
		}
		
		start = head;
		while(start != null)
		{
			RandomNode clonedNode = map.get(start);
			clonedNode.next = map.get(start.next);
			clonedNode.random = map.get(start.random);
			start = start.next;
		}
		return map.get(head);
	}
	
	// Utility function to print the list.  
	static void print(RandomNode start)  
	{  
		RandomNode ptr = start;  
	    while (ptr != null)  
	    {  
	        System.out.println("Data = " + ptr.data + 
	                    ", Random = "+ptr.random.data);  
	        ptr = ptr.next;  
	    }  
	}  
	
	
	public static void main(String[] args) {

		RandomNode start = new RandomNode(1);  
	    start.next = new RandomNode(2);  
	    start.next.next = new RandomNode(3);  
	    start.next.next.next = new RandomNode(4);  
	    start.next.next.next.next = new RandomNode(5);  
	  
	    // 1's random points to 3  
	    start.random = start.next.next;  
	  
	    // 2's random points to 1  
	    start.next.random = start;  
	  
	    // 3's and 4's random points to 5  
	    start.next.next.random = start.next.next.next.next;  
	    start.next.next.next.random = start.next.next.next.next;  
	  
	    // 5's random points to 2  
	    start.next.next.next.next.random = start.next;  
	  
	    System.out.println("Original list : ");  
	    print(start);  
	  
	    System.out.println("Cloned list : ");  
	    RandomNode cloned_list = clone(start);  
	    print(cloned_list);  

	}




}
