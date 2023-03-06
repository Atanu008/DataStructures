package org.atanu.java.ds.bit;

//https://leetcode.com/problems/hamming-distance/description//
//Leetcode 461

public class HammingDistance {

    //We need to count number of positions at which the bits differ for given numbers x and y.
    //For this, we can use bit-wise XOR. The xor of two bits is set only if they differ.
    //So, we need to xor and count the number of set bits in it.
    public int hammingDistance(int x, int y) {

        int num = x ^ y; // bit-wise XOR. The xor of two bits is set only if they differ.
        int hammingDistance = 0;
        //check number of set bit
        while(num != 0){
            if((num & 1) == 1){ // check if the last(right) bit is set
                hammingDistance++;
            }
            num = num >> 1; //right shift
        }
        return hammingDistance;
    }

    //Same as above just checking the set bit is different(num % 2 != 0)
    public int hammingDistance_v1(int x, int y) {

        int num = x ^ y; // bit-wise XOR. The xor of two bits is set only if they differ.
        int hammingDistance = 0;
        //check number of set bit
        while(num != 0){
            if(num % 2 != 0){ // check if the last(right) bit is set
                hammingDistance++;
            }
            num = num >> 1; //right shift
        }
        return hammingDistance;
    }

    //We can also iterate over each bit of the given numbers manually and then compare the bits at each position. To check if the ith bit of a number x is set, we can perform- (x >> i) & 1. If the bit differ at a given position, we increment the count of hamming distance.
    public int hammingDistance_v2(int x, int y) {
        int hammingDistance = 0;
        //check number of set bit
        while(x != 0 || y != 0){
            if(x % 2 != y % 2){ // check if the last(right) bit is NOT equal for both
                hammingDistance++;
            }
            //right shift both
            x = x >> 1;
            y = y >> 1;
        }
        return hammingDistance;
    }

    //same as above . just the last bit check is different
    public int hammingDistance_v2a(int x, int y) {
        int hammingDistance = 0;
        //check number of set bit
        while(x != 0 || y != 0){
            if((x & 1) != (y & 1)){ // check if the last(right) bit is NOT equal for both
                hammingDistance++;
            }
            //right shift both
            x = x >> 1;
            y = y >> 1;
        }
        return hammingDistance;
    }
}
