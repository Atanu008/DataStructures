package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/cutting-ribbons/
//LeetCode 1891
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
