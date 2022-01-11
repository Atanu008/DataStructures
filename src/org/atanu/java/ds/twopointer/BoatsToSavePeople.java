package org.atanu.java.ds.twopointer;

import java.util.Arrays;

//https://leetcode.com/problems/boats-to-save-people/
public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {

        int start = 0;
        int end = people.length - 1;
        int boat = 0;

        Arrays.sort(people);
        while (start <= end) {
            //Include One skinny with the Fat one. 
            if (people[end] + people[start] <= limit) {
                start++;
            }
            end--; // One fat will be always included as the problem guarentees to save all teh people
            boat++; // Increament boat Number
        }
        return boat;
    }

    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        System.out.println("Boats Needed " + numRescueBoats(people, limit));

        people = new int[]{1, 2};
        limit = 3;
        System.out.println("Boats Needed " + numRescueBoats(people, limit));

        people = new int[]{3, 5, 3, 4};
        limit = 5;
        System.out.println("Boats Needed " + numRescueBoats(people, limit));
    }
}
