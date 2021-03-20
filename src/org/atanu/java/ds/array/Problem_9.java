package org.atanu.java.ds.array;

/**
 * @author atanu
 * https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 */
public class Problem_9 {

    /*
     * https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
     * Find the Rotation Count in Rotated Sorted array
       Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.
     *
     */
    public static void main(String[] args) {

        int arr[] = {15, 18, 2, 3, 6, 12};
        countRotationsmethod_1(arr);

    }

    static void countRotationsmethod_1(int arr[]) {
        int minVal = arr[0];
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
                minIndex = i;
            }
        }
        System.out.println("Rotation Count is  " + minIndex);
    }

}
