package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class LeftRotate {

	public static Node leftRotate(Node head , int k){
		
		int count = 1;
		Node current = head;
		
		while(count < k && current != null)
		{
			current  = current.next;
			count++;
		}
		
		if(current == null)
			return null;
		
		Node kthNode = current;
		System.out.println("  Kth "+ kthNode.data);
		
		while(current != null && current.next != null)
		{
			current = current.next;
		}
		
		
		current.next  = head;
		head = kthNode.next;
		kthNode.next = null;
		
		return head;
	}
	
	public static void main(String[] args) {

		LinkedList linkedListA = new LinkedList();

		linkedListA.push(1);
		linkedListA.append(2);
		linkedListA.append(3);
		linkedListA.append(4);
		linkedListA.append(5);
		linkedListA.append(6);
		
		LinkedList.printList(linkedListA.head);
		Node changedHead = leftRotate(linkedListA.head, 2);
		//System.out.println("dgqwegdfkw" + changedHead);
		LinkedList.printList(changedHead);

	}

}
