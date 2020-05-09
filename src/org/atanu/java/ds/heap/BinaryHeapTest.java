package org.atanu.java.ds.heap;

public class BinaryHeapTest {

	public static void main(String[] args) {
		
		Integer[] array = { 3, 15, 7, 51, 99, 200, 4, 25, 989, 1, 29 };

		BinaryHeap<Integer> minHeap = new BinaryHeap<Integer>(Integer.class , array);
		
		System.out.println("Min Heap get Highest Priority Elem : " + minHeap.getHighestPriorityElement());
		
		minHeap.insert(0);
		System.out.println("Min elem after inserting Zero : " + minHeap.getHighestPriorityElement());
		
		System.out.println("Removing min element "+ minHeap.getHighestPriorityElement());
		minHeap.removeHighestPriorityElement();
		System.out.println("After Removing highest prio element : " + minHeap.getHighestPriorityElement());
		
		System.out.println("Printing Min Heap "+ minHeap.toString());
		
		
		
		BinaryHeap<Integer> maxHeap = new BinaryHeap<Integer>(Integer.class , array ,30, false);
		
		System.out.println("Max Heap get Highest Priority Elem : " + maxHeap.getHighestPriorityElement());
	
		maxHeap.insert(5000);
		System.out.println("Maximum elem after inserting 5000 : " + maxHeap.getHighestPriorityElement());
		
		System.out.println("Removing highest prio element :" + maxHeap.getHighestPriorityElement());
		maxHeap.removeHighestPriorityElement();
		
		System.out.println("After Removing highest prio element : " + maxHeap.getHighestPriorityElement());
		
		
		System.out.println("Printing Max Heap "+ maxHeap.toString());
		
		int x = -5/2;
		//System.out.println(x);
		
		
		
	}

}
