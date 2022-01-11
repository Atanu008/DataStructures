package org.atanu.java.ds.bit;

//https://leetcode.com/problems/number-of-1-bits/
//LeetCode 191
public class NumberOf1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        // n = 5 .     101
        // n-1= 4.     100
        // n & (n-1) = 100 // So we marked the least sginifact bit to zero
        // Now if we proceed further it will take one more step to remove the last 1
        // By performing 4&3 i.e n&(n-1) as currently
        // this while loop counts no of time least significant bit is set
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n-1); // marking the least significant bit
        }
        return count;
    }

    public int hammingWeightV2(int n) {

        int count = 0;
        while(n != 0){
            int last_bit = n &1;
            count += last_bit; //if nth bit is 1 then last_bit will be 1 , otherwise 0
            n = n >>> 1; //Right sift  //Need to check why >> not working
        }
        return count;
    }

    public static void main(String[] args) {

        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
        int n = 00000000000000000000000000001011;
        System.out.println("Number of 1 Bits is "+ numberOf1Bits.hammingWeight(n));
        System.out.println("Number of 1 Bits is "+ numberOf1Bits.hammingWeightV2(n));
    }
}
