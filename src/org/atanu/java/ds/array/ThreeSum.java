package org.atanu.java.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum {

	public static void threeSumSol1(int[] arr, int sum) {

		// Fix the first element as A[i] 
		for(int i = 0; i < arr.length - 2; i++) {

			// Fix the second element as A[j] 
			for(int j = i+1; j < arr.length -1; j++) {

				// Now look for the third number
				for(int k = j+1; k < arr.length; k++) {

					if(arr[i] + arr[j] + arr[k] == sum) {

						System.out.println(arr[i] +" "+ arr[j] +" "+ arr[k]);
					}
				}
			}
		}
	}

	public static void threeSumSol2(int[] arr, int sum) {

		Map<Integer, Integer> map = new HashMap<>();

		// insert (element, index) pair in map for each element in the array
		for (int i = 0; i < arr.length; i++) {

			map.put(arr[i], i);
		}

		for(int j = 0; j < arr.length -1; j++) {

			for(int k = j+1; k < arr.length; k++) {
				
				int remaining = sum - (arr[j] + arr[k]);
				
				// if remaining sum is found, we have found a triplet
				if(map.containsKey(remaining)) {
					// if triplet don't overlap, return true
					if(map.get(arr[remaining]) != j && map.get(arr[remaining]) != k ) {
						
						System.out.println(arr[j] +" "+ arr[k]+" "+remaining);
					}
				}

			}
		}

	}
	
	public static void threeSumSol3(int[] arr, int sum) {
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			
			int remaining = sum - arr[i];
			
			int low = i +1; 
			int high = arr.length -1;
			
			while(low < high) {
				
				if(remaining == arr[low] + arr[high]) {
					
					System.out.println(arr[i] +" "+ arr[low] +" "+ arr[high]);
					low++;
					high--;
				}
				else if(arr[low] + arr[high] < remaining ) {
					low++;
				}
				else {
					high--;
				}
			}
			
			
		}
		
	}
	public static void main(String[] args) {
		int[] arr = { 2, 7, 4, 0, 9, 5, 1, 3 };
		int sum = 6;

		threeSumSol1(arr, sum);
		System.out.println("Printing Solution 2");
		threeSumSol2(arr, sum);
		System.out.println("Printing Solution 3");
		threeSumSol3(arr, sum);
	}

}
