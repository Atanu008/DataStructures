package org.atanu.java.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;
import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class IntersectionPoint {

	
	public static Node getIntersectionPointSol1(Node head1 , Node head2)
	{
		Node node1 = head1;
		
		while(node1 != null)
		{
			Node node2 = head2; 
			while(node2 != null)
			{
				if(node1 == node2)
					return node1;
				node2 = node2.next;
			}
			node1 = node1.next;
		}
		return null;
	}
	
	public static Node getIntersectionPointSol2(Node head1 , Node head2)
	{
		Node node1 = head1;
		Node node2 = head2;
		Set<Node> set = new HashSet();
		
		while(node1 != null)
		{
			set.add(node1);
			node1 = node1.next;
		}
		
		while(node2 != null)
		{
			if(set.contains(node2))
				return node2;
			node2 = node2.next;
		}
		return null;
	}
	
	public static Node getIntersectionPointSol3(Node head1 , Node head2)
	{
		int count1 = getNodeCount(head1);
		int count2 = getNodeCount(head2);
		int extra = Math.abs(count1 - count2);
		
		if(count1 > count2)
			return getIntersectionPointSol3helper(extra, head1, head2);
		else
			return	getIntersectionPointSol3helper(extra, head2, head1);
		

	}
	
	public static Node getIntersectionPointSol3helper(int extra, Node head1 , Node head2)
	{
		Node current = head1;
		Node node = head2;

		for(int i =0; i<extra ; i++)
		{
			current = current.next;
		}
		
		while(current !=null && node !=null)
		{
			if(current == node)
				return current;
			current = current.next;
			node = node.next;
		}
		return null;
	}
	
	private static int getNodeCount(Node head)
	{
		Node node = head;
		int count = 0;
		
		while(node != null)
		{
			node = node.next;
			count++;
		}
		
		return count;
	}
	public static void main(String[] args) {


		LinkedList linkedList = new LinkedList();
		
		linkedList.head = linkedList.new Node(3);
		
		linkedList.head.next = linkedList.new Node(6);
		linkedList.head.next.next = linkedList.new Node(15);
		linkedList.head.next.next.next = linkedList.new Node(20);
		
		LinkedList secondlinkedList = new LinkedList();
		
		secondlinkedList.head = linkedList.new Node(1);
		
		secondlinkedList.head.next = linkedList.new Node(2);
		secondlinkedList.head.next.next = linkedList.head.next.next;
		secondlinkedList.head.next.next.next = linkedList.head.next.next.next;
		
		linkedList.printList(linkedList.head);
		System.out.println();
		linkedList.printList(secondlinkedList.head);
		System.out.println();
		
		System.out.println("The intersection point is "+ getIntersectionPointSol1(linkedList.head, secondlinkedList.head).data);
		System.out.println("The intersection point is "+ getIntersectionPointSol2(linkedList.head, secondlinkedList.head).data);
		System.out.println("The intersection point is "+ getIntersectionPointSol3(linkedList.head, secondlinkedList.head).data);


	}

}
