package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class NthNodeFromLast {

	public static  void printNthFromLastSol1(int n , Node head) 
	{ 
		int len = 0; 
		Node temp = head; 

		// 1) count the number of nodes in Linked List 
		while (temp != null) 
		{ 
			temp = temp.next; 
			len++; 
		} 

		// check if value of n is not more than length of 
		// the linked list 
		if (len < n) 
			return; 

		temp = head; 

		// 2) get the (len-n+1)th node from the begining 

		for (int i = 1; i < len-n+1; i++) 
		{
			temp = temp.next; 
		}
		System.out.println("\nThe Nth element is [" + 
				temp.data + "] \n"); 
	} 

	public static  void printNthFromLastSol2(int n , Node head) 
	{ 
		Node ref_ptr = head; 

		if (head != null) 
		{
			for(int i = 1; i < n; i++)
			{
				ref_ptr = ref_ptr.next;
			}

			Node temp = head; 
			
			while(ref_ptr.next != null) 
			{
				temp = temp.next; 
				ref_ptr = ref_ptr.next;
			}
			System.out.println("\nThe Nth element is [" + 
					temp.data + "] \n"); 
		}
	}

	

	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();
		//linkedList.push(3);
		for(int i = 10 ; i >0 ; i--) 
		{
			linkedList.push(i);
		}


		linkedList.printList(linkedList.head);
		printNthFromLastSol1(2,linkedList.head);
		printNthFromLastSol2(2,linkedList.head);

	}



}
