package org.bgd.java.ds.heapandquickselect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/task-scheduler/description/">...</a>
 *
 * You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n.
 * Each cycle or interval allows the completion of one task.
 * Tasks can be completed in any order, but there's a constraint:
 * identical tasks must be separated by at least n intervals due to cooling time.
 *
 * Return the minimum number of intervals required to complete all tasks.
 *
 *
 *
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 *
 * Output: 8
 *
 * Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 * After completing task A, you must wait two cycles before doing A again.
 * The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle.
 * By the 4th cycle, you can do A again as 2 intervals have passed.
 *
 * Example 2:
 *
 * Input: tasks = ["A","C","A","B","D","B"], n = 1
 *
 * Output: 6
 *
 * Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
 *
 * With a cooling interval of 1, you can repeat a task after just one other task.
 *
 * Example 3:
 *
 * Input: tasks = ["A","A","A", "B","B","B"], n = 3
 *
 * Output: 10
 *
 * Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
 *
 * There are only two types of tasks, A and B, which need to be separated by 3 intervals.
 * This leads to idling twice between repetitions of these tasks.
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }

        int totalTime = 0;

        while (!pq.isEmpty()) {
            int cycle = n + 1;
            List<Integer> t = new ArrayList<>();
            int taskCount = 0;
            while (cycle-- > 0 && !pq.isEmpty()) {

                int currFreq = pq.poll();
                if (currFreq > 1) {
                    t.add(currFreq - 1);
                }
                taskCount++;
            }
            for (int i : t) {
                pq.offer(i);
            }
            totalTime += pq.isEmpty() ? taskCount : n + 1;
        }
        return totalTime;
    }
}
