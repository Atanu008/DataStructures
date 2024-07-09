package org.bgd.java.ds.plainrecursion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <a href="https://www.geeksforgeeks.org/problems/subset-sums2234/1">...</a>
 * Given a list arr of n integers, return sums of all subsets in it. Output sums can be printed in any order.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * n = 2
 * arr[] = {2, 3}
 * Output:
 * 0 2 3 5
 * Explanation:
 * When no elements is taken then Sum = 0.
 * When only 2 is taken then Sum = 2.
 * When only 3 is taken then Sum = 3.
 * When element 2 and 3 are taken then
 * Sum = 2+3 = 5.
 * Example 2:
 *
 * Input:
 * n = 3
 * arr = {5, 2, 1}
 * Output:
 * 0 1 2 3 5 6 7 8
 */
public class SubSetSums {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> sums =new ArrayList<>();
        Collections.sort(arr);
        subsetSums(arr, 0, 0, sums);
        return sums;
    }

    private void subsetSums(ArrayList<Integer> arr, int ind, int sum, ArrayList<Integer> sums) {
       if(ind == arr.size()) {
           sums.add(sum);
           return;
       }
       subsetSums(arr, ind + 1, sum + arr.get(ind), sums);
        subsetSums(arr, ind + 1, sum, sums);

    }
}
