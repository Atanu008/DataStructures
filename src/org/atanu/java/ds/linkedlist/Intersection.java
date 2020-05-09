package org.atanu.java.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class Intersection {

	public static Node getIntersectionSol1(Node head1, Node head2)
	{
		LinkedList intersection = new LinkedList();
		
		Set<Integer> set = new HashSet<>();
		
		while(head1 != null)
		{
			set.add(head1.data);
			head1 = head1.next;
		}
		
		while(head2 != null)
		{
			if(set.contains(head2.data))
			{
				intersection.append(head2.data);
			}
			head2 = head2.next;
		}
		
		return intersection.head;
	}
	
	public static Node getIntersectionSol2(Node head1, Node head2)
	{
		LinkedList intersection = new LinkedList();
		
		
		while(head1 != null)
		{
			if(isPresent(head1.data, head2))
			{
				intersection.append(head1.data);
			}
			head1 = head1.next;
		}
		
		
		return intersection.head;
	}
	
	
	public static Node getUnionSol1(Node head1, Node head2)
	{
		LinkedList union = new LinkedList();
		
		Set<Integer> set = new HashSet<>();
		
		while(head1 != null)
		{
			set.add(head1.data);
			head1 = head1.next;
		}
		
		while(head2 != null)
		{
			set.add(head2.data);
			head2 = head2.next;
		}
		
		set.forEach(p -> union.append(p));
		
		return union.head;
		
	}
	
	public static Node getUnionSol2(Node head1, Node head2)
	{
		LinkedList intersection = new LinkedList();
		Node temp = head1;
		
		while(head1 != null)
		{
			intersection.append(head1.data);
			head1 = head1.next;
		}
		
		while(head2 != null)
		{
			if(!isPresent(head2.data, temp))
			{
				intersection.append(head2.data);
			}
			head2 = head2.next;
		}
		
		
		return intersection.head;
		
	}
	
	public static boolean isPresent(int key , Node head)
	{
		while(head != null && head.data != key)
		{
			head = head.next;
		}
		if(head == null)
			return false;
		
		return true;
	}
	public static void main(String[] args) {


		LinkedList linkedListA = new LinkedList();

		linkedListA.push(1);
		linkedListA.append(9);
		linkedListA.append(7);
		linkedListA.append(8);
		linkedListA.append(6);
		linkedListA.append(4);
		
		LinkedList linkedListB = new LinkedList();
		
		linkedListB.push(1);
		linkedListB.append(9);
		linkedListB.append(7);
		linkedListB.append(5);
		linkedListB.append(3);
		
		System.out.println("First List");
		LinkedList.printList(linkedListA.head);
		System.out.println("\nSecond List");
		LinkedList.printList(linkedListB.head);
		
		Node intersection = getIntersectionSol2(linkedListA.head, linkedListB.head);
		
		System.out.println("\nIntersection");
		LinkedList.printList(intersection);
		
		Node union = getUnionSol2(linkedListA.head, linkedListB.head);
		
		System.out.println("\nUnion");
		LinkedList.printList(union);
	}

}
