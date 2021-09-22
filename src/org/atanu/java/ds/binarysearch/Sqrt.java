package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/sqrtx/
//LeetCode 69
public class Sqrt {

    //This implemetation is same as the finding right most element in sorted array
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int low = 1, high = x;
        while (low < high) {
            // +1 since by default integer division leans towards left.
            int mid = low + (high - low) / 2 +1;
            // if mid <= can be our possible and we need to go to right. So lo has to help
            if ( mid <= x / mid) {
                low = mid;
            } else {
                // if mid*mid > x then right part can not part of the solution. discard it
                high = mid -1;
            }
        }
        return low;

    }

    //This implemetation is also same as the finding right most element in sorted array
    public int mySqrtV2(int x) {
        if (x == 0)
            return 0;
        int low = 1, high = x;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(mid == x / mid){
                return mid;
            }
            else if( mid < x / mid) {
                low = mid +1;
                ans = mid;
            } else {
                high = mid -1;
            }
        }
        return ans;

    }

    //Return decimal places
    public float mySqrtV3(int x, int p) {
        if (x == 0)
            return 0;
        int low = 1, high = x;
        double ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(mid == x / mid){
                ans = mid;
                break;
            }
            else if( mid < x / mid) {
                low = mid +1;
                ans = mid;
            } else {
                high = mid -1;
            }
        }
        System.out.println(ans);
        //Linear search for each place
        double inc = 0.1;
        for(int i = 0; i <p; i++){
            while(ans*ans <= x){
                ans += inc;
            }
            ans = ans - inc;
            inc = inc/10;
        }

        return (float)ans; // return double is not working . Need to look into

    }

    public static void main(String[] args) {
        int n = 50;
        Sqrt sqrt = new Sqrt();
        System.out.println("Sqrt of "+n +" is "+sqrt.mySqrt(n));
        System.out.println("Sqrt of "+n +" is "+sqrt.mySqrtV2(n));
        System.out.println("Sqrt of "+n +" is "+sqrt.mySqrtV3(n,3));
    }
}
