package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class ReOrder {

	public static Node reOrder(Node head) {

		Node fastPointer = head;
		Node slowPointer = head;

		while(fastPointer != null && fastPointer.next != null)
		{
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		Node head1 = head;
		Node head2 = slowPointer.next;

		// Reverse second half
		
		head2 = reverseList(head2, null);
		slowPointer.next = null;

		Node dummy = new LinkedList().new Node();

		Node tail = dummy;

		while(head1 != null || head2 != null)
		{
			if(head1 != null)
			{
				tail.next = head1;
				tail = tail.next;
				head1 = head1.next;

			}
			
			if(head2 != null)
			{
				tail.next = head2;
				tail = tail.next;
				head2 = head2.next;

			}
		}
		
		return dummy.next;

	}
	
	public static Node reverseList(Node current ,Node previous)
	{
		Node head;
		
		if(current.next == null)
		{
			head = current;
			current.next = previous;
			
			return head;
		}
		
		Node next = current.next;
		current.next = previous;
		
		return reverseList(next,current);
	}

	public static void main(String[] args) {

		LinkedList linkedListA = new LinkedList();

		linkedListA.push(1);
		linkedListA.append(2);
		linkedListA.append(3);
		linkedListA.append(4);
		linkedListA.append(5);
		linkedListA.append(6);
		
		Node changedHead = reOrder(linkedListA.head);
		
		LinkedList.printList(changedHead);
	}

}
