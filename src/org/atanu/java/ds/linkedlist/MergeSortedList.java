package org.atanu.java.ds.linkedlist;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class MergeSortedList {

	
	public static Node mergeIter(Node a , Node b) {
		
		Node dummy = new LinkedList().new Node();
		Node tail = dummy;
		
		while(true)
		{

			if(a == null)
			{
				tail.next = b;
				break;
			}
			
			if(b == null)
			{
				tail.next = a;
				break;
			}
			
			else if(a.data < b.data)
			{
				
				Node newNode = a;
				a = a.next;
				
				newNode.next = null;
				tail.next = newNode;
				
			}
			else
			{
				Node newNode = b;
				b = b.next;
				
				newNode.next = null;
				tail.next = newNode;
				
				
			}
			
			tail = tail.next; // Move tail to last
		}
		
		return dummy.next;
		
	}
	
	public static Node mergeRec(Node a , Node b) {
		
		if(a == null)
			return b;
		if(b == null)
			return a;
		
		Node result;
		if(a.data < b.data)
		{
			result = a;
			result.next = mergeRec(a.next,b);
		}
		else
		{
			result = b;
			result.next = mergeRec(a,b.next);
		}
		
		return result;
	}
	public static void main(String[] args) {
		

		LinkedList linkedListA = new LinkedList();

		linkedListA.push(1);
		linkedListA.append(8);
		linkedListA.append(9);

		System.out.println("First List");
		LinkedList.printList(linkedListA.head);
		
		LinkedList linkedListB = new LinkedList();
		
		linkedListB.push(4);
		linkedListB.append(5);
		linkedListB.append(6);
		linkedListB.append(7);
		//linkedListB.append();
		
		
		System.out.println("\nSecond List");
		LinkedList.printList(linkedListB.head);
		
	//	Node mergedList = mergeIter(linkedListA.head, linkedListB.head);
		//System.out.println("\nMerged List");
		//LinkedList.printList(mergedList);
		
		Node mergedList = mergeRec(linkedListA.head, linkedListB.head);
		System.out.println("\nMerged List");
		LinkedList.printList(mergedList);
	}

}
