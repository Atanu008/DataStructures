package org.atanu.java.ds.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Union {

	// No need to sort
	public static void findUnionSol1(int[] arr1, int[] arr2) {

		//Create a set
		Set<Integer> unionSet = new HashSet<>();

		//Iterate the first Array and add in the set
		for (int i = 0; i < arr1.length; i++) {
			unionSet.add(arr1[i]);
		}

		// Iterate the Second Array. If new element add in teh set
		for (int j = 0; j < arr2.length; j++) {

			if(!unionSet.contains(arr2[j])) {
				unionSet.add(arr2[j]);
			}
		}

		//Print Union
		for(int a: unionSet) {
			System.out.print(a+" ");
		}
	}

	// Duplicates will not be handled
	public static void findUnionSol2(int[] arr1, int[] arr2) {

		//Sort Two Array
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int i = 0;
		int j = 0;

		while (i < arr1.length && j < arr2.length) 
		{ 
			// If arr1[i] is smaller than arr2[j] then print arr1[i] and increment i.
			if (arr1[i] < arr2[j]) 
				System.out.print(arr1[i++]+" ");
			//If arr1[i] is greater than arr2[j] then print arr2[j] and increment j.
			else if (arr2[j] < arr1[i]) 
				System.out.print(arr2[j++]+" "); 
			// If both are same then print any of them and increment both i and j.
			else
			{ 
				System.out.print(arr2[j++]+" "); 
				i++; 
			} 
		} 

		/* Print remaining elements of  
	         the larger array */
		while(i < arr1.length) 
			System.out.print(arr1[i++]+" "); 
		while(j < arr2.length) 
			System.out.print(arr2[j++]+" ");  

	}
	public static void main(String[] args) {
		int arr1[] = {1, 2, 4, 5, 6}; 
		int arr2[] = {2, 3, 5, 7}; 

		findUnionSol1(arr1,arr2);

		System.out.println();

		findUnionSol2(arr1,arr2);

	}

}
