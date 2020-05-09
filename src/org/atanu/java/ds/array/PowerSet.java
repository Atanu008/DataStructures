package org.atanu.java.ds.array;

public class PowerSet {

	/*	Algorithm:

		Input: Set[], set_size
		1. Get the size of power set
		    powet_set_size = pow(2, set_size)
		2  Loop for counter from 0 to pow_set_size
		     (a) Loop for i = 0 to set_size
		          (i) If ith bit in counter is set
		               Print ith element from set for this subset
		     (b) Print separator for subsets i.e., newline
		Example:

		Set  = [a,b,c]
		power_set_size = pow(2, 3) = 8
		Run for binary counter = 000 to 111

		Value of Counter            Subset
		    000                    -> Empty set
		    001                    -> a
		    010                    -> b
		    011                    -> ab
		    100                    -> c
		    101                    -> ac
		    110                    -> bc
		    111                    -> abc

	 */

	public static void findPowerSet(int[] arr) {

		// N stores total number of subsets
		int N = (int) Math.pow(2, arr.length);

		// generate each subset one by one
		for(int i = 0; i < N; i++) {

			// check every bit of i
			for(int j = 0; j < arr.length ; j++) {

				// if j'th bit of i is set, print S[j]
				if((i & (1 << j)) != 0) { // Left Shift will multiply the value by 2
					System.out.print(arr[j]);
				}
			}
			System.out.println();
		}


	}
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };
		findPowerSet(arr);

	}

}
