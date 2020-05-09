package org.atanu.java.ds.array;

import java.util.HashMap;
import java.util.Map;

public class TwoOddOccuringElement {

	public static void findTwoOddOccuringElementSol1(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			if(map.containsKey(arr[i])) {

				int count = map.get(arr[i]);

				map.put(arr[i], count + 1);
			}
			else
				map.put(arr[i], 1);
		}

		for(int key : map.keySet()) {

			if(map.get(key) %2 != 0) {
				System.out.println(key);
			}
		}
	}
	
	public static void findTwoOddOccuringElementSol2(int[] arr) {
		
		int res = 0;
		
		 // Find XOR of 
	    // all numbers 
		for (int i = 0; i < arr.length; i++) {
			
			res = res^ arr[i];
		}
		
		// Find a set bit in the  
	    // XOR (We find rightmost  
	    // set bit here) 
		int setBit = res & (~res + 1);
		
		
		 // Traverse through all  
	    // numbers and divide them  
	    // in two groups (i) Having  
	    // set bit set at same position  
	    // as the only set bit in  
	    // set_bit (ii) Having 0 bit at 
	    // same position as the only  
	    // set bit in set_bit 
		int x = 0 , y = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			if((arr[i] & setBit) != 0) {
				x = x^ arr[i];
			}
			else {
				y = y^ arr[i];
			}
				
		}
		
		System.out.println(x +" "+ y);
	}
	public static void main(String[] args) {


		int[] arr = { 4, 4, 2, 2, 3, 2, 1, 1, 4,3,};

		findTwoOddOccuringElementSol1(arr);
		
		findTwoOddOccuringElementSol2(arr);

	}

}
