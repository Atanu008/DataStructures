package org.atanu.java.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;
import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class DetectCycle {

	public static boolean detectCycleMethod1(Node head){

		Set<Node> set = new HashSet();
		Node node = head;
		while(node !=null)
		{
			if(set.contains(node))
			{
				return true;
			}

			set.add(node);
			node = node.next;

		}	
		return false;
	}

	//Floyd�s Cycle detection algorithm
	public static boolean detectCycleMethod2(Node head){
	
		Node slowPoniter = head;
		Node fastPointer = head;
		
		while(fastPointer !=null && fastPointer.next != null)
		{
			slowPoniter = slowPoniter.next;
			fastPointer = fastPointer.next.next;
			
			if(slowPoniter == fastPointer)
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {

		Node head = null;
		LinkedList linkedList = new LinkedList();

		for(int i = 5 ; i>0 ; i--) 
		{
			head = linkedList.new Node(i,head);
		}

		linkedList.printList(head);
		head.next.next.next.next.next = head.next.next;
		System.out.println(detectCycleMethod1(head));
		//linkedList.printList(head);
	}

}
