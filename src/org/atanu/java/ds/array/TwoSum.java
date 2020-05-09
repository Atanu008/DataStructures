package org.atanu.java.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {


	private static void findPairSolution1(int[] a, int sum) {

		// consider each element except last element
		for(int i = 0; i < a.length -1 ; i++) {

			for(int j = i + 1; j < a.length ; j++) {

				// if desired sum is found, print it and return
				if(a[i] + a[j] == sum) {
					System.out.println(a[i] +" "+ a[j]);
				}
			}
		}

	}

	private static void findPairSolution3(int[] a, int sum) {

		// create an empty Hash Map
		Map<Integer, Integer> map = new HashMap<>();

		// check if pair (arr[i], sum-arr[i]) exists
		// if difference is seen before, print the pair
		for(int i = 0; i< a.length ; i++) {

			int temp = sum - a[i];

			if(map.containsKey(temp)) {

				System.out.println(a[i] +" "+ temp);
			}

			// store index of current element in the map
			map.put(a[i], i);
		}
	}

	private static void findPairSolution2(int[] a, int sum) {

		// sort the array in ascending order
		Arrays.sort(a);

		// maintain two pointer to end-points of the array
		int low = 0;
		int high = a.length - 1;

		// reduce search space arr[low..high] at each iteration of the loop

		// loop till low is less than high
		while(low < high) {

			// sum found
			if(a[low] + a[high] == sum) {

				System.out.println(a[low] +" "+ a[high]);
			}

			// increment low index if total is less than the desired sum
			// decrement high index is total is more than the sum
			if(a[low] + a[high] < sum) {
				low++;
			}
			else {
				high--;
			}
		}
	}

	public static void main(String[] args) {
		int A[] = { 8, 7, 2, 5, 3, 1, 9, 5 };
		int sum = 10;

		findPairSolution1(A, sum);

		System.out.println();

		findPairSolution2(A, sum);

		System.out.println();

		findPairSolution3(A, sum);

	}



}
