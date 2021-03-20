package org.atanu.java.ds.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    //The basic solution is to have two loops and keep track of maximum count for all different elements
    public static int majorityElementSol1(int[] A) {

        int n = A.length;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = i; j < n; j++) {

                if (A[i] == A[j])
                    count++;
            }

            if (count > n / 2)
                return A[i];

        }

        return -1;
    }


    public static int majorityElementSol2(int[] a) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < a.length; i++) {

            if (map.containsKey(a[i])) {

                int count = map.get(a[i]) + 1;

                if (count > a.length / 2) {
                    return a[i];
                }

                map.put(a[i], count);
            } else {

                map.put(a[i], 1);
            }
        }

        return -1;
    }

    //Basic idea of the algorithm is that if we cancel out each occurrence of an element e with all the other elements that are different from e then e will exist till end if it is a majority element.
    public static int majorityElementSol3(int[] a) {

        int cand = findCadidate(a);

        if (isMajority(a, cand))
            return cand;
        else
            return -1;

    }

    public static int findCadidate(int[] a) {

        int majorIndex = 0;
        int count = 1;

        for (int i = 1; i < a.length; i++) {

            if (a[majorIndex] == a[i])
                count++;
            else
                count--;

            if (count == 0) {

                majorIndex = i;
                count = 1;

            }
        }

        return a[majorIndex];
    }

    public static boolean isMajority(int[] a, int cand) {

        int count = 0;
        for (int i = 0; i < a.length; i++) {

            if (a[i] == cand) {
                count++;
            }

            if (count > a.length / 2) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Assumption - valid input (majority element is present)
        int arr[] = {1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2};

        // int arr[] = {1, 1, 2, 1, 3, 5, 1};

        System.out.println("Majority Elemenyt is " + majorityElementSol1(arr));

        System.out.println("Majority Elemenyt is " + majorityElementSol2(arr));

        System.out.println("Majority Elemenyt is " + majorityElementSol3(arr));


    }

}
