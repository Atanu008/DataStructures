package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/first-bad-version/
//LeetCode 278
public class FirstBadVersion {

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
        public int firstBadVersion(int n) {
            int low = 1;
            int high = n;

            while(low < high){

                int mid = low + (high -low)/2;
                if(isBadVersion(mid)){
                    high = mid;
                }
                else{
                    low = mid + 1;
                }
            }

            return high;
        }

        private boolean isBadVersion(int mid) {
            return true;
        }
    }
