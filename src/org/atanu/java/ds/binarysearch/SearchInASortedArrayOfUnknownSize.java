package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
//LeetCode 702
//https://www.educative.io/courses/grokking-the-coding-interview/B1ZW38kXJB2

interface ArrayReader {
     public int get(int index);
 }
public class SearchInASortedArrayOfUnknownSize {

    public int search(ArrayReader reader, int target) {

        int low = 0;
        int high = 1;

        //Define Search Boundaries
        while(reader.get(high) < target) {
            low = high;
            high = high * 2; // increase to double the bounds size
        }

        while(low <= high) {

            int mid = low + (high - low)/2;
            int num = reader.get(mid);

            if(num == target) {
                return mid;
            }

            else if(target < num) {
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }

        // there is no target element
        return -1;
    }
}
