package org.bgd.java.ds.plainrecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutation-sequence/editorial/">...</a>
 *
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 */
public class KthPermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for(int i= 1; i<n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k -= 1;
        StringBuilder sb = new StringBuilder();

        while(true) {
            int block = k / fact;
            sb.append(numbers.get(block));
            numbers.remove(block);
            if(numbers.isEmpty()) {
                break;
            }
            k %= fact;
            fact /= numbers.size();
        }
        return sb.toString();
    }


}
