package org.atanu.java.ds.array;

//https://leetcode.com/problems/maximize-distance-to-closest-person/description
//Leetcode 849
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {

        int leftSeat = -1;
        int maxDistance = 0;
        int n = seats.length;

        for(int right = 0; right < n; right++){

            if(seats[right] == 1){

                if(leftSeat == -1){
                    maxDistance = right;
                }
                else{
                    maxDistance = Math.max(maxDistance, (right-leftSeat)/2);
                }

                leftSeat = right;
            }
        }

        if(seats[n-1] == 0){
            maxDistance = Math.max(maxDistance, n -1 - leftSeat);
        }

        return maxDistance;
    }
}
