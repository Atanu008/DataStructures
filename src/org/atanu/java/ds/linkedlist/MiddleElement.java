package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class MiddleElement {

	public static void findMidElementSol1(Node head)
	{

		Node fast_ptr = head; // Node fast_ptr = head.next;
		Node slow_ptr = head;

		while(fast_ptr != null && fast_ptr.next != null)
		{
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
		}

		System.out.println("\nThe middle element is [" + 
				slow_ptr.data + "]"); 
	}


	public static void findMidElementSol2(Node head)
	{

		Node node = head;
		Node mid = head;

		int count = 0;

		while(node != null)
		{
			/* update mid, when 'count' is odd number */
			if(count%2 != 0)
				mid = mid.next;

			node = node.next;
			++count;
		}

		System.out.println("The middle element is [" + 
				mid.data + "] \n"); 
	}

	 static   int getMiddle(Node h) 
	    { 
	        // Base case 
	        if (h == null) 
	            return h.data; 
	        Node fast_ptr = h.next; 
	        Node slow_ptr = h; 
	  
	        // Move fastptr by two and slow ptr by one 
	        // Finally slowptr will point to middle node 
			while(fast_ptr != null && fast_ptr.next != null)
			{
				fast_ptr = fast_ptr.next.next;
				slow_ptr = slow_ptr.next;
			}
	        System.out.println(slow_ptr.data);
			return 0; 
	    } 
	
	public static void main(String[] args) {


		LinkedList linkedList = new LinkedList();
		//linkedList.push(3);
		for(int i = 6 ; i >0 ; i--) 
		{
			linkedList.push(i);
		}


		linkedList.printList(linkedList.head);

		findMidElementSol1(linkedList.head);
		findMidElementSol2(linkedList.head);
		getMiddle(linkedList.head);

	}
}
