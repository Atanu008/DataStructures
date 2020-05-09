package org.atanu.java.ds.linkedlist;

import java.math.BigInteger;

import org.atanu.java.ds.linkedlist.LinkedList.Node;

public class MultiplyList {

	public static long multiplylist(Node first , Node second) {
		
		long firstNum = 0;
		long secondNum = 0;
		
		while(first != null)
		{
			firstNum = firstNum*10 + first.data;
			first = first.next;
		}
		
		while(second != null)
		{
			secondNum = secondNum*10 + second.data;
			second = second.next;
		}
		
		return firstNum*secondNum;
		
	}
	public static void main(String[] args) {


		LinkedList linkedListA = new LinkedList();

		linkedListA.push(2);
		linkedListA.append(0);
		linkedListA.append(0);
		
		LinkedList linkedListB = new LinkedList();
		
		linkedListB.push(2);
		linkedListB.append(5);
		linkedListB.append(0);
		
		System.out.println("Multiplication = "+ multiplylist(linkedListA.head, linkedListB.head));
	}

}
