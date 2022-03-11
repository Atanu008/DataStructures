package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/
//LeetCode 735
//Video : https://www.youtube.com/watch?v=70AtvN5487Y&t=283s
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            //Push Positive Number
            if(asteroid > 0) {
                stack.push(asteroid);
            }
            else{ //This means we have an negative asteroid
                //Pop All postive asteroids if they are LESS Mass, As they will collide and smaller one will be destrayed
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop();
                }
                //If stack is empty i.e first asteroid is negative add it
                //Or previous asteroid is alo negative add it , As they wont collide
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(asteroid);
                }
                //Pop the asteroid with same Mass and dont push the current asteroid , as they would destroy each other
                else if(stack.peek() > 0 && Math.abs(stack.peek()) == Math.abs(asteroid)){
                    stack.pop();
                }
            }
        }

        int[] remainingAsteroids = new int[stack.size()];
        for(int i = remainingAsteroids.length -1; i>= 0; i--){
            remainingAsteroids[i] = stack.pop();
        }

        return remainingAsteroids;
    }
}
