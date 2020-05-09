package org.atanu.java.ds.array;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingElement {

	public static void findFirstReeatingElement(int[] arr) {
		
		int firstRepeating = -1;
		
		Set<Integer> set = new HashSet<>();
		
		
		for (int i = arr.length - 1; i >= 0; i--) {
			
			if(set.contains(arr[i])) {
				
				firstRepeating = i;
			}
			
			else {
				set.add(arr[i]);
			}
			
		}
		
		// Print the result 
        if (firstRepeating != -1) 
          System.out.println("The first repeating element is " + arr[firstRepeating]); 
        else
          System.out.println("There are no repeating elements");
		
	}
	public static void main(String[] args) {
		
		int arr[] = {10, 5, 3, 4, 3, 5, 6}; 
		findFirstReeatingElement(arr); 

	}

}
