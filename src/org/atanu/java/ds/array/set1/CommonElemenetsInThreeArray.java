package org.atanu.java.ds.array.set1;

public class CommonElemenetsInThreeArray {
	//Brute Force Method
	//Using three for loop, generate all possible combination of triplet(one from each input array) and check if they are equal.
	//This approach is not using the fact that input arrays are sorted.
	//Time Complexity : O(n3)


	// Solution 2
	// A simple solution is to first find intersection of two arrays and store the intersection in a temporary array, 
	// Then find the intersection of third array and temporary array. 

	// Solution 3 . At One pass O(n1 + n2+ n3)

	public static void commonElemenetsInThreeArray(int[] arr1, int[] arr2, int[] arr3) {

		int i = 0, j = 0, k = 0;

		while(i < arr1.length && j < arr2.length && k < arr3.length) {
			//found one common element . Increment all three pointers
			if((arr1[i] == arr2[j]) && (arr2[j] == arr3[k])) {
				System.out.println(arr1[i]+ " ");
				i++;
				j++;
				k++;
			}
			/* array1[i] is smallest, increment i*/
			else if((arr1[i] <= arr2[j])  && (arr2[j] <= arr3[k] )) {
				i++;
			}
			/* array2[j] is smallest, increment j*/
			else if ((arr2[j] <= arr3[k]) && (arr2[j] <= arr1[i])){

				j++;
			} 
			/* array3[k] is smallest, increment k*/
			else {
				k++;
			}
		}

	}
	public static void main(String[] args) {
		int array1[] = {1, 5, 10, 15, 20, 25, 30};
		int array2[] = {3, 4, 5, 10, 15, 25, 30, 38};
		int array3[] = {0, 2, 5, 13, 15, 16, 17, 25, 32};

		commonElemenetsInThreeArray(array1,array2,array3);

	}

}
