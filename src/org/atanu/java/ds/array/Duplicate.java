package org.atanu.java.ds.array;

import java.util.HashMap;
import java.util.Map;

public class Duplicate {

    public static void findDuplicateSol1(int[] arr) {

        System.out.println("Duplicate");
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j]) {

                    System.out.println(arr[i]);
                }
            }

        }
    }

    public static void findDuplicateSol2(int[] arr) {


        Map<Integer, Integer> map = new HashMap<>();

        System.out.println("Duplicate");
        for (int i = 0; i < arr.length; i++) {

            if (map.containsKey(arr[i])) {

                System.out.println(arr[i]);
            } else
                map.put(arr[i], arr[i]);
        }

    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 3, 3, 4, 5, 7, 1};

        findDuplicateSol1(arr);
        findDuplicateSol2(arr);
    }

}
