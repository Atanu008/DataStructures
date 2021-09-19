package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/binary-search/
//LeetCode 704
public class BinarySearch {
    //Initial Condition:low = 0, high = length-1
    //Termination:low > high
    //Searching Left: high = mid-1
    //Searching Right: low = mid+1
    public int searchV1(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


    //In the End Low and High will point to the same element. So just one element to be considered finally
    public int searchV2(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // It is Ok to move one step ahead of mid, as this will still keep low<=high
            if (nums[mid] < target) {
                low = mid + 1;
            }
            //We canot move (high = mid -1) as this will breakour expectation to have atelast one element
            //Also we are not doing equal check in the first condition so (high = mid -1) may loose the element
            //As this condition also valid for Equality
            else {
                high = mid;
            }
        }

        return nums[low] == target ? low : -1;
    }

    //Search Condition needs to access element's immediate right neighbor
    //Use element's right neighbor to determine if condition is met and decide whether to go left or right
    //Guarantees Search Space is at least 2 in size at each step
    //Post-processing required. Loop/Recursion ends when you have 1 element left. Need to assess if the remaining element meets the condition.
    //In the only left Low and High. just need to check those

    public int searchV3(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if (nums[low] != target && nums[high] != target) {
            return -1;
        }
        return nums[low] == target ? low : high;

    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(target+"'s Index is "+ binarySearch.searchV1(nums,target));
        System.out.println(target+"'s Index is "+ binarySearch.searchV2(nums,target));
        System.out.println(target+"'s Index is "+ binarySearch.searchV3(nums,target));
    }

}
