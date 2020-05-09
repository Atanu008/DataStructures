package org.atanu.java.ds.array;

import java.util.HashMap;
import java.util.Map;

public class OneOddOccuringElement {

	//A Simple Solution is to run two nested loops. 
	//The outer loop picks all elements one by one and inner loop counts number of occurrences of the element picked by outer loop. 
	//Time complexity of this solution is O(n2).
	public static int findOddOccuringSol1(int[] arr) {
		
		for(int i = 0; i < arr.length ; i++) {
			
			int count = 0;
			for(int j = 0; j < arr.length ; j++) {
				
				if(arr[i] == arr[j])
					count++;
			}
			
			if(count%2 != 0)
				return arr[i];
		}
		
		return -1;
	}
	
	public static int findOddOccuringSol2(int[] a) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i = 0; i < a.length ; i++) {

			if(map.containsKey(a[i])) {

				int count = map.get(a[i]) + 1;

				map.put(a[i], count);
			}
			else {

				map.put(a[i], 1);
			}
		}
		
		for(int elem : map.keySet()) {
			
			if(map.get(elem)%2 != 0) {
				return elem;
			}
		}
		
		return -1;
	}
	
	//if we XOR a number with itself odd number of times the result is number itself, 
	//otherwise if we XOR a number even number of times with itself, the result is 0
	
	// Function to find odd occurring element in a given array
	//XOR of two elements is 0 if both elements are same and XOR of a number x with 0 is x.
		public static int findOddOccuringSol3(int[] arr)
		{
		
			int xor = 0;
			
			//if we take XOR of all elements present in the array, even appearing elements will cancel each other and we are left with the only odd appearing element
			for(int i = 0; i < arr.length; i++) {
				
				xor = xor ^ arr[i];
			}
			
			return xor;
		}

		public static void main(String[] args)
		{
			int[] arr = { 4, 4, 3, 3, 4};

			System.out.println("Odd occurring element is " + findOddOccuringSol3(arr));
			
			System.out.println("Odd occurring element is " + findOddOccuringSol1(arr));
			
			System.out.println("Odd occurring element is " + findOddOccuringSol2(arr));
		}
}
