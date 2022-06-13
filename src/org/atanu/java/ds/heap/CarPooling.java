package org.atanu.java.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/car-pooling/
//LeetCode 1094
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<PoolDrop> minHeap = new PriorityQueue<>((a, b) -> a.endLocation - b.endLocation);
        int currentPassengers = 0;
        for(int[] trip : trips) {

            int numPassengers = trip[0];
            int startLocation = trip[1];
            int endLocation = trip[2];

            while(!minHeap.isEmpty() && minHeap.peek().endLocation <= startLocation){
                // System.out.println("Helloo"+ minHeap.peek().numPassengers);
                currentPassengers -= minHeap.poll().numPassengers;
            }


            currentPassengers += numPassengers;

            if(currentPassengers > capacity){
                return false;
            }

            minHeap.offer(new PoolDrop(endLocation, numPassengers));
        }

        return true;
    }

    static class PoolDrop {
        int endLocation;
        int numPassengers;

        public PoolDrop(int endLocation, int numPassengers){
            this.endLocation = endLocation;
            this.numPassengers = numPassengers;
        }
    }

    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,3,7}};
        int capacity = 4;
        CarPooling carPooling = new CarPooling();
        System.out.println(carPooling.carPooling(trips, capacity));
        capacity = 5;
        System.out.println(carPooling.carPooling(trips, capacity));
    }
}
