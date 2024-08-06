package org.bgd.java.ds.binarysearch.bsOnAnswer;

/**
 * https://leetcode.com/problems/h-index
 *
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 *
 *
 *
 * Example 1:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * Example 2:
 *
 * Input: citations = [1,3,1]
 * Output: 1
 */
public class HIndex {
    public int hIndex(int[] citations) {

        int l = 0, r = citations.length;

        while (l < r) {
            int m = (l + r + 1) / 2;
            if (fulfilCitations(citations, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private boolean fulfilCitations(int[] citations, int count) {
        int c = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= count) {
                c++;
            }
        }
        return c >= count;
    }
}
