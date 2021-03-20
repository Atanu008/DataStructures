package org.atanu.java.ds.stack;

import java.util.Stack;

public class FindNextGreater {


    public static void findNextGreaterSolution1(int[] arr) {

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < arr.length; i++) {

            int next = arr[i];

            while (!stack.isEmpty() && next > stack.peek()) {
                System.out.println("Next Bigger of " + stack.pop() + " is " + next);
            }


			/* push next to stack so that we can find 
	        next smaller for it */
            stack.push(next);

        }

        while (!stack.isEmpty()) {
            System.out.println("Next Bigger ofF " + stack.pop() + " is -1 ");
        }


    }


    //Order is maintained is traverse from last.
    public static void findNextGreaterSolution2(int[] arr) {

        Stack<Integer> stack = new Stack();

        int[] nge = new int[arr.length];


        // iterate for rest of the elements
        for (int i = arr.length - 1; i >= 0; i--) {

            int cur = arr[i];

            while (!stack.isEmpty() && cur > stack.peek()) {
                //System.out.println(cur);
                stack.pop();
            }


            nge[i] = stack.isEmpty() ? -1 : stack.peek();
			
			/* push next to stack so that we can find 
	        next smaller for it */
            stack.push(cur);

        }

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i] + " --> " + nge[i]);


    }


    // Simple n^3 solution.
    public static void findNextGreaterSolution3(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int next = -1;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i])
                    next = arr[j];
                break;
            }

            System.out.println(arr[i] + " -- " + next);
        }
    }


    public static void main(String[] args) {

        int arr[] = {11, 13, 25, 21, 76, 3};

        //findNextGreaterSolution1(arr);
        findNextGreaterSolution2(arr);

        //findNextGreaterSolution3(arr);

    }

}
