package org.atanu.java.ds.twopointer;

// https://leetcode.com/problems/valid-mountain-array/description/
// Leetcode 941
public class ValidMountainArray {

    // The array size has to be > 3
    // It has to be strictly increasing like [0, 3, 5] and the values has to be different not same
    // Similarly it has to be strictly decreasing like [4 , 2, 1] amd the values has to be different not same
    // So, how we can check it.
    // For that one we will use the help of 2 pointers one will start from left & another will start from right.
    // If left and right meets on same index value then we return true, because it's a stricly increasing and decreasing mountain.

    //Two people climb from left and from right separately.
    //If they are climbing the same mountain,
    //they will meet at the same point.
    public boolean validMountainArray(int[] arr) {

        int i = 0;
        int j = arr.length - 1;

        while(i < arr.length - 1 && arr[i + 1] > arr[i]){
            i++;
        }

        while(j > 0 && arr[j - 1] > arr[j]){
            j--;
        }

        return i > 0 && i == j && j < arr.length - 1;
    }

    public boolean validMountainArray_v2(int[] arr) {

        int i = 0;
        // Climb Up Hill
        while(i < arr.length -1 && arr[i+1] > arr[i]){
            i++;
        }
        // If we are start then its decreasing . Return false(Not a Mountain)
        // If we have reached last then its all increasing , Return false(Not a Mountain)
        if(i == 0 || i == arr.length -1){
            return false;
        }

        // Start down hill
        // If going up hill , Return false(Not a Mountain)
        while(i < arr.length -1){
            if(arr[i+1] >= arr[i]){
                return false;
            }
            i++;
        }

        return true;
    }
}
