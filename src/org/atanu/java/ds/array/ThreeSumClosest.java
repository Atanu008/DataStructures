package org.atanu.java.ds.array;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosestSol3(int[] arr, int target) {

        System.out.println("bejf");
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < arr.length; i++) {


            int low = i + 1;
            int high = arr.length - 1;

            while (low < high) {

                //sum of Three element
                int sum = arr[i] + arr[low] + arr[high];

                // Check difference
                int diff = Math.abs(target - sum);

                // return if the difference i.e the target is found
                if (diff == 0)
                    return sum;

                //If the difference is smaller than the minimum update the minimum
                if (diff < min) {
                    min = diff;
                    result = sum;
                }

                //Move the pointers. forward low if sum is less that target.
                if (sum < target) {
                    low++;
                } else //Decrement the high if sum is greater that target.
                {
                    high--;
                }
            }

        }


        return result;

    }

    public static void main(String[] args) {

        int[] S = {-1, 2, 1, -4, 3, 4, 9};
        int target = 19;
        int result = threeSumClosestSol3(S, target);

        System.out.println("Closest of " + target + " is " + result);


    }

}
