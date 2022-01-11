package org.atanu.java.ds.string;

//https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
//LeetCode 1578
public class MinimumTimeToMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {

        int result = 0;
        int groupSum = 0;
        int groupMax = 0;

        for(int i = 0; i < neededTime.length; i++){
            //Calculate result when two consucutive element is not same color
            if(i > 0 && colors.charAt(i) != colors.charAt(i-1)){

                // Need to keep the groupMax only . Take all expect the groupMax
                // 1 4 8 2 5 if al the element sis same color then we need to keep only 8 .
                // 1+4+2+5 will be added to the result;
                result += groupSum - groupMax;
                groupSum = 0;
                groupMax = 0;
            }
            groupSum += neededTime[i]; // add same colors in group
            groupMax = Math.max(groupMax, neededTime[i]); //Track maximim iin group
        }

        //For last Group need to calculate
        result += groupSum - groupMax;

        return result;
    }

    public static void main(String[] args) {
        MinimumTimeToMakeRopeColorful time = new MinimumTimeToMakeRopeColorful();
        String colors = "abaac";
        int[] neededTime = {1,2,3,4,5};

        System.out.println("Minimum Time to Make Rope Colorful is "+ time.minCost(colors, neededTime));
    }
}
