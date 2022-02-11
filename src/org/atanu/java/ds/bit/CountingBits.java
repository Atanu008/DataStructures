package org.atanu.java.ds.bit;

//https://leetcode.com/problems/counting-bits/
//LeetCode 338
public class CountingBits {

    public int[] countBits(int n) {

        int[] countBits = new int[n+1];
        for(int i = 0; i <=n ; i++){
            countBits[i] = getCountBit(i);
        }
        return countBits;
    }

    //Brian Kernighan’s algorithm //Can check Educative
    private int getCountBit(int n){
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

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int n = 5;
        //Output: [0,1,1,2,1,2]
        //Explanation:
        //0 --> 0
        //1 --> 1
        //2 --> 10
        //3 --> 11
        //4 --> 100
        //5 --> 101
        int[] result = countingBits.countBits(n);
    }
}
