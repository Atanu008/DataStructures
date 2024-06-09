package org.bgd.java.ds.stacksqueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/implement-stack-using-queues">...</a>
 *
 * This is a 2 Stack Solution
 */

public class StackUsingQueues {
    static class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;
        int top;

        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
            top = -1;
        }

        public void push(int x) {
            queue1.offer(x);
            top = x;
        }

        public int pop() {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            int pop = queue1.poll();
            while (!queue2.isEmpty()) {
                int t = queue2.poll();
                queue1.offer(t);
                top = t;
            }
            return pop;
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
