package org.atanu.java.ds.array;

public class MinimumDistanceBetweenTwoElements {

	// Time Complexity: O(n^2)
	public static int findMinimumDistanceSol1(int[] arr, int x, int y) {

		int minDisatnce = Integer.MAX_VALUE;
		//Check for every Item
		for(int i = 0; i < arr.length - 1; i++) {

			for(int j = i+1; j < arr.length ; j++) {

				// If match found then update minimum
				if( (arr[i] ==x && arr[j] == y) || (arr[i] ==y && arr[j] == x) ) {

					if(Math.abs(j - i) < minDisatnce) {
						minDisatnce = Math.abs(j - i);
					}
				}
			}
		}

		return minDisatnce;
	}

	//Time Complexity: O(n)
	public static int findMinimumDistanceSol2(int[] arr, int x, int y) {

		int i = 0; 
		int selected = 0;
		
		// Find the first occurence of any of the two numbers (x or y) 
        // and store the index of this occurence in selected 
		for (i = 0; i < arr.length; i++) {

			if(arr[i] == x || arr[i] == y) {
				selected = i;
				break;
			}
		}

		int minDistance = Integer.MAX_VALUE;
		for (;i  < arr.length; i++) {

			if((arr[i] == x || arr[i] == y)  ) {

				// If the current element matches with any of the two then 
                // check if current element and selected element are different 
                // Also check if this value is smaller than minimum distance  
                // so far 
				if(arr[i] != arr[selected]) {

					minDistance = Math.min(minDistance, Math.abs(i - selected));
					selected = i;
				}
				// If the item is same then update the selected
				else {
					selected = i;
				}
			}
		}
		
		return minDistance;
	}

	public static void main(String[] args) {
		int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}; 
		int n = arr.length; 
		int x = 3; 
		int y = 6; 

		System.out.println("Minimum distance between " + x + " and " + y  
				+ " is " + findMinimumDistanceSol1(arr, x, y)); 
		
		System.out.println("Minimum distance between " + x + " and " + y  
				+ " is " + findMinimumDistanceSol2(arr, x, y));

	}

}
