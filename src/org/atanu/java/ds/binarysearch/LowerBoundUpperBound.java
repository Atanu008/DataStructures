package org.atanu.java.ds.binarysearch;

import java.util.Arrays;
import java.util.List;

//Video : https://www.youtube.com/watch?v=gcYvFVZ_LUA&t=389s

// The lower_bound()
// The lower_bound() method in C++ is used
// to return an iterator pointing to the first element in the range [first, last)
// which has a value not less than val.
// This means that the function returns the index of the next smallest number just greater than or equal to that number.
// If there are multiple values that are equal to val,
// lower_bound() returns the index of the first such value.

// The upper_bound() is a built-in function in C++ STL which returns an iterator pointing to the immediate next element which is just greater than k.
// If the key passed in the parameter exceeds the maximum key in the container,
// then the iterator returned points to next of last element (which can be identified using set end() function) in the set container.

// In a nutshell ,
// upper_bound returns first element in the sorted vector such that it is strictly greater than the element k
// lower_bound returns the first element in the sorted vector which is just greater than or equal to the element k.

// 1 2 3 4 4 4 4 5 5 5
//
// lowerbound(4)  - 3
// upperBound(4) -  7

public class LowerBoundUpperBound {

    // lowerBound(x) will give pointer to First Occurrence >= x
    static int lowerBound(List<Integer> list, int target) {
        if (list == null || list.size() == 0)
            return -1;

        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            // as mid is smaller than the target , then all the elements from left would be smaller too
            // Eliminate the left lower Elements, as we need find the lower bound(element just >= target).
            if (list.get(mid) < target)
                l = mid + 1;
            else
                r = mid; // This will take care of the equal case as lowerbound index will point >= nums[]
        }

        return r;
    }
    // upperBound(x) will give pointer to First Occurrence > x
    // i.e returns index of the smallest element in the list bigger than target,
    // or -1 if there is no such element.
    static int upperBound(List<Integer> list, int target) {
        if (list == null || list.size() == 0)
            return -1;

        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) <= target) // As upper bound , we need to exclude the equal elemets also
                l = mid + 1;
            else
                r = mid;
        }

        return r;
    }

    //Same Code but with Array
    static int lowerBoundV2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid; //To Go left High has to move(help) left
            }
        }
        return high;
    }

    //Same Code but with Array
    static int upperBoundV2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid; //To Go left High has to move(help) left
            }
        }
        return high;
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 7, 9, 13, 17, 22);
        int[] nums = {5, 7, 9, 13, 17, 22};

        /*System.out.println(lowerBound(list, 13)); // 3
        System.out.println(lowerBound(list, 14)); // 4
        System.out.println(lowerBound(list, 17)); // 4

        System.out.println(upperBound(list, 13)); // 4
        System.out.println(upperBound(list, 14)); // 4
        System.out.println(upperBound(list, 17)); // 5*/

        System.out.println(lowerBoundV2(nums, 13)); // 3
        System.out.println(lowerBoundV2(nums, 14)); // 4
        System.out.println(lowerBoundV2(nums, 17)); // 4
        System.out.println(upperBoundV2(nums, 1));

        System.out.println(upperBoundV2(nums, 13)); // 4
        System.out.println(upperBoundV2(nums, 14)); // 4
        System.out.println(upperBoundV2(nums, 17));// 5
        System.out.println(upperBoundV2(nums, 5));
        System.out.println(upperBoundV2(nums, 100));
    }
}
