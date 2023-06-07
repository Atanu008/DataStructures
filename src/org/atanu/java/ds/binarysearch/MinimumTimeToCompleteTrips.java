package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/minimum-time-to-complete-trips/description/
// Leetcode 2187
public class MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {

        long low = 1;
        long minTripTime = time[0];

        for(int t : time){
            minTripTime = Math.min(minTripTime, t);
        }
        // time = [1,2,3], totalTrips = 3
        // In this case maximum time we may need is 3 right . for first bus to run 3 time (1 * 3)
        long high = minTripTime * totalTrips;

        while(low < high){

            long mid = low + (high - low) / 2;

            if(possibleTrips(time, mid, totalTrips)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }

        return high;
    }

    private boolean possibleTrips(int[] time, long possibleTime, int totalTrips){

        long totalPossibleTrip = 0;
        for(int t : time){
            totalPossibleTrip += possibleTime / t;
        }
        return totalPossibleTrip >= totalTrips;
    }

    public static void main(String[] args) {
        MinimumTimeToCompleteTrips minimumTimeToCompleteTrips = new MinimumTimeToCompleteTrips();

        //Input: time = [1,2,3], totalTrips = 5
        //Output: 3
        //Explanation:
        //- At time t = 1, the number of trips completed by each bus are [1,0,0].
        //  The total number of trips completed is 1 + 0 + 0 = 1.
        //- At time t = 2, the number of trips completed by each bus are [2,1,0].
        //  The total number of trips completed is 2 + 1 + 0 = 3.
        //- At time t = 3, the number of trips completed by each bus are [3,1,1].
        //  The total number of trips completed is 3 + 1 + 1 = 5.
        //So the minimum time needed for all buses to complete at least 5 trips is 3.

        int[] time = {1,2,3};
        int totalTrips = 5;
        long minimumTime = minimumTimeToCompleteTrips.minimumTime(time, totalTrips);
        System.out.println(minimumTime);
    }
}
