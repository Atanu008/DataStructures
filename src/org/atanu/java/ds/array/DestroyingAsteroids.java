package org.atanu.java.ds.array;

import java.util.Arrays;

//https://leetcode.com/problems/destroying-asteroids/
//LeetCode 2126
public class DestroyingAsteroids {

    //Sort then apply greedy algorithm
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        long planetMass = mass;
        Arrays.sort(asteroids);

        for(int asteroid : asteroids) {
            if(asteroid > planetMass) {
                return false; //asteroid is gretaer than Planet Mass
            }
            planetMass += asteroid; //asteroid is destroyed and the planet gains the mass of the asteroid
        }

        return true;
    }

    public static void main(String[] args) {
        int mass = 10;
        int[] asteroids = {3,9,19,5,21};
        DestroyingAsteroids destroyingAsteroids = new DestroyingAsteroids();
        boolean result = destroyingAsteroids.asteroidsDestroyed(mass, asteroids);
        System.out.println(result);

        mass = 5;
        asteroids = new int[]{4, 9, 23, 4};
        result = destroyingAsteroids.asteroidsDestroyed(mass, asteroids);
        System.out.println(result);
    }
}
