package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BackTrackProblem1_PowerSet {

    // Function to generate power set of given set S
    public static void findPowerSet(int[] S, int decisionPoint, List<Integer> set) {
        // if we have considered all elements
        if (decisionPoint == S.length) {
            System.out.println(set);
            return;
        }

        // consider nth element
        set.add(S[decisionPoint]);
        findPowerSet(S, decisionPoint + 1, set);

        //Remove the decision As It has explored. And Again backtrack
        //First 3 will be removed . As the decision point will be 2
        set.remove(set.size() - 1);
        findPowerSet(S, decisionPoint + 1, set);
    }

    public static void main(String[] args) {

        int decisionPoint = 0;
        int[] S = {1, 2, 3};
        List<Integer> set = new ArrayList<>();

        findPowerSet(S, decisionPoint, set);
    }

}

