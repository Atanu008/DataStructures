package org.atanu.java.ds.array;

public class MaximumDifference {

    //Use two loops. In the outer loop, pick elements one by one and in the inner loop calculate the difference of the picked element with every other element in the array and compare the difference with the maximum difference calculated so far
    public static int maxDifSol1(int[] arr) {

        int maxDif = arr[1] - arr[0];

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] - arr[i] > maxDif) {

                    maxDif = arr[j] - arr[i];
                }
            }
        }

        return maxDif;
    }

    //1) Maximum difference found so far (max_diff).
    //2) Minimum number visited so far (min_element).
    public static int maxDifSol2(int[] arr) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < minPrice) {
                minPrice = arr[i];
            }

            if (arr[i] - minPrice > maxProfit) {

                maxProfit = arr[i] - minPrice;
            }

        }

        return maxProfit;


    }

    public static void main(String[] args) {


        int[] A = {2, 7, 9, 5, 1, 3, 5};

        System.out.println("The maximum difference is " + maxDifSol1(A));

        System.out.println("The maximum difference is " + maxDifSol2(A));

    }

}
