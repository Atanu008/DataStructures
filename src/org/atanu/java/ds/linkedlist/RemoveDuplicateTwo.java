package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class RemoveDuplicateTwo {

	public static void removeDuplicateMethod(Node head) {
		
		Node current = head;
		
		while(current!= null && current.next != null)
		{
			if(current.data == current.next.data)
			{
				current.next = current.next.next;
			}
			else
			{
				current = current.next;
			}
			
		}
	}
	
	public static void main(String[] args) {


		LinkedList linkedList = new LinkedList();
		
		linkedList.push(1);
		linkedList.append(2);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.append(3);
		linkedList.append(4);
		linkedList.append(4);

		linkedList.printList(linkedList.head);
		removeDuplicateMethod(linkedList.head);
		System.out.println();
		linkedList.printList(linkedList.head);
		
	}

}
