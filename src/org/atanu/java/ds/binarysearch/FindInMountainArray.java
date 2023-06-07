package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/find-in-mountain-array/
//LeetCode 1095
public class FindInMountainArray {

    //Binary find peak in the mountain (LeetCode 852. Peak Index in a Mountain Array)
    //Binary find the target in strict increasing array
    //Binary find the target in strict decreasing array
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int low = 0;
        int high = mountainArr.length() - 1;

        while(low < high){
            int mid = low + (high - low) / 2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }

        int peak = high;

        //Search in Increasing Part of the Mountain. Up Hill
        //Increassing Array
        low = 0;
        high = peak;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(target == mountainArr.get(mid)){
                return mid;
            }
            else if(target > mountainArr.get(mid)){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }


        //Search in Decreasing Part of the Mountain. Down Hill
        //Strictly Decreasing Array
        low = peak;
        high = mountainArr.length() - 1;;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(target == mountainArr.get(mid)){
                return mid;
            }
            else if(target > mountainArr.get(mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }


        return -1;
    }

    interface MountainArray {
     public int get(int index);
     public int length();
 }
}
