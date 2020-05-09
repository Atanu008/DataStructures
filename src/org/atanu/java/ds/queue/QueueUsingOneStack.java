package org.atanu.java.ds.queue;

import java.util.Stack;

import org.atanu.java.ds.linkedlist.LinkedList;

public class QueueUsingOneStack {

	
	Stack<Integer> stack = new Stack<>();
	
	public void enQueue(int data)
	{
		stack.push(data);
	}
	
	public  int deQueue()
	{
		if(stack.isEmpty())
		{
			System.out.println("Queue is empty");
			System.exit(0);
		}
		
		int top = stack.pop();
		
		if(stack.isEmpty())
			return top;
		
		int retVal = deQueue();
			
		stack.push(top);
		
		return retVal;
		
	}
	public static void main(String[] args) {
	



		int[] keys = { 1, 2 , 3, 4};

		// insert above keys into the stack
		QueueUsingTwoStack queue = new QueueUsingTwoStack();
		for (int key : keys) {
			queue.enQueue(key);
		}
		
		for (int i = 0; i <= keys.length; i++) {
			System.out.println(queue.deQueue());
		}
		
		
	}

}
