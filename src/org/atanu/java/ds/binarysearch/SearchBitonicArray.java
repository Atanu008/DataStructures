package org.atanu.java.ds.binarysearch;

//https://www.educative.io/courses/grokking-the-coding-interview/7n3BlOvqW0r
public class SearchBitonicArray {

    public static int search(int[] arr, int key) {

        int maxIndex = findMaxIndex(arr);
        int searchedIndex = binarySearch(arr, 0, maxIndex, key);
        if(searchedIndex != -1) {
            return searchedIndex;
        }
        return binarySearch(arr, maxIndex + 1, arr.length - 1, key);
    }

    //// find index of the maximum value in a bitonic array
    //Same as finding Peak
    public static int findMaxIndex(int[] arr) {

        int low = 0;
        int high = arr.length -1;

        while(low < high) {

            int mid = low + (high - low)/2;
            if(arr[mid] > arr[mid+1]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return high;
    }

    public static int binarySearch(int[] arr, int low, int high, int key) {

        while(low <= high) {

            int mid = low + (high - low)/2;
            if(arr[mid] == key) {
                return mid;
            }
            //Ascending
            if(arr[low] < arr[high]) {
                if(key < arr[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            {
                if(key < arr[mid]) {
                    low = mid + 1;
                }
                else {
                    high = mid -1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}