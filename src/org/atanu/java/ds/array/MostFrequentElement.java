package org.atanu.java.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class MostFrequentElement {

	public static int mostFrequentElementSol1(int[] arr) {

		// Sort the Array
		Arrays.sort(arr);

		int currentCount = 1;
		int maxCount = 1;
		int res = arr[0];
		for(int i = 0; i < arr.length -1 ; i++) {

			// Increment the counter id adjacent element is same
			if(arr[i] == arr[i+1]) {

				++currentCount;
			}
			else {// Reset the counter if teh adjacent element is not equal
				currentCount = 1;
			}

			//Update the maximum
			if(currentCount > maxCount) {
				maxCount = currentCount;
				res = arr[i];
			}
		}

		System.out.println("Most Frequent element is "+ res +" with frequency "+ maxCount);

		return res;
	}

	public static int mostFrequentElementSol2(int[] arr) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i = 0; i < arr.length ; i++) {

			if(map.containsKey(arr[i])) {

				int count = map.get(arr[i]) + 1;

				map.put(arr[i], count);
			}
			else {

				map.put(arr[i], 1);
			}
		}

		int maxCount = Integer.MIN_VALUE;
		int res = arr[0];
		for(int key : map.keySet())
		{
			if(map.get(key) > maxCount) {
				res = key;
				maxCount = map.get(key);
			}
		}

		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>( (a,b) -> b.getValue() - a.getValue());

		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {

			queue.offer(entry);
		}
		System.out.println("Queue Most Frequent element is "+ queue.peek().getKey() +" with frequency "+ queue.peek().getValue());

		System.out.println("Most Frequent element is "+ res +" with frequency "+ maxCount);

		return res;
	}



	public static void main(String[] args) {

		int arr[] = {1, 5,3, 2, 3,3,3, 1, 2, 2,2,2}; 

		System.out.println(mostFrequentElementSol1(arr)); 

		System.out.println(mostFrequentElementSol2(arr)); 


	}

}
