package org.atanu.java.ds.queue;

import java.util.Stack;

public class QueueUsingTwoStack2 {

	Stack<Integer> original = new Stack<>();
	Stack<Integer> aux = new Stack<>();

	public void enQueue(int data)
	{
		original.push(data);
	}

	public  int deQueue()
	{
		if(original.isEmpty() && aux.isEmpty())
		{
			System.out.println("Queue is empty");
			System.exit(0);
		}

		// if second stack is empty, move elements from first stack to Aux
		if(aux.isEmpty())
		{
			while(!original.isEmpty())
			{
				aux.push(original.pop());
			}
		}

		// return the top item from the second stack
		return aux.pop();

		//return original.pop();
	}

	public static void main(String[] args) {



		int[] keys = { 1, 2 };

		// insert above keys into the stack
		QueueUsingTwoStack2 queue = new QueueUsingTwoStack2();
		for (int key : keys) {
			queue.enQueue(key);
		}

		for (int i = 0; i <= keys.length; i++) {
			System.out.println(queue.deQueue());
		}
	}

}
