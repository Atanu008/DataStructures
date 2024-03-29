package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/h-index-ii/description/
// Leetcode 275

public class HIndexII {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;

        // We need to find the rightmost 'index' such that: (citations[index] <= n - index)
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // There's (n - mid) papers with an equal or higher citation count than citations[mid]
            // If (citations[mid] == n - mid) it's the optimal result and can be returned right away
            if (citations[mid] == n - mid)
                return citations[mid];

            // If citations[mid] is less than (n - mid), narrow down on the right half to look for a paper
            // at a future index that meets the h-index criteria. Otherwise, narrow down on the left half
            if (citations[mid] < n - mid)
                left = mid + 1;
            else
                right = mid - 1;
        }

        // We didn't find an exact match, so there's exactly (n - left) papers that have citations
        // greater than or equal to citations[left] and that is our answer
        return n - left;
    }

    public static void main(String[] args) {
        HIndexII hIndexII = new HIndexII();
        int[] citations = {0,1,3,5,6};
        System.out.println(hIndexII.hIndex(citations));
    }
}
