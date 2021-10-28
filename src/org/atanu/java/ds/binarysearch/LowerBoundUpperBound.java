package org.atanu.java.ds.binarysearch;

import java.util.Arrays;
import java.util.List;

//Video : https://www.youtube.com/watch?v=gcYvFVZ_LUA&t=389s
public class LowerBoundUpperBound {

    static int lowerBound(List<Integer> list, int target) {
        if (list == null || list.size() == 0)
            return -1;

        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            //Eliminate the lower Elements. as we need find the lower bound.
            if (list.get(mid) < target)
                l = mid + 1;
            else
                r = mid; // This will take care of the equal case
        }

        return r;
    }
    // returns index of the smallest element in the list bigger than target,
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
    }
}
