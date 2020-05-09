package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class DeleteMidElement {

	
	public static void deleteMidElementSol1(Node head){
		
		int len = 0;
		
		Node temp = head;
		
		while(temp != null)
		{
			len++;
			temp= temp.next;
		}
		
		temp = head;
		for(int i = 1; i< len/2 ; i++)
		{
			temp = temp.next;
		}
		
		temp.next = temp.next.next;
		
	}
	
	public static void deleteMidElementSol2(Node head){
		
		Node fast_ptr = head;
		Node slow_ptr = head;
		Node prev = null;
		
		while(fast_ptr != null && fast_ptr.next != null)
		{
			fast_ptr = fast_ptr.next.next;
			prev = slow_ptr;
			slow_ptr = slow_ptr.next;
		}
		
		prev.next = slow_ptr.next;
		
	}
	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();
		//linkedList.push(3);
		for(int i = 6 ; i >0 ; i--) 
		{
			linkedList.push(i);
		}
		linkedList.printList(linkedList.head);
		deleteMidElementSol1(linkedList.head);
		//deleteMidElementSol2(linkedList.head);
		System.out.println();
		linkedList.printList(linkedList.head);
	}

}
