package org.atanu.java.ds.linkedlist;

import java.util.Stack;
import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class Palindrome {

	static Node leftNode;

	public static boolean checkPalindromeRecMethod1(Node right) {


		if(right == null)
			return true;

		boolean interMedCheck = checkPalindromeRecMethod1(right.next);

		if(!interMedCheck)
			return false;

		boolean isPalindrome = (right.data == leftNode.data);

		leftNode = leftNode.next;

		return isPalindrome;
	}

	public static boolean checkPalindromeMethod2(Node head) {

		Stack<Node> stack = new Stack();
		Node temp = head;

		while(temp != null)
		{
			stack.push(temp);
			temp = temp.next;
		}

		temp = head;

		while(temp != null)
		{
			Node stackItem = stack.pop();

			if(stackItem.data != temp.data)
				return false;
			temp = temp.next;
		}


		return true;
	}

	public static boolean checkPalindromeMethod3(Node head) {

		Node MidNode = null;
		Node fastPointer = head; Node slowPointer = head;
		Node previous = null;
		boolean res = false;
		boolean oddNode = false;

		while(fastPointer != null && fastPointer.next != null)
		{
			fastPointer = fastPointer.next.next;
			previous = slowPointer;
			slowPointer = slowPointer.next;
		}


		/* fast_ptr would become NULL when there are even elements  
        in the list and not NULL for odd elements. We need to skip   
        the middle node for odd case and store it somewhere so that 
        we can restore the original list */

		if(fastPointer != null)
		{
			MidNode = slowPointer;		
			slowPointer = slowPointer.next;
			oddNode = true;
		}

		Node secondHalf = slowPointer;
		previous.next = null;
		Node newReverseHead =reverse(secondHalf);

		res = compareList(head ,newReverseHead);

		secondHalf = reverse(newReverseHead);

		if(oddNode)
		{
			previous.next = MidNode;
			MidNode.next = secondHalf;

		}
		else
		{
			previous.next = secondHalf;
		}

		LinkedList linkedList = new LinkedList();
		System.out.println("\nOriginal List Restored");
		linkedList.printList(head);
		return res;
	}

	private static boolean compareList(Node head, Node secondHalf) {

		Node temp1 = head;
		Node temp2 = secondHalf;

		while(temp1!= null && temp2!= null)
		{
			if(temp1.data != temp2.data)
				return false;

			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		/* Both are empty reurn 1*/
		if (temp1 == null && temp2 == null) 
			return true;

		return true;
	}

	public static Node reverse(Node head) { 
		Node prev = null; 
		Node current = head; 
		Node next = null; 
		while (current != null) { 
			next = current.next; 
			current.next = prev; 
			prev = current; 
			current = next; 
		} 
		head = prev; 
		return head; 
	} 
	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();
		linkedList.push(2);
		linkedList.push(1);
		linkedList.push(3);
		linkedList.push(5);
		linkedList.push(3);
		linkedList.push(1);
		linkedList.push(2);

		leftNode = linkedList.head;

		linkedList.printList(linkedList.head);
		//boolean isPalindrome = checkPalindromeRecMethod1(linkedList.head);

		//boolean isPalindrome = checkPalindromeMethod2(linkedList.head);

		boolean isPalindrome = checkPalindromeMethod3(linkedList.head);
		System.out.println("\n"+isPalindrome);
	}

}
