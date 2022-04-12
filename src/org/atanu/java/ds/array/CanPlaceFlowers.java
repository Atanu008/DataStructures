package org.atanu.java.ds.array;

//https://leetcode.com/problems/can-place-flowers/
//LeetCode 605
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int flowerPlaceCount = 0;
        /*if(n == 0){
            return true;
        }*/

        for(int i = 0; i < flowerbed.length; i++){

            if(flowerbed[i] == 0){

                //First first elemnt(i== 0) there is no prev so prevPlot will be true
                boolean prevPlot = (i == 0) || (flowerbed[i-1] == 0);

                //First last elemnt(i== flowerbed.length -1) there is no prev so nextPlot will be true
                boolean nextPlot = (i == flowerbed.length -1) || (flowerbed[i+1] == 0);

                //If Prev and Next both plots are empty . plcae the flower.
                //If we can reach the flower limit return true
                if(prevPlot && nextPlot){

                    flowerbed[i] = 1;//Place the flower
                    flowerPlaceCount++;

                    if(flowerPlaceCount >= n){
                        return true;
                    }
                }
            }
        }
        //we could not place all the flowers . we could hav just retun false
        //But if the input
        //return false; // for n == 0 it should retun true. either write base case for zero for use below
        return flowerPlaceCount >= n;
    }
}
