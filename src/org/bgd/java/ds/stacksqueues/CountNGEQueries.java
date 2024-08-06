package org.bgd.java.ds.stacksqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-nges-to-the-right">...</a>
 * Given an array of N integers and Q queries of indices, print the number of next greater elements(NGEs) to the right of the given index element.
 * Example:
 *
 * Input:  arr     = [3, 4, 2, 7, 5, 8, 10, 6]
 *         queries = 2
 *         indices = [0, 5]
 * Output:  6, 1
 * Explanation:
 * The next greater elements to the right of 3(index 0)
 * are 4,7,5,8,10,6.
 * The next greater elements to the right of 8(index 5)
 * is only 10.
 *
 *
 */
public class CountNGEQueries {
    public static int[] count_NGEs(int N, int[] arr, int queries, int[] indices) {
        int[] result = new int[queries];
        int k = 0;
        for (int ind : indices) {
            int start = arr[ind];
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(start);
            for (int i = ind + 1; i < N; i++) {
                if (arr[i] > start) {
                    stack.push(arr[i]);
                }
            }
            result[k++] = stack.size() - 1;
        }
        return result;
    }

}
