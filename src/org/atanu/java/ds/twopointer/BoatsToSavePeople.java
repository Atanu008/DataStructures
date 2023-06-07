package org.atanu.java.ds.twopointer;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/

public class BoatsToSavePeople {

    // Its Greedy choices

    // If the heaviest person can share a boat with the lightest person, then do so.
    // Otherwise, the heaviest person can't pair with anyone, so they get their own boat.
    //
    // The reason this works is because if the lightest person can pair with anyone,
    // they might as well pair with the heaviest person.

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
            end--; // One fat will be always included as the problem guarantees to save all teh people
            boat++; // Increment boat Number
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
