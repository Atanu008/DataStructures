package org.atanu.java.algorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciDP {

	public static int fiboRec(int n) {

		if(n <=1) {
			return n;
		}

		return fiboRec(n-1) + fiboRec(n-2);
	}

	public static int fiboRecMemiIzation(int n, Map<Integer, Integer> map) {

		// Base Case
		if(n <=1) {
			return n;
		}

		// if sub-problem is seen for the first time
		if(!map.containsKey(n)) {

			map.put(n, fiboRecMemiIzation(n-1 , map) + fiboRecMemiIzation(n-2, map));
		}

		return map.get(n);
	}

	public static int fiboDP(int n) {

		// n + 2 To handle to 0th Case
		int T[] = new int[n + 2] ;

		T[0] = 0;
		T[1] = 1;

		for(int i = 2; i <=n ; i++) {

			T[i] = T[i-1] + T[i-2];
		}

		return T[n];
	}
	public static void main(String[] args) {

		int n = 9;
		System.out.println("Fibonacci of "+n+"th Term is "+ fiboRec(n) );

		System.out.println("Fibonacci of "+n+"th Term is "+ fiboRecMemiIzation(n, new HashMap<Integer, Integer>()) );

		System.out.println("Fibonacci of "+n+"th Term is "+ fiboDP(n) );

	}

}
