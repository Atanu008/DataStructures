package org.atanu.java.ds.design;

import java.util.LinkedList;

//https://leetcode.com/problems/number-of-recent-calls/description/
//Leetcode 933
public class NumberOfRecentCalls {

    private static class RecentCounter {

        LinkedList<Integer> queue;
        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {

            queue.offer(t);

            while(!queue.isEmpty() && queue.getFirst() < (t - 3000)){
                queue.removeFirst(); //poll()
            }

            return queue.size();
        }
    }
}
