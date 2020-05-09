package org.atanu.java.ds.array;

import java.util.Arrays;

public class TwoSumClosest {

	public static int twoSumClosest(int[] arr, int target) {
		
		Arrays.sort(arr);
		
		int low = 0;
		int high = arr.length -1;
		
		int result = 0;
		int min = Integer.MAX_VALUE;
		
		int val1 = 0 , val2 = 0;
		
		while(low < high) {
			
			int sum = arr[low] + arr[high];
			
			int diff = Math.abs(target - sum);
			
			// return if the difference i.e the target is found
			if(diff == 0) {
				System.out.println(arr[low] +" "+arr[high]);
				return sum;
			}
			
			//If the difference is smaller than the minimum update the minimum
			if(diff < min) {
				
				min = diff;
				result = sum;
				val1 = arr[low];
				val2 = arr[high];
			}
			
			//Move the pointers. forward low if sum is less that target.
			if(sum < target) {
				low++;
			}
			else //Decrement the high if sum is greater that target.
			{
				high--;
			}
		}
		
		System.out.println("Closest of "+target +"  is "+result);
		System.out.println(val1 +" "+val2);
		
		return result;
		
	}

	public static void main(String[] args) {
		
		int[] S = {-1, 16, 17, -4,3,4,30};
		
		int target = 24;
		twoSumClosest(S, target);

	}

}
