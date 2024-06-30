package org.bgd.java.ds.arrays;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://www.naukri.com/code360/problems/merge-k-sorted-arrays_975379">...</a>
 *
 * Merge K Sorted Arrays
 *
 * You have been given ‘K’ different arrays/lists, which are sorted individually (in ascending order). You need to merge all the given arrays/list such that the output array/list should be sorted in ascending order.
 *
 *
 * Sample Input 1:
 * 1
 * 2
 * 3
 * 3 5 9
 * 4
 * 1 2 3 8
 * Sample Output 1:
 * 1 2 3 3 5 8 9
 * Explanation of Sample Input 1:
 * After merging the two given arrays/lists [3, 5, 9] and [ 1, 2, 3, 8], the output sorted array will be [1, 2, 3, 3, 5, 8, 9].
 * Sample Input 2:
 * 1
 * 4
 * 3
 * 1 5 9
 * 2
 * 45 90
 * 5
 * 2 6 78 100 234
 * 1
 * 0
 * Sample Output 2:
 * 0 1 2 5 6 9 45 78 90 100 234
 * Explanation of Sample Input 2 :
 * After merging the given arrays/lists [1, 5, 9], [45, 90], [2, 6, 78, 100, 234] and [0], the output sorted array will be [0, 1, 2, 5, 6, 9, 45, 78, 90, 100, 234].
 *
 */
public class MergeKSortedArrays {
    public ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        int rows = kArrays.size();
        Queue<Entry> pq = new PriorityQueue<>(rows);
        for (int i = 0; i < rows; i++) {
            if (!kArrays.get(i)
              .isEmpty())
                pq.offer(new Entry(kArrays.get(i)
                  .get(0), 0, i));
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while (!pq.isEmpty()) {
            Entry top = pq.poll();
            answer.add(top.val);
            int nextIndex = top.index + 1;
            if (nextIndex < kArrays.get(top.arr)
              .size()) {
                pq.offer(new Entry(kArrays.get(top.arr)
                  .get(nextIndex), nextIndex, top.arr));
            }
        }
        return answer;
    }

    class Entry implements Comparable<Entry> {
        int val;
        int index;
        int arr;

        Entry(int val, int index, int arr) {
            this.val = val;
            this.index = index;
            this.arr = arr;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(this.val, o.val);
        }
    }
}
