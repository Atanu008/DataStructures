package org.atanu.java.ds.array;

//https://leetcode.com/problems/two-furthest-houses-with-different-colors/
//LeetCode 2078
public class TwoFurthestHousesWithDifferentColors {

    //Brute Force
    public int maxDistance(int[] colors) {
        int max = 0;
        for(int i = 0; i < colors.length -1; i++){
            for(int j = i +1 ; j < colors.length; j++){
                if(colors[i] != colors[j]){
                    max = Math.max(max, Math.abs(i-j));
                }
            }
        }

        return max;
    }

    //O(N) solution
    /** Algorithm
     1. The max distance must be between two possibilies:
     - one house [0] and one house between [n..1] OR
     - one from from [N] and one house from [0...n-1].
     2. Traverse the array twice, once from left and once from right and measure the max from both sides.
     3. Return the max of both traversals.
     */
    public int maxDistanceV2(int[] colors) {
        int max = 1;
        // select house[0] and look for houses from n,n-1, n-2 .. 1. Break at the first found as this is the max
        for (int i = colors.length -1; i >= 1; i--) {
            if (colors[0] != colors[i]) {
                max = Math.max(max, i);
                break;
            }
        }
        // select house[n] and look for houses from 0,1...n-1. Break at the first found as this is the max
        for(int i = 0; i < colors.length -1; i++) {
            if (colors[i] != colors[colors.length -1]) {
                max = Math.max(max, colors.length -1 - i);
                break;
            }
        }
        return max;
    }
}
