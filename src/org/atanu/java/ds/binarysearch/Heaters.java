package org.atanu.java.ds.binarysearch;

import java.util.Arrays;

//https://leetcode.com/problems/heaters/description/
//Leetcdoe 475

// The Goal is to find the maximum radius of a heater
// For each house, find its position between those heaters (thus we need the heaters array to be sorted).
// Calculate the distances between this house and left heater and right heater, get a MIN value of those two values.
// Corner cases are there is no left or right heater.
// Get MAX value among distances in step 2. It's the answer.

//Video : https://www.youtube.com/watch?v=xR2SzAmiUpM&t=1281s . will get the idea in first 5 minute itself

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        //sort heaters
        Arrays.sort(heaters);
        int minRadius = 0;

        for(int house : houses){
            HeaterPosition heaterPosition = getClosestHeaters(heaters, house);
            int leftDistance = heaterPosition.justLeftHeater != -1 ? house - heaterPosition.justLeftHeater : Integer.MAX_VALUE;
            int rightDistance = heaterPosition.justRightHeater != -1 ? heaterPosition.justRightHeater -  house : Integer.MAX_VALUE;
            //System.out.println("leftDistance "+ leftDistance +" rightDistance "+rightDistance +" " );
            int minDistanceToHeaterFromThisHouse = Math.min(leftDistance, rightDistance);
            minRadius = Math.max(minRadius, minDistanceToHeaterFromThisHouse);
        }

        return minRadius;
    }

    //Binary Search
    private HeaterPosition getClosestHeaters(int[] heaters, int house){
        HeaterPosition heaterPosition = new HeaterPosition(-1, -1);

        int low = 0;
        int high = heaters.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(heaters[mid] == house){
                heaterPosition.justLeftHeater = heaters[mid];
                heaterPosition.justRightHeater = heaters[mid];
                return heaterPosition;
            }
            else if(heaters[mid] < house){
                heaterPosition.justLeftHeater = heaters[mid]; // Basically Getting Floor
                low = mid + 1;
            }else{
                heaterPosition.justRightHeater = heaters[mid]; // Basically Getting Ceiling
                high = mid - 1;
            }
        }
        return heaterPosition;
    }

    private static class HeaterPosition{
        int justLeftHeater;
        int justRightHeater;

        HeaterPosition(int justLeftHeater, int justRightHeater){
            this.justLeftHeater = justLeftHeater;
            this.justRightHeater = justRightHeater;
        }

    }

    public static void main(String[] args) {
        Heaters heater = new Heaters();
        int[] houses = {1,2,3,4};
        int[] heaters = {1,4};
        //Output: 1
        //Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
        System.out.println(heater.findRadius(houses, heaters));
    }
}
