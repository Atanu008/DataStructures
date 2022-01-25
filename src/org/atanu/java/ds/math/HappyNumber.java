package org.atanu.java.ds.math;

import java.util.HashSet;
import java.util.Set;

//LeetCode 202
//https://leetcode.com/problems/happy-number/
public class HappyNumber {

    //The idea is to use one hash set to record sum of every digit square of every number occurred.
    //Once the current sum cannot be added to set, return false;
    //once the current sum equals 1, return true;
    public boolean isHappy(int n) {
        int original = n;
        Set<Integer> set = new HashSet<>();
        while(n > 0){

            int temp = n;
            int sum = 0;
            while(temp > 0) {
                int rem = temp%10;
                sum += rem*rem;
                temp = temp/10;
            }

            if(sum == 1) {
                return true;
            }
            else if(set.contains(sum)) {
                return false;
            }
            else {
                set.add(n);
                n = sum;
            }

        }
        return false;
    }

    public boolean isHappyV2(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int squareSum = 0;
            while (n > 0) {
                int remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }


    //https://www.educative.io/courses/grokking-the-coding-interview/39q3ZWq27jM
    public boolean isHappyV3(int n) {

        int slow = n;
        int fast = n;

        do{
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        }while(slow != fast);

        return slow == 1;
    }

    private int findSquareSum(int num) {

        int squareSum = 0;
        while(num > 0){
            int digit = num % 10;
            squareSum += digit*digit;
            num = num/10;
        }

        return squareSum;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        int n = 19;
        boolean result = happyNumber.isHappyV2(n);

        System.out.println(n+" is a happy  "+ result);
    }
}
