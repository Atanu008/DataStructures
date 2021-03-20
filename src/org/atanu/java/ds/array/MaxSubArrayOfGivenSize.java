package org.atanu.java.ds.array;

public class MaxSubArrayOfGivenSize {

    public static int findMaxSumSubarray(int[] arr, int k) {

        int start = 0, end = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int maxValue = Integer.MIN_VALUE;
        int sumSofar = 0;

        for (windowEnd = 0; windowEnd < arr.length; windowEnd++) {

            sumSofar += arr[windowEnd];

            if (windowEnd >= k - 1) {

                // maxValue = Math.max(maxValue , sumSofar);
                if (sumSofar > maxValue) {

                    maxValue = sumSofar;
                    start = windowStart;
                    end = windowEnd;
                }

                sumSofar -= arr[windowStart];
                windowStart++;
            }

        }

        System.out.println("Start Index " + start + " End Index " + end);
        return maxValue;
    }

    public static void main(String[] args) {


        System.out.println(findMaxSumSubarray(new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0}, 3));

    }

}
