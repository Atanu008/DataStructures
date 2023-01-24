package org.atanu.java.ds.math;

//https://leetcode.com/problems/water-bottles/description/
//Leetcode 1518
public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {

        int FullBottlesCount = 0;
        int emptyBottlesCount = 0;

        while(numBottles > 0){
            FullBottlesCount += numBottles;
            emptyBottlesCount += numBottles;
            numBottles = emptyBottlesCount / numExchange;
            emptyBottlesCount = emptyBottlesCount % numExchange;
        }

        return FullBottlesCount;
    }

    public static void main(String[] args) {
        int numBottles = 9, numExchange = 3;
        int bottleCount = new WaterBottles().numWaterBottles(numBottles, numExchange);
        System.out.println(bottleCount);
    }
}
