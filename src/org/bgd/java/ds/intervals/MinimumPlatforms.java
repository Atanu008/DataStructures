package org.bgd.java.ds.intervals;

import java.util.Arrays;

/**
 * <a href="https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1">...</a>
 *
 *Minimum Platforms
 * MediumAccuracy: 26.84%Submissions: 418K+Points: 4
 * Be the comment of the day in POTD and win a GfG T-Shirt!
 * Solve right now
 * banner
 * Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
 * Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.
 *
 *
 * Example 1:
 *
 * Input: n = 6
 * arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
 * dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
 * Output: 3
 * Explanation:
 * Minimum 3 platforms are required to
 * safely arrive and depart all trains.
 * Example 2:
 *
 * Input: n = 3
 * arr[] = {0900, 1100, 1235}
 * dep[] = {1000, 1200, 1240}
 * Output: 1
 * Explanation: Only 1 platform is required to
 * safely manage the arrival and departure
 * of all trains.
 */
public class MinimumPlatforms {

    int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int arr_index = 1, dep_index = 0;
        int platforms = 1;

        int ans = 1;

        while (arr_index < n && dep_index < n) {
            if (arr[arr_index] <= dep[dep_index]) {
                platforms += 1;
                arr_index += 1;
            } else if (arr[arr_index] > dep[dep_index]) {
                platforms -= 1;
                dep_index += 1;
            }
            ans = Math.max(ans, platforms);
        }
        return ans;
    }
}
