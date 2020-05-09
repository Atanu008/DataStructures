package org.atanu.java.ds.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {

	public static void findIntersectionSol1(int[] arr1, int[] arr2) {

		//Create a set
		Set<Integer> set = new HashSet<>();
		Set<Integer> intersectionSet = new HashSet<>();

		//Iterate the first Array and add in the set
		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}

		// Iterate the Second Array. If new element add in the set
		for (int j = 0; j < arr2.length; j++) {

			if(set.contains(arr2[j])) {
				intersectionSet.add(arr2[j]);
			}
		}

		//Print Intersection
		for(int a: intersectionSet) {
			System.out.print(a+" ");
		}
	}

	// Duplicates will not be handled
	public static void findIntersectionSol2(int[] arr1, int[] arr2) {

		//Sort Two Array
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int i = 0;
		int j = 0;

		while (i < arr1.length && j < arr2.length) 
		{ 
			//If arr1[i] is smaller than arr2[j] then increment i.
			if (arr1[i] < arr2[j]) 
				i++;
			// If arr1[i] is greater than arr2[j] then increment j.
			else if (arr2[j] < arr1[i]) 
				j++;
			//If both are same then print any of them and increment both i and j.
			else
			{ 
				System.out.print(arr2[j++] +" "); 
				i++; 
			} 
		} 


	}
	public static void main(String[] args) {
		int arr1[] = {1, 2, 4, 5, 6}; 
		int arr2[] = {2, 3, 5, 7}; 

		findIntersectionSol1(arr1,arr2);

		System.out.println();

		findIntersectionSol2(arr1,arr2);

	}

}
