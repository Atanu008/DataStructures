package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        //String[] current = new String[2*n];
        generateParenthesis(n,0,0,"",result);

        return result;
    }

    public void generateParenthesis(int n, int open, int close, String current, List<String> result){

        if(current.length() == n*2){
            result.add(current);
            return;
        }
        if(open < n){
            //current[i] = "(";
            generateParenthesis(n, open+1, close,current+"(", result);
        }

        if(close < open){
            //current[i] = ")";
            generateParenthesis(n, open, close+1, current+")", result);
        }

    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> result = generateParenthesis.generateParenthesis(3);
        System.out.println(result);
    }
}
