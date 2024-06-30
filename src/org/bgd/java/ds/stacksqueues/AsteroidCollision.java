package org.bgd.java.ds.stacksqueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : asteroids) {
            boolean toAdd = true;
            while (!stack.isEmpty() && stack.peek() > 0 && i < 0) {
                if (stack.peek() < Math.abs(i)) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == Math.abs(i)) {
                    stack.pop();

                }
                toAdd = false;
                break;
            }
            if (toAdd) {
                stack.push(i);
            }
        }
        int[] result = new int[stack.size()];
        int k = stack.size() - 1;
        while (k >= 0) {
            result[k--] = stack.pop();
        }
        return result;
    }
}
