package org.atanu.java.ds.array;

import java.util.Arrays;

public class RightRotationArray {

	// Function to right rotate an array by one position
	public static void rightRotationSol1(int[] arr , int rotation) {

		for(int i = 0; i < rotation; i++) {
			rightRotateOne(arr);
		}
	}

	public static void rightRotateOne(int[] arr) {

		int last = arr[arr.length -1];

		for(int i = arr.length -2 ; i >=0; i-- ) {
			arr[i + 1] = arr[i];
		}

		arr[0] = last;

	}
	
	public static void rightRotationSol2(int[] arr , int rotation) {

		int n = arr.length;
		
		//reverse last k digit
		reverse(arr, n - rotation , n -1);
		
		// Reverse the first 'n-k' elements
		reverse(arr, 0 , n - rotation -1);
		
		// Reverse the whole array
		reverse(arr, 0, n - 1);
		
	}
	
	public static void reverse(int[] arr , int start, int end) {
		
		while(start < end) {
			
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
		
	}
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;

		rightRotationSol1(arr, k);

		System.out.println(Arrays.toString(arr));
		
		int A[] = { 1, 2, 3, 4, 5, 6, 7 };
		
		rightRotationSol2(A, k);
		System.out.println(Arrays.toString(A));

	}

}
