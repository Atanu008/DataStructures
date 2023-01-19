package org.atanu.java.ds.greedy;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/
//Leetcode 2279
public class MaximumBagsWithFullCapacityOfRocks {
    //we need to calculate the remaining capacity of each bag i, by letting its capacity capacity[i] substract the number of rocks it currently has rocks[i]. That is: remaining capacity of bag i = capacity[i] - rocks[i].

//As we would like to full as many bags as possible, we will fill the bag with the smallest remaining capacity first.

//Therefore, we should sort all the bags by the order of remaining capacity, then start to fill them using additionalRocks from the bag with the smallest remaining capacity. This process stops when we don't have enough rocks to fill the current bag.

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int n = capacity.length;
        int[] remaining = new int[n];

        for(int i = 0; i< n; i++){
            remaining[i] = capacity[i] - rocks[i];
        }
        // Sort bags by the remaining capacity.
        Arrays.sort(remaining);
        int fullBags = 0;

        // Iterate over sorted bags and fill them using additional rocks.
        for(int i = 0; i < n; i++){
            // If we can fill the current one, fill it and move on.
            // Otherwise, stop the iteration.
            if(additionalRocks >= remaining[i]){
                additionalRocks -= remaining[i];
                fullBags++;
            }
            else{
                break; //return count only :)
            }
        }
        // Return `fullBags` after the iteration stops.
        return fullBags;
    }

    public static void main(String[] args) {
        MaximumBagsWithFullCapacityOfRocks maximumBagsWithFullCapacityOfRocks = new MaximumBagsWithFullCapacityOfRocks();
        int[] capacity = {2,3,4,5};
        int[] rocks = {1,2,4,4};
        int additionalRocks = 2;
        int fullBags = maximumBagsWithFullCapacityOfRocks.maximumBags(capacity, rocks, additionalRocks);
        System.out.println(fullBags);
    }
}
