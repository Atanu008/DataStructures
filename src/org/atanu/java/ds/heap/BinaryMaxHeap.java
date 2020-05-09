package org.atanu.java.ds.heap;

public class BinaryMaxHeap {

	private int count;
	int[] heap;
	int size;
	
	public BinaryMaxHeap(int size)
	{
		heap = new int[size];
	}
	
	public boolean insert(int data) {
		
		heap[count] = data;
		
		heapifyUp(count);
		count++;
		
		return true;
	}
	
	public int remove()
	{
		int retVal = heap[0];
		heap[0] = heap[count -1];
		heap[count - 1] = 0;
		count--;
		
		heapifyDown(0);
		return retVal;
		
	}
	private void heapifyDown(int index) {
		
		int leftIndex = index*2 + 1;
		int rightIndex = index*2 +2;
		
		int largest = index;
		if(leftIndex < count && heap[leftIndex] > heap[largest])
			largest = leftIndex;
		
		if(rightIndex < count && heap[rightIndex] > heap[largest])
			largest = rightIndex;
		
		if(largest != index)
		{
			int swap = heap[index];
			heap[index] = heap[largest];
			heap[largest] = swap;
			
			heapifyDown(largest);
		}
		
	}

	private void heapifyUp(int index) {
		
		int parentIndex = (index -1 )/2;
		
		if(parentIndex >= 0 && parentIndex < count && heap[parentIndex] < heap[index])
		{
			int swap = heap[index];
			heap[index] = heap[parentIndex];
			heap[parentIndex] = swap;
			
			heapifyUp(parentIndex);
		}
		
	}

	public static void main(String[] args) {
		
		BinaryMaxHeap binaryMaxHeap = new BinaryMaxHeap(10);
		
		binaryMaxHeap.insert(3);
		binaryMaxHeap.insert(5);
		binaryMaxHeap.insert(1);
		binaryMaxHeap.insert(9);
		binaryMaxHeap.insert(8);
		
		System.out.println("Max "+binaryMaxHeap.heap[0]);
		System.out.println("Removig Max "+binaryMaxHeap.remove());
		System.out.println("New Max "+binaryMaxHeap.heap[0]);
		
	}

}
