package org.atanu.java.ds.array;

import java.util.Arrays;

public class LeftRotateArray {


	// Time complexity : O(n)
	// Auxiliary Space : O(d)
	public static void rotateSol1(int[] arr, int shift) {

		int[] temp = new int[shift];

		//Store d elements in a temp array
		for(int i = 0 ; i < shift; i++) {
			temp[i] = arr[i];
		}

		//Shift left rest of the arr[]
		for(int j = 0; j < arr.length - shift ; j++) {

			arr[j] = arr[j + shift];
		}

		//Store back the d elements
		int temp_count = 0;
		for(int k = shift; k > 0; k--) {
			arr[arr.length - k] = temp[temp_count++];
		}
	}

	//Time complexity : O(n * d)
	//Auxiliary Space : O(1)
	public static void rotateSol2(int[] arr, int shift) {

		for(int i = 0; i < shift; i++) {

			rotateByOne(arr);
		}
	}

	public static void rotateByOne(int[] arr) {

		int temp = arr[0];

		int i = 0;
		for(; i < arr.length -1 ; i++) {
			arr[i] = arr[i+1];
		}

		arr[i] = temp; 
	}
	
	
	public static void rotateSol3(int[] arr, int shift) {
		
		reverseArray(arr, 0 , shift -1);
		reverseArray(arr, shift ,arr.length -1);
		reverseArray(arr, 0 ,arr.length -1);
	}
	
	public static void reverseArray(int[] arr, int start, int end) {
		
		while(start < end) {
			
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};

		//rotateSol1(arr, 2);
		
		rotateSol3(arr, 3);

		System.out.println(Arrays.toString(arr));


	}

}
