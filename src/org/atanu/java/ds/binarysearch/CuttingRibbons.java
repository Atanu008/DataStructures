package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/cutting-ribbons/
//LeetCode 1891

//You are given an integer array ribbons, where ribbons[i] represents the length of the ith ribbon, and an integer k.
// You may cut any of the ribbons into any number of segments of positive integer lengths, or perform no cuts at all.
//
//For example, if you have a ribbon of length 4, you can:
//Keep the ribbon of length 4,
//Cut it into one ribbon of length 3 and one ribbon of length 1,
//Cut it into two ribbons of length 2,
//Cut it into one ribbon of length 2 and two ribbons of length 1, or
//Cut it into four ribbons of length 1.
//Your goal is to obtain k ribbons of all the same positive integer length. You are allowed to throw away any excess ribbon as a result of cutting.
//
//Return the maximum possible positive integer length that you can obtain k ribbons of, or 0 if you cannot obtain k ribbons of the same length.

public class CuttingRibbons {

    public int maxLength(int[] ribbons, int k) {

        int maxRibbon = 0;
        for(int ribbon : ribbons){
            maxRibbon = Math.max(maxRibbon, ribbon);
        }

        int low = 0;
        int high = maxRibbon;

        //As we need to choose maximum , So Go Right
        while(low < high){

            int mid = low + (high - low) / 2 + 1; //As search right . need to add 1
            // Possible to cut with mid as maximum ribbon length
            // Go right to try max possibilities
            if(canCutRibbons(ribbons, mid, k)){
                low = mid;
            }
            else{
                high = mid - 1;
            }

        }

        return low;
    }

    private boolean canCutRibbons(int[] ribbons, int length, int k){

        int cutCount = 0;

        for(int ribbon : ribbons){
            cutCount += ribbon / length;
        }

        return cutCount >= k;
    }

    public static void main(String[] args) {
        CuttingRibbons cuttingRibbons = new CuttingRibbons();
        int[] ribbons = {9,7,5};
        int k = 3;
        //Output: 5
        //Explanation:
        //- Cut the first ribbon to two ribbons, one of length 5 and one of length 4.
        //- Cut the second ribbon to two ribbons, one of length 5 and one of length 2.
        //- Keep the third ribbon as it is.
        //Now you have 3 ribbons of length 5.
        int result = cuttingRibbons.maxLength(ribbons, k);
        System.out.println(result);
    }
}
