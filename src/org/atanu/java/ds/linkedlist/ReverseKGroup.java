package org.atanu.java.ds.linkedlist;

import java.util.Stack;

import org.atanu.java.ds.linkedlist.LinkedList.Node;


/**
 * @author Atanu
 *Reverse every group of K nodes in Linked List
 */
public class ReverseKGroup {

	// Function to reverse every group of k nodes in given linked list
	public static Node reverseKGroupMethod1(Node head, int k)
	{
		// base case
		if (head == null) {
			return null;
		}

		// start with current node
		Node current = head;

		// reverse next k nodes
		Node prev = null;
		int count = 0;

		// Iterate through the list and move/insert each node to the
		// front of the result list (like a push of the node)
		while (current != null && count++ < k)
		{
			// tricky: note the next node
			Node next = current.next;

			// move the current node onto the result
			current.next = prev;

			// update previous to current node
			prev = current;

			// move to next node in the list
			current = next;
		}

		// recurse for remaining nodes
		head.next = reverseKGroupMethod1(current, k);

		// important - return previous (to link every group of k nodes)
		return prev;
	}


	public static Node reverseKGroupMethod2(Node head, int k){
		
		Node current = head;
		Node prev = null;
		Stack<Node> stack = new Stack();
		
		while(current != null)
		{
			int count = 0;

			while(current != null && count < k)
			{
				stack.push(current);
				current = current.next;
				count++;
			}
			
			while(!stack.isEmpty())
			{
				if(prev == null)
				{
					prev = stack.peek();
					head = prev;
					stack.pop();
				}
				else
				{
					prev.next = stack.pop();
					prev = prev.next;
				}
			}
		}
		prev.next = null;
		return head;
	}
	public static void main(String[] args) {


		LinkedList linkedList = new LinkedList();

		linkedList.push(1);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.append(4);
		linkedList.append(5);
		linkedList.append(6);
		linkedList.append(7);
		linkedList.append(8);

		linkedList.printList(linkedList.head);

		//Node changedHead = reverseKGroupMethod1(linkedList.head, 3);
		
		Node changedHead = reverseKGroupMethod2(linkedList.head, 3);
		System.out.println();
		linkedList.printList(changedHead);

		//Node head = reverseInGroups(linkedList.head, 3);
		//linkedList.printList(head);
	}



}
