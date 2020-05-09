package org.atanu.java.ds.array;

public class RemoveDuplicateFromSortedArray {

	public static int removeDuplicateFromSortedArraySol1(int[] arr) {

		//Initialize Starting Pointer as j . arr[0] will always have the first element
		int i = 0;

		// Start from Index 1 and compare with previous . arr[0] already placed at the right position
		for (int j = 1; j < arr.length; j++) {

			if(arr[j] != arr[i]) {
				// If the elementt is NOT equal to the previous element
				// Increment the pointer and place the item
				i++;
				arr[i] = arr[j];
			}

		}

		return i+1;
	}

	public static int removeDuplicateFromSortedArraySol2(int[] arr) {

		int j = 0;
		// Start traversing elements 
		for (int i = 0; i < arr.length -1 ; i++) {
			// If current element is not equal 
			// to next element then store that 
			// current element 
			if(arr[i] != arr[i+1]) {
				arr[j++] = arr[i];
			}

		}

		// Store the last element as whether 
		// it is unique or repeated, it hasn't 
		// stored previously 
		arr[j++] = arr[arr.length -1];

		return j;

	}
	public static void main(String[] args) {

		int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5}; 
		int n = arr.length; 

		n = removeDuplicateFromSortedArraySol1(arr); 

		//n = removeDuplicateFromSortedArraySol2(arr); 

		// Print updated array 
		for (int i=0; i<n; i++) 
			System.out.print(arr[i]+" "); 

	}

}
