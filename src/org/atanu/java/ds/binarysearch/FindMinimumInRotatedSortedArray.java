package org.atanu.java.ds.binarysearch;

// Video : https://www.youtube.com/watch?v=j3187M1P2Xg
//Video : https://www.youtube.com/watch?v=OXkLNPalfRs&t=704s
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Leetcode 153
public class FindMinimumInRotatedSortedArray {

    //
    //This will return the rotation count.
    public static int findMin(int[] arr) {

        int length = arr.length;
        int low = 0;
        int high = arr.length - 1;

        // iterate till search space contains at-least one element
        while (low <= high) {
            // if the search space is already sorted, we have
            // found the minimum element (at index left)
            if (arr[low] <= arr[high]) {
                return low;
                //return arr[low]; for Min Element
            }
            int mid = low + (high - low)/2;
            // find next and previous element of the mid element
            // (in circular manner)
            int next = (mid + 1) % length;
            int prev = (mid - 1 + length) % length;
            //Now we need to keep Searching in Unsorted part of the array. will ignore the sorted part

            // if mid element is less than both its next and previous
            // neighbor, then it is the minimum element of the array
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
                //return arr[mid]; //for Min Element
            }
            // if A[mid..right] is sorted and mid is not the min element,
            // then pivot element cannot be present in A[mid..right] and
            // we can discard A[mid..right] and search in the left half
            else if (arr[mid] <= arr[high]) {
                high = mid - 1;
            }
            // if A[left..mid] is sorted then pivot element cannot be
            // present in it and we can discard A[left..mid] and search
            // in the right half
            else if (arr[mid] >= arr[low]) {
                low = mid + 1;
            }
        }
        // invalid input
        return -1; //Ca return 0 also i.e array is not rotated
    }

    // Institution : Min will always lay on non sorted side. Discard teh sorted side
    public int findMinV2(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        // iterate till search space contains at-least one element
        while (low < high){
            int mid = low + (high -low)/2;

            // No possible solution in left half as it is sorted
            // Right Half is not sorted
            // we can discard the left part as it is not sorted as mid greater than high
            // example:  [3,4,5,6,7,8,9,1,2]
            // in the first iteration, when we start with mid index = 4, right index = 9.
            // if nums[mid] > nums[right], we know that at some point to the right of mid,
            // the pivot must have occurred, which is why the values wrapped around
            // so that nums[right] is less then nums[mid]

            if(arr[mid] > arr[high]){
                low = mid+1;
            }
            else{

                //If arr[mid] is <= arr[high] so Right part is sorted and NO possible solution
                //so we need to move left . high is will to move left
                //# example: [8,9,1,2,3,4,5,6,7]
                // in the first iteration, when we start with mid index = 4, right index = 9.
                // if nums[mid] <= nums[right], we know the numbers continued increasing to
                // the right of mid, so they never reached the pivot and wrapped around.
                // therefore, we know the pivot must be at index <= mid.
                high = mid;
            }
        }
        return arr[high];

    }

    public static void main(String[] args) {

        int[] A = {8, 9, 10, 12, 1, 2, 3, 4, 5, 6, 7};

        System.out.println("The array is rotated " + findMin(A) + " times");
        System.out.println("Minimum Element in rotated Array " + new FindMinimumInRotatedSortedArray().findMinV2(A));

    }

}
