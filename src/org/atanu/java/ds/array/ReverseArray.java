package org.atanu.java.ds.array;

import java.util.Arrays;

public class ReverseArray {

	public static void reverseIterative(int[] arr) {
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end) {
			
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
	}
	
	public static void reverseRecursive(int[] arr, int start , int end ) {
		
		if(start >= end)
			return;
		
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
		reverseRecursive(arr, start +1 , end -1);
	}
	
	public static void main(String[] args) {
		int A[] = { 8, 7, 2, 5, 3, 1, 9, 5 };
		
		reverseIterative(A);
		
		System.out.println("Reversed");
		System.out.println(Arrays.toString(A));
		
		reverseRecursive(A, 0, A.length -1);
		
		System.out.println("Reversed again");
		System.out.println(Arrays.toString(A));
		
	}
}
