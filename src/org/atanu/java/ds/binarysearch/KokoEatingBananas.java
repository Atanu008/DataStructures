package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/koko-eating-bananas/
//LeetCode 875
//Video : https://www.youtube.com/watch?v=LzZFUTWE55c

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = piles[0];

        //Max pile element will be the max speed at which
        for(int a : piles){
            high = Math.max(high, a);
        }

        //To Minimize speed we need t Go left.
        //High will help to Go left . Set high to mid when possible speed found
        while(low < high){

            int mid = low + (high - low)/2;

            if(canEatAllBanana(piles, h, mid)){
                high = mid;
            }
            else{
                low = mid +1;//Need to increase speed
            }
        }

        return high;
    }

    // Can Koko eat all bananas in H hours with eating speed currentSpeed?
    //To find the value of possible(K),
    //(ie. whether Koko with an eating speed of K can eat all bananas in H hours),
    //we simulate it. For each pile of size p > 0,
    //we can deduce that Koko finishes it in Math.ceil(p / K)

    //and we add these times across all piles and compare it to H.
    public boolean canEatAllBanana(int[] piles, int h, int currentSpeed){

        long time = 0;
        for(int p: piles){
            time += p / currentSpeed;
            if(p % currentSpeed != 0){
                time++;
            }
        }
        return time <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println("Minimum speed is "+ kokoEatingBananas.minEatingSpeed(piles,h));
    }
}
