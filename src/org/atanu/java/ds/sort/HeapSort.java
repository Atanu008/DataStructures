package org.atanu.java.ds.sort;

public class HeapSort {

	
	private static void heapSort(int[] arr) {
		
		int n = arr.length;
		
		for(int i = n/2 - 1; i >=0 ; i--)
		{
			maxheapify(arr,i,n);		
		}
		
		for(int j = n-1; j >=0 ; j--)
		{
			int temp = arr[0];
			arr[0] = arr[j];
			arr[j] = temp;
			
			maxheapify(arr, 0, j);
		}
		
	}
	
	public static void maxheapify(int[] arr, int index, int length)
	{
		
		int leftIndex = 2*index + 1;
		int rightIndex = 2*index + 2;
		
		int largestIndex = index;
		
		if(leftIndex < length && arr[leftIndex] > arr[largestIndex])
		{
			largestIndex = leftIndex;
		}
		if(rightIndex < length && arr[rightIndex] > arr[largestIndex])
		{
			largestIndex = rightIndex;
		}
		
		if(largestIndex != index)
		{
			int swap = arr[index]; 
            arr[index] = arr[largestIndex]; 
            arr[largestIndex] = swap; 
            
            maxheapify(arr, largestIndex, length);
		}
	}
	
	private static void swap(int i, int j, int[] array) {

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

	}

	static void printArray(int arr[]) 
	{ 
		int size = arr.length;
		for (int i = 0; i < size; i++) 
			System.out.print(arr[i] + " "); 
		System.out.println();
	} 


	public static void main(String[] args) {

		int arr[] = { 64, 34, 25, 12, 22, 11, 90 }; 
		
		System.out.println("Unsorted Sorted array: "); 
		printArray(arr); 
		
		heapSort(arr);
		
		System.out.println("Sorted array after appying Heap: "); 
		printArray(arr); 

	}



}
