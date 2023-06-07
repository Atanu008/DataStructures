package org.atanu.java.ds.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/find-k-th-smallest-pair-distance/
//LeetCode 719
public class FindKthSmallestPairDistance {

    //Brute Force
    //Memory Limit Exceeded
    public int smallestDistancePairV2(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length -1; i++){
            for(int j = i +1; j < nums.length; j++){
                list.add(Math.abs(nums[j] - nums[i]));
            }
        }

        Collections.sort(list);
        //System.out.println(list);
        return list.get(k-1);
    }


    // Video : https://www.youtube.com/watch?v=veu_Q-da6ZY (after 8 minute , and few minutes)

    //low = min_diff_between_all_nums
    //high = a[n - 1] - a[0]
    //all possible sums are in between low and high
    //binary search tries to find such distance that amount of smaller distances are not greater than k.
    // Suppose we found a mid , having mid as difference if we get exactly k pair <= mid , then mid is my answer

    //countPairsLesserThanMid(arr, mid) >= k means mid distance is big enough, but can be smaller . That's why high = mid
    //by the end of binary search we will have the exact distance equal to low
    //such that number of smaller distances is not greater than k

    // countPairsLesserThanMid(arr, mid) < k
    // Suppose we got N pair that are lesseOrEqual to Mid
    // Now if we decrement Mid we would get less pair(lesser than N)
    // So if N i.r countPairsLesserThanMid(arr, mid) s=itself is smaller than k
    // then we can not check lower values . Need to check higher values only i.e Mid + 1
    // means mid distance is too small, we need a bigger one,
    // So We go right . low = mid +1;

    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length, low = 0, high = nums[n-1] - nums[0];
        while (low < high) {
            int mid = (low + high)/2;
            int count = countPairsLesserThanMid(nums,mid);
            if (count >= k){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return high;
    }

    public int countPairsLesserThanMid(int[] nums, int mid){
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int j = i + 1;
            while (j < n && nums[j] - nums[i] <= mid) ++j;
            count += j - i - 1; // -1 because j is increased one more time in loop
        }
        return count;
    }

    public int countPairsLesserThanMid_v2(int[] nums, int mid){
        int count = 0;
        int n = nums.length;
        int windowEnd = 0;
        int windowStart = 0;
        while(windowEnd < nums.length) {

            while (nums[windowEnd] - nums[windowStart] > mid){
                windowStart++;
            }
            count += windowEnd - windowStart;
            windowEnd++;
        }
        return count;
    }

    public static void main(String[] args) {
        FindKthSmallestPairDistance findKthSmallestPairDistance = new FindKthSmallestPairDistance();
        int[] nums = {1,3,1};
        int k = 1;
        int result = findKthSmallestPairDistance.smallestDistancePair(nums,k);
        System.out.println(result);

        nums = new int[]{1, 6, 1};
        k = 3;
        System.out.println(findKthSmallestPairDistance.smallestDistancePair(nums,k));
    }
}
