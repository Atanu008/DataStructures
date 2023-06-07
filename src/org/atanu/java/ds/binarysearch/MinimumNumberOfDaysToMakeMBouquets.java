package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
//LeetCode 1482

//Same like Book Allocations problems
public class MinimumNumberOfDaysToMakeMBouquets {

    public int minDays(int[] bloomDay, int m, int k) {

        int totalFlowerNeeded = m*k;
        //Return -1 if there is less flower
        if(totalFlowerNeeded > bloomDay.length){
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int day: bloomDay){
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        //Need Minimum. To minimize we need to go left.
        //High will play that role.
        //If we can make bouquet with Mid then we will set high to mid. As this is possible candidate
        while(low < high){

            int mid = low + (high - low)/2;

            if(canMakeBouquets(bloomDay, m, k, mid)){
                high = mid;
            }
            else{
                low = mid +1;
            }
        }

        return high;
    }

    public boolean canMakeBouquets(int[] bloomDay, int bouquets, int flowersInOnebouquet, int midDay){

        int flowersCollected = 0;
        int bouquetsCreated = 0;

        for(int day: bloomDay){
            //Take the flower if current day is less than or equal mid
            if(day <= midDay){
                flowersCollected++;
            }
            else{//set flowersCollected to 0 if we can not take this as the steak has to be in sequence
                flowersCollected = 0;
            }

            //Make a bouquet if possible
            if(flowersCollected == flowersInOnebouquet){
                bouquetsCreated++;
                flowersCollected = 0;
            }
        }

        //Return true if we can make desired bouquets in mdiDay
        return bouquetsCreated >= bouquets;
    }

    public static void main(String[] args) {

        MinimumNumberOfDaysToMakeMBouquets mBouquets = new MinimumNumberOfDaysToMakeMBouquets();

        int[] bloomDay = {1,10,3,10,2};
        int m = 3, k = 1;
        //Output: 3
        //Explanation: Let's see what happened in the first three days. x means flower bloomed and _ means flower didn't bloom in the garden.
        //We need 3 bouquets each should contain 1 flower.
        //After day 1: [x, _, _, _, _]   // we can only make one bouquet.
        //After day 2: [x, _, _, _, x]   // we can only make two bouquets.
        //After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
        System.out.println("Minumum Number of Days is "+ mBouquets.minDays(bloomDay,m,k));

        bloomDay = new int[]{7, 7, 7, 7, 12, 7, 7};
        m = 2;
        k = 3;
        //Output: 12
        //Explanation: We need 2 bouquets each should have 3 flowers.
        //Here's the garden after the 7 and 12 days:
        //After day 7: [x, x, x, x, _, x, x]
        //We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
        //After day 12: [x, x, x, x, x, x, x]
        //It is obvious that we can make two bouquets in different ways.
        System.out.println("Minumum Number of Days is "+ mBouquets.minDays(bloomDay,m,k));
    }
}
