package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/
//LeetCode 852
public class PeakIndexInAMountainArray {

    //Return index where its not strictly increasing
    public int peakIndexInMountainArray(int[] arr) {

        int i = 0;
        while(arr[i] < arr[i+1]){
            i++;
        }

        return i;
    }

    //Binary Search
    public int peakIndexInMountainArrayV2(int[] arr) {

        int low = 0;
        int high = arr.length -1;

        while(low < high){
            int mid = low + (high -low)/2;
            //Increasing seq.Not present in left
            //searchin Right
            if(arr[mid] < arr[mid+1]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }

        return high;
    }
}
