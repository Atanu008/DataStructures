package org.atanu.java.ds.math;

//LeetCode 50
//https://leetcode.com/problems/powx-n/
public class Pow {
    public double myPow(double x, int n) {
        return powerUtil(x,n);
    }

    private double powerUtil(double x, long n){
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        if(n < 0)
            return powerUtil(1/x, -n);
        double result = powerUtil(x*x, n/2);
        if((n & 1) == 1) // Multiply x if n is Odd
            result *= x;
        return result;
    }

    public double myPowV2(double x, int n) {
        return powerUtilV2(x,n);
    }

    private double powerUtilV2(double x, long n){
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        if(n < 0)
            return powerUtilV2(1/x, -n);
        //If Odd N
        if((n&1) == 1)
            return x * powerUtilV2(x, n-1);
        //Even N
        return powerUtilV2(x*x, n/2);

    }

    public double myPowV3(double x, int n) {
        double result = 1;
        long N = Math.abs((long)n); //Make postive and assign to log to avoid overflow

        while(N > 0){
            // For Odd N
            //eventually this condition will execute once N = 1 . and the final x will mutilplied
            if((N&1) == 1){
                result = result*x;
            }
            x *=x;
            N /=2;
        }
        return (n<0) ? 1/result : result;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        double x = 2;
        int n = 8;
        double result = pow.myPow(2,8);
        System.out.println("Power is "+ result);
    }
}
