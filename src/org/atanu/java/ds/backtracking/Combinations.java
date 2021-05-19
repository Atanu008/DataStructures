package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result,current, k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int k, int n, int index) {
        if(k == 0){
            result.add(new ArrayList<>(current));
        }
        for(int i = index; i <= n; i++){
            current.add(i);
            backtrack(result,current, k -1, n, i+1);
            current.remove(current.size() -1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combinations.combine(n,k);
        result.forEach(System.out::println);
    }
}
