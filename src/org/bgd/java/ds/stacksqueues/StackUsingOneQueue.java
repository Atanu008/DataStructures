package org.bgd.java.ds.stacksqueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/implement-stack-using-queues">...</a>
 *
 * This is a 2 Stack Solution
 */
public class StackUsingOneQueue {

    static class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
            int sz = queue.size();
            while (sz > 1) {
                queue.add(queue.poll());
                sz--;
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();

        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
