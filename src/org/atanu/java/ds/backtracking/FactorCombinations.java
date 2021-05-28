package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//LeetCode 254
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        //will start dividing by 2.
        backtrack(2, n, current, result);
        return result;
    }

    public void backtrack(int index, int curNum, List<Integer> factors, List<List<Integer>> res) {
        //Once we reach the
        if (curNum == 1) {
            //we will not consider the single nember itslef.
            // so checking only > 1.
            // if ==1 then that no will be added in teh lsit
            if(factors.size() > 1){
                res.add(new ArrayList<>(factors));
                return;
            }

        }

        for (int i = index; i <= curNum; i++) {
            //will only proceed if the number is divisible
            if (curNum % i == 0)  {
                factors.add(i);
                backtrack(i, curNum / i, factors, res);
                factors.remove(factors.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        FactorCombinations factorCombinations = new FactorCombinations();
        int n = 32;
        List<List<Integer>> result = factorCombinations.getFactors(n);
        result.forEach(System.out::println);
    }

}
