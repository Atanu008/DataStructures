package org.atanu.java.ds.binarysearch;

// Given an array of integers sorted in ascending order, and a target value,
// find the element in the array that has minimum difference with the target value.

//Input: a[] = [2, 5, 10, 12, 15], target = 6
//Output: 5
//Explanation: The difference between the target value '6' and '5' is the minimum.

public class MinimumDifferenceElement {

    public int searchMinDiffElement(int[] arr, int key) {
        if (key < arr[0])
            return arr[0];
        if (key > arr[arr.length - 1])
            return arr[arr.length - 1];

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }

        //at the end of the while loop, 'start == end+1'
        //we are not able to find the element in the given array
        //return the element which is closest to the 'key'
        //Another way to think about is
        //need to find floor & ceil of the given element and
        //return one of them which has min diff with the given key
        //At the end of the while loop,
        //a[start] is the ceiling of target (Smallest number greater than target), and
        //a[end] is the floor of target (Largest number smaller than target).
        if ((arr[start] - key) < (key - arr[end]))
            return arr[start];
        return arr[end];
    }

    public static void main(String[] args) {

        MinimumDifferenceElement minimumDifferenceElement = new MinimumDifferenceElement();
        System.out.println(minimumDifferenceElement.searchMinDiffElement(new int[] { 2, 5, 10, 12, 15 }, 6));
        System.out.println(minimumDifferenceElement.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(minimumDifferenceElement.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(minimumDifferenceElement.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(minimumDifferenceElement.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}
