package org.atanu.java.ds.array;

public class LeaderInArray {

    // // Time Complexity: O(n^2)
    public static void findLeaderSol1(int[] arr) {

        //Check for all the element if it is greater than all elements
        for (int i = 0; i < arr.length; i++) {

            int j = 0;
            for (j = i + 1; j < arr.length; j++) {

                if (arr[i] <= arr[j])
                    break;
            }

            if (j == arr.length)// The loop did not break . ith elemet is the leader
                System.out.print(arr[i] + " ");
        }
    }

    //Time Complexity: O(n)
    public static void findLeaderSol2(int[] arr) {

        int maxSoFar = arr[arr.length - 1];

        System.out.print(maxSoFar + " "); // Last element will always be the leader

        // Scan all the elements from right to left in an array and keep track of maximum till now.
        //When maximum changes its value, print it.

        for (int i = arr.length - 2; i >= 0; i--) {

            if (arr[i] > maxSoFar) {

                System.out.print(arr[i] + " ");
                maxSoFar = arr[i];
            }

        }
    }

    public static void main(String[] args) {

        int arr[] = new int[]{16, 17, 4, 3, 5, 2};

        findLeaderSol1(arr);
        System.out.println();
        findLeaderSol2(arr);

    }

}
