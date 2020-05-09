package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class RightRotate {

	public static Node rightRotate(Node head , int k){
		
		Node current = head;
		int length = getLength(head);
		
		k = k % length;
		
		int noOfLeftElem = length - k;
		int i = 1;
		while(current != null && i < noOfLeftElem )
		{
			current = current.next;
			i++;
		}
		
		if(current == null)
			return null;
					
		Node nthNode = current;
		
		while(current != null && current.next != null)
		{
			current = current.next;
		}
		
		current.next = head;
		head = nthNode.next;
		nthNode.next = null;
		
		return head;
	}
	
	public static int getLength(Node node) {
		
		if(node == null)
			return 0;
		
		return 1 + getLength(node.next);
	}
	public static void main(String[] args) {
		
		LinkedList linkedListA = new LinkedList();

		linkedListA.push(1);
		linkedListA.append(2);
		linkedListA.append(3);
		linkedListA.append(4);
		linkedListA.append(5);
		linkedListA.append(6);
		
		Node changedHead = rightRotate(linkedListA.head, 2);
		LinkedList.printList(changedHead);

	}

}
