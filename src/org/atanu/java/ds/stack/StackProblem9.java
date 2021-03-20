package org.atanu.java.ds.stack;

import java.util.Stack;

public class StackProblem9 {

    public static void getMaximumOfMinimumOfEveryWindowSol1(int[] array) {

        int n = array.length;

        for (int k = 1; k <= n; k++) {
            int maxOfMin = Integer.MIN_VALUE;

            for (int i = 0; i <= n - k; i++) {
                int min = array[i];

                for (int j = 1; j < k; j++) {
                    if (array[i + j] < min)
                        min = array[i + j];
                }

                if (min > maxOfMin)
                    maxOfMin = min;
            }

            System.out.print(maxOfMin + " ");
        }

    }

    public static void getMaximumOfMinimumOfEveryWindowSol2(int[] array) {

        int n = array.length;

        Stack<Integer> stack = new Stack<>();

        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        int ans[] = new int[n + 1];

        // Initialize elements of left[] and right[] 
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }


        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && array[stack.peek()] >= array[i])
                stack.pop();

            if (!stack.empty())
                left[i] = stack.peek();

            stack.push(i);
        }


        while (!stack.empty())
            stack.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && array[stack.peek()] >= array[i])
                stack.pop();

            if (!stack.empty())
                right[i] = stack.peek();

            stack.push(i);
        }


        for (int j = 0; j < n; j++) {
            int len = right[j] - left[j] - 1;

            //  System.out.println(len);

            ans[len] = Math.max(ans[len], array[j]);
        }


        for (int i = 1; i <= n; i++)
            //System.out.print(ans[i] + " "); 

            for (int k = n - 1; k >= 1; k--) {
                ans[k] = Math.max(ans[k], ans[k + 1]);
            }

        // Print the result
        for (int i = 1; i <= n; i++)
            System.out.print(ans[i] + " ");
    }

    public static void main(String[] args) {

        int arr[] = {10, 20, 30, 50, 10, 70, 30};

        // getMaximumOfMinimumOfEveryWindowSol1(arr);

        getMaximumOfMinimumOfEveryWindowSol2(arr);

    }

}
