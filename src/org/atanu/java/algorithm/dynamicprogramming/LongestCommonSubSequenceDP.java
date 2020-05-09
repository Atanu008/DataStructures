package org.atanu.java.algorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubSequenceDP {

	public static int LCSLengthRec(String X, String Y , int m, int n) {

		//Base Case
		//Return if we have reached the end of either sequence
		if(m == -1 || n == -1) {
			return 0;
		}

		//// if last character of X and Y matches
		if(X.charAt(m) == Y.charAt(n)) {

			return LCSLengthRec(X, Y, m -1 , n -1) + 1;
		}


		return Math.max(LCSLengthRec(X, Y, m -1 , n), LCSLengthRec(X, Y, m , n -1));

	}

	public static int LCSLengthRecMemoIzation(String X, String Y , int m, int n, Map<String , Integer> dp) {

		//Base Case
		//Return if we have reached the end of either sequence
		if(m == -1 || n == -1) {
			return 0;
		}

		String key = m + "-" + n;

		// if sub-problem is seen for the first time, solve it and
		// store its result in a map
		if(!dp.containsKey(key)) {

			// if last character of X and Y matches
			if(X.charAt(m) == Y.charAt(n)) {

				dp.put(key,LCSLengthRec(X, Y, m -1 , n -1) + 1);
			}
			// else if last character of X and Y don't match
			else {
				dp.put(key, Math.max(LCSLengthRec(X, Y, m -1 , n), LCSLengthRec(X, Y, m , n -1)));
			}
		}

		return dp.get(key);
	}
	
	public static int LCSLengthDP(String X, String Y) {
		
		int m = X.length();
		int n = Y.length();
		
		// lookup table stores solution to already computed sub-problems
		// i.e. lookup[i][j] stores the length of LCS of substring
		// X[0..i-1] and Y[0..j-1]
		int[][] T = new int[m+1][n+1];
		
		for(int i = 1 ; i <= m; i++) {
			
			for(int j = 1; j <= n; j++) {
				
				//if current character of X and Y matches
				// Get the Diagonal Element As are not considering the two elements
				if(X.charAt(i - 1) == Y.charAt(j - 1)) {
					
					T[i][j] = T[i -1][j -1] + 1;
				}
				
				// else if current character of X and Y don't match
				// Get teh max of Left Row Or upper Coulmn
				else {
					T[i][j] = Math.max(T[i -1][j], T[i][j -1]);
				}
			}
		}
		
		return T[m][n];
	}
	
	
	public static void main(String[] args) {


		String X = "ABCBDAB", Y = "BDCABA";

		System.out.println("The length of LCS is "
				+ LCSLengthRec(X, Y, X.length() - 1, Y.length() - 1));

		System.out.println("The length of LCS is "
				+ LCSLengthRecMemoIzation(X, Y, X.length() -1 , Y.length() -1, new HashMap<String , Integer>()));
		
		System.out.println("The length of LCS is "
				+ LCSLengthDP(X, Y));
	}

}
