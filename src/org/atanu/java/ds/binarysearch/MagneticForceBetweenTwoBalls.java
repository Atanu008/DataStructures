package org.atanu.java.ds.binarysearch;

import java.util.Arrays;

// https://leetcode.com/problems/magnetic-force-between-two-balls/description/
// Leetcode 1552
public class MagneticForceBetweenTwoBalls {

    //minimum magnetic force between any two balls is maximum
    //Key to This algo is we need to maximize the distance , So we need to go right
    //T, T, T, T, T, ..... T, F, F, F .... (Can we place all m balls if minimum distance were above number? T = true, F = false)
    //Now, we need to find last occurrence of true in above array.
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        //max distance could be teh distance between the first position and the last position as the array is sorted.
        //So try from 0 To Max distance.
        // We can do binary search and figure out for that range if we can place M balls.
        // As we need to maximize the distace we need to go right.
        int left = 0, right = position[n-1] - position[0];
        while (left < right) {
            int mid = left + (right - left) / 2 + 1; // To Go right. Check Binary search Templates
            //This means we can pplace it , go right to check if with bigger distance its possible
            //left will be a possible solution at any given point
            if (possibleToPlaceMBallsWithMinDist(position, mid, m))
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }

    private boolean possibleToPlaceMBallsWithMinDist(int[] position, int minDist, int m) {

        // Always place first object at position[0]
        int cur = position[0];
        int count = 1; // As we are starting with one ball  , in loop we are checking distance from next ball 
        for (int i = 1; i < position.length; i++) {
            // We can place the ball only if this ball is farther than the previous ball by minimumDistance
            // increment ball count
            if (position[i] - cur >= minDist) {
                count++;
                cur = position[i];
            }
        }
        return count >= m; // If placing m ball is possible with minDist
    }

    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;
        MagneticForceBetweenTwoBalls magneticForceBetweenTwoBalls = new MagneticForceBetweenTwoBalls();
        int result = magneticForceBetweenTwoBalls.maxDistance(position, m);
        System.out.println(result);
        //Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
    }
}
