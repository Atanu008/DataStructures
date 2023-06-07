package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/kth-missing-positive-number/description/
// Leetcode 1539

public class KthMissingPositiveNumber_v2 {

    //Before 2, there is 2 - 1 = 1 missing integer.
    //
    //Before 3, there is 3 - 2 = 1 missing integer.
    //
    //Before 4, there is 4 - 3 = 1 missing integer.
    //
    //Before 7, there are 7 - 4 = 3 missing integers.
    //
    //Before 11, there are 11 - 5 = 6 missing integers.
    //
    //The number of positive integers which are missing before the arr[idx]
    // is equal to arr[idx] - (idx + 1)

    // Choose the pivot index in the middle of the array.

    // If the number of positive integers which are missing before arr[pivot] is less than k -
    // continue to search on the right side of the array.
    // Otherwise, continue to search on the left side.
    //
    // Algorithm
    // Initialize search boundaries: left = 0, right = arr.length - 1.
    //
    // While left <= right:
    //  Choose the pivot index in the middle: pivot = left + (right - left) / 2.
    //  Note that in Java we couldn't use straightforward pivot = (left + right) / 2
    //  to avoid the possible overflow. In Python, the integers are not limited,
    //  and we're fine to do that.
    //
    //  If the number of positive integers which are missing before is less than k
    //  arr[pivot] - pivot - 1 < k -
    //  continue to search on the right side of the array: left = pivot + 1.
    //
    //  Otherwise, continue to search on the left: right = pivot - 1.
    //
    // At the end of the loop, left = right + 1,
    // and the kth missing number is in-between arr[right] and arr[left].
    // The number of integers missing before arr[right] is arr[right] - right - 1.
    // Hence, the number to return is arr[right] + k - (arr[right] - right - 1) = k + left.


    // Explanation of : arr[right] + k - (arr[right] - right - 1)
    // arr[right] - (right + 1) = Number of Missing elements before right index
    // K = Missing elements' number to be found.
    //
    // If arr[right] - (right + 1) = 0. We would have returned a[right] + k.
    // But as we might have already encountered missing elements to the index's left.
    // We subtract those missing elements from K
    // Hence, arr[right] +( k - ( arr[right] - (right + 1) ))

    // Most Imp point of the algorithm the kth missing is in-between arr[right] and arr[left].

    public int findKthPositive(int[] arr, int k) {

        int low = 0;
        int high = arr.length - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;
            // If number of positive integers
            // which are missing before arr[pivot]
            // is less than k -->
            // continue to search on the right.
            // Missing positive Number Before Mid = arr[mid] - (mid + 1)
            if(arr[mid] - (mid + 1) < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        // At the end of the loop, left = right + 1,
        // and the kth missing is in-between arr[right] and arr[left].
        // The number of integers missing before arr[right] is
        // arr[right] - right - 1 -->
        // the number to return is
        //    arr[right] + k - (arr[right] - right - 1) = k + left
        // => arr[right] + k - (arr[right] - right - 1) = k + (right + 1) (arr[right] cancelling each other)
        // => arr[right] + k - (arr[right] - right - 1) = k + left (as left = right + 1)
        return low + k;
    }


    public static void main(String[] args) {
        KthMissingPositiveNumber_v2 kthMissingPositiveNumber = new KthMissingPositiveNumber_v2();
        int[] arr = {2,3,4,7,11};
        int k = 5;
        //Output: 9
        //Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
        System.out.println(kthMissingPositiveNumber.findKthPositive(arr, k));

        arr = new int[]{1,2,3,4};
        k = 2;
        //Output: 6
        //Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
        System.out.println(kthMissingPositiveNumber.findKthPositive(arr, k));
    }
}
