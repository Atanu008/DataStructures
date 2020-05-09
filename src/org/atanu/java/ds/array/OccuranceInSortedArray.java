package org.atanu.java.ds.array;

import java.util.Arrays;

public class OccuranceInSortedArray {

	public static int findOccuranceInSortedArraySol1(int[] arr , int key) {

		int index = Arrays.binarySearch(arr, key);

		// If element is not present 
		if(index == -1) {
			return 0;
		}

		// Count elements on left side. 
		int count = 1;

		int left = index -1;
		while(left >= 0 && arr[left] == key) {
			count++;
			left--;
		}

		// Count elements  
		// on right side. 
		int right = index + 1;

		while(right < arr.length && arr[right] == key) {
			count++;
			right++;
		}

		return count;
	}
	
	public static int findOccuranceInSortedArraySol2(int[] arr , int key) {
		
		int firstIndex = getOccurance(arr, key, true);
		int lastIndex = getOccurance(arr, key, false);
		
		
		System.out.println(firstIndex);
		
		System.out.println(lastIndex);
		
		if(firstIndex == -1 || lastIndex == -1) {
			return 0;
		}
		
		else {
			return (lastIndex - firstIndex) + 1;
		}
		
	}
	private static int getOccurance(int[] arr, int key, boolean firstOccurance) {
		
		int result = -1;
		
		int low = 0;
		int high = arr.length -1;
		
		while(low <= high) {
			
			int mid = low +(high - low)/2;
			
			if(arr[mid] == key) {
				
				result = mid;
				// to get the firstOccurance
				if(firstOccurance) {
					high = mid -1;
				}
				else {// to get the last Occurance
					low = mid + 1;
				}
			}
			
			else if(key < arr[mid]) {
				
				high = mid -1;
			}
			else {
				low = mid +1;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {

		int arr[] = {1, 2, 2, 2, 2, 3, 4,4, 7,7,7,7,7, 8, 8}; 
		int key = 2;

		System.out.println(findOccuranceInSortedArraySol1(arr, key));
		
		System.out.println(findOccuranceInSortedArraySol2(arr, key));

	}

}
