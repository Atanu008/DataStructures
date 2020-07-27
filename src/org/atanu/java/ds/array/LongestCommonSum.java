package org.atanu.java.ds.array;

import java.util.Arrays;
import java.util.HashMap;


public class LongestCommonSum {

	public static void longestCommonSumSol1(int[] arr1, int[] arr2) {

		int maxLength = 0;
		// One by one pick all possible starting points 
		// of subarrays 
		for(int i = 0 ; i < arr1.length ; i++) {

			int sum1 = 0;
			int sum2 = 0;

			// Conider all points for starting with arr[i] 
			for(int j = i ; j < arr1.length ; j++) {

				// Update sums 
				sum1 += arr1[j];
				sum2 += arr2[j];

				// If sums are same and current length is 
				// more than maxLen, update maxLen 
				if(sum1 == sum2) {

					int len = j - i +1;

					if(len > maxLength) {
						maxLength = len;
					}
				}
			}
		}

		System.out.println(maxLength);
	}

	// Returns largest common subarray with equal  
	// number of 0s and 1s 
	static int longestCommonSum(int[] arr1, int[] arr2, int n) 
	{ 
		// Find difference between the two 
		int[] arr = new int[n]; 
		for (int i = 0; i < n; i++)  
			arr[i] = arr1[i] - arr2[i]; 

		System.out.println(Arrays.toString(arr));
		// Creates an empty hashMap hM  
		HashMap<Integer, Integer> hM = new HashMap<>(); 

		int sum = 0;     // Initialize sum of elements  
		int max_len = 0; // Initialize result  

		// Traverse through the given array  
		for (int i = 0; i < n; i++)  
		{  
			// Add current element to sum  
			sum += arr[i];  

			System.out.println("Sum  "+ sum);
			// To handle sum=0 at last index  
			if (sum == 0)  
				max_len = i + 1;  

			// If this sum is seen before,  
			// then update max_len if required  
			if (hM.containsKey(sum))  {
				//System.out.println("i = "+ i + " sum= "+ sum + "  map Get "+ hM.get(sum));
				max_len = Math.max(max_len, i - hM.get(sum));  
			}

			else // Else put this sum in hash table  
				hM.put(sum, i);  
		} 

		for(int k: hM.keySet()) {
			System.out.println(k + " "+ hM.get(k));
		}
		return max_len;  
	}  

	public static void main(String[] args) {

		int[] arr1 = {0, 1, 0, 0, 0, 0};  
		int[] arr2 = {1, 0, 1, 0, 0, 1}; 
		int n = arr1.length; 
		System.out.println(longestCommonSum(arr1, arr2, n));

		longestCommonSumSol1(arr1, arr2);

	}

}
