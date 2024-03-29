package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/
// LeetCode 852
// Looks like Leetcode 162 and 852 essentially same problem
public class PeakIndexInAMountainArray {

    //Return index where its not strictly increasing
    public int peakIndexInMountainArray(int[] arr) {

        int i = 0;
        while(arr[i] < arr[i+1]){
            i++;
        }
        return i;
    }

    //Intuition 1:
    //The idea is that, when you are at the middle element and you see the next element is above you(imagine this as a hill),
    //you bring left(pointer) to this (mid+1) convinced that since element at mid is less,
    //so element at mid+1 can be a peak, we just have to confirm with the right pointer.

    //Intuition 2:

    //Imagine it as climbing a peak. Now the left and right ends are at -infinity
    //and there is no plateau so there is a  peak to be guaranteed. Now check the middle element,
    //if the next element is less this means that we are on our downward journey in the peak,
    //so the peak is at the left part i.e end=mid
    //(Note:This element might be the peak as the next element is less therefore we included it).
    //And if the next element is greater than the current,
    //this means that we are climbing the peak therefore peak happens to be on the right part
    //(Note:This element can't be the peak).So s=mid+1

    //Binary Search
    // Most Intuitive Version
    public int peakIndexInMountainArrayV2(int[] arr) {

        int low = 0;
        int high = arr.length -1;

        while(low < high){
            int mid = low + (high -low)/2;

            // Decreasing Sequence . Peak can not lie in Right part
            //If mid is greater than next then there is 100 percentage there will be at least one pick in left
            //And we are not sure about right. So lets search Left by doing  high = mid;
            if(arr[mid] > arr[mid+1]){
                high = mid;
            }
            else{
                //Increasing seq.Not present in left
                //searching Right
                //And if the next element is greater than the current,
                //this means that we are climbing the peak therefore peak happens to be on the right part
                //(Note:This element(mid) can't be the peak as mid+1 is greater).So low =mid+1
                low = mid + 1;
            }
        }

        return high;
    }
}
