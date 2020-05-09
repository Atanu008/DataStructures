package org.atanu.java.algorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class KnapSackDP {

	public static int knapSackRec(int[] v , int[] w , int n, int weight) {

		// base case: Negative capacity
		if(weight < 0) {
			return Integer.MIN_VALUE;	
		}

		// base case: no items left or capacity becomes 0
		if(n < 0 ||weight == 0) {
			return 0;
		}

		// Case 1. include current item n in knapSack (v[n]) and recur for
		// remaining items (n - 1) with decreased capacity (W - w[n])
		int include = v[n] + knapSackRec(v, w, n -1, weight - w[n]);

		// Case 2. exclude current item n from knapSack and recur for
		// remaining items (n - 1)

		int exclude = knapSackRec(v, w, n -1, weight);

		return Math.max(include, exclude);
	}

	public static int knapSackRecMemoIzation(int[] v , int[] w , int n, int weight , Map<String , Integer> dp) {

		// base case: Negative capacity
		if(weight < 0) {
			return Integer.MIN_VALUE;
		}

		// base case: no items left or capacity becomes 0
		if(n < 0 || weight == 0) {
			return 0;
		}

		// construct a unique map key from dynamic elements of the input
		String key = n + "-" + weight;

		// if sub-problem is seen for the first time, solve it and
		// store its result in a map
		if(!dp.containsKey(key)) {

			// Case 1. include current item n in knapSack (v[n]) & recur
			// for remaining items (n-1) with decreased capacity (W - w[n])
			int include = v[n] + knapSackRecMemoIzation(v, w, n - 1, weight - w[n] , dp);

			// Case 2. exclude current item n from knapSack and recur for
			// remaining items (n-1)
			int exclude = knapSackRecMemoIzation(v, w, n - 1, weight, dp);

			// assign max value we get by including or excluding current item
			dp.put(key, Math.max(include, exclude));
		}

		// return solution to current sub-problem
		return dp.get(key);

	}

	public static int knapSackRecDP(int[] v , int[] w ,int weight) {

		// T[i][j] stores the maximum value of knapsack having weight
		// less than equal to j with only first i items considered.
		int[][] T = new int[v.length + 1][weight + 1];

		// do for ith item
		for(int i = 1 ; i <= v.length ; i++) {

			// consider all weights from 0 to maximum capacity W
			for(int j = 0; j <= weight; j++) {

				// don't include ith element if j-w[i-1] is negative
				if(w[i - 1] > j) {

					T[i][j] = T[i-1][j];
				}
				else {
					// find maximum value we get by excluding or including 
					// the i'th item
					T[i][j] = Math.max(T[i-1][j], v[i-1] + T[i-1][j - w[i-1]]);
				}
			}
		}

		// return maximum value
		return T[v.length][weight];
	}
	public static void main(String[] args) {
		// Input: set of items each with a weight and a value
		int[] v = { 20, 5, 10, 40, 15, 25 };
		int[] w = {  1, 2,  3,  8,  7, 4 };

		// Knapsack capacity
		int W = 10;

		System.out.println("Knapsack value is "
				+ knapSackRec(v, w, v.length -1 , W));

		System.out.println("Knapsack value is "
				+ knapSackRecDP(v, w, W));

		System.out.println("Knapsack value is "
				+ knapSackRecMemoIzation(v, w, v.length -1 , W, new HashMap<String , Integer>() ));

	}

}
