package org.atanu.java.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;
import org.atanu.java.ds.linkedlist.LinkedList.Node;
public class FirstLoopNode {

	public static Node getFirstLoopNodeMethod1(Node head)
	{
		Set<Node> set = new HashSet();
		
		Node node = head;
		
		while(node != null)
		{
			if(set.contains(node))
			{
				return node;
			}
			
			set.add(node);
			node = node.next;
		}
		
		return null;
	}
	
	
	public static Node getFirstLoopNodeMethod2(Node head)
	{
		
		Node fastPointer = head;
		Node slowPointer = head;
		Node startPointer = head;
		
		while(fastPointer != null && fastPointer.next != null)
		{
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			
			
			if(slowPointer == fastPointer)
			{
				//System.out.println(startPointer.data);
				while(true)
				{
					fastPointer = slowPointer;
					while(fastPointer.next != slowPointer && fastPointer.next != startPointer)
					{
						fastPointer = fastPointer.next;
					}
					
					if(fastPointer.next == startPointer )
						return startPointer;
					
					startPointer = startPointer.next;
				}
			}
		}
		
		return null;
	}
	
	
	public static Node getFirstLoopNodeMethod3(Node head)
	{
		
		Node fastPointer = head;
		Node slowPointer = head;
		
		Node pointer1 = head;
		Node pointer2 = head;
		while(fastPointer != null && fastPointer.next != null)
		{
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			
			if(slowPointer == fastPointer)
			{
				int nodeCount = 1;
				while(fastPointer.next != slowPointer)
				{
					nodeCount++;
					fastPointer = fastPointer.next;
				}
				
				for(int i = 0; i< nodeCount; i++)
				{
					pointer1 = pointer1.next;
				}
				
				while(pointer1 != pointer2)
				{
					pointer1 = pointer1.next;
					pointer2 = pointer2.next;
				}
				
				return pointer1;
			}
		}
		
		return null;
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
		//System.out.println(detectAndRemoveLoopMethod1(head));
		//System.out.println(detectAndRemoveLoopMethod2(head));
		
		System.out.println("\nStart of the loop "+getFirstLoopNodeMethod1(head).data);

		System.out.println("\nStart of the loop "+getFirstLoopNodeMethod2(head).data);
		
		System.out.println("\nStart of the loop "+getFirstLoopNodeMethod3(head).data);
	}

}
