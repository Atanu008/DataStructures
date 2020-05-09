package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class RemoveDuplicateThree {

	private static Node removeDuplicateMethod1(Node head) {

		Node dummy = new LinkedList().new Node();
		dummy.next = head;
		Node prev = dummy;
		Node current = head;

		while(current !=null)
		{
			while(prev.next != null && current.next != null && prev.next.data == current.next.data)
			{
				current = current.next;
			}

			//Current Has not moved . Next to current is different element
			//Just move the prev Pointer
			if(prev.next == current)
			{
				prev = prev.next;
			}
			else
			{
				prev.next = current.next;
			}
			
			current = current.next;
		}
		
		return dummy.next;
				
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

		Node changedHead = removeDuplicateMethod1(linkedList.head);
		System.out.println();
		linkedList.printList(changedHead);

	}



}
