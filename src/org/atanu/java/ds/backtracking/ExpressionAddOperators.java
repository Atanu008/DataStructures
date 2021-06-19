package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//LeetCode 282
//https://leetcode.com/problems/expression-add-operators/
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        backtrack(result, num, target, "", 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, String num, int target, String exp, long currentSum, long prevNumber, int index) {
        if(index == num.length()){
            if(currentSum == target){
                result.add(exp);
            }
            return;
        }
        for(int i = index; i < num.length(); i++){

            // corner case: if current position is 0, we can only use it as a single digit number, should be 0
            // if it is not a single digit number with leading 0, it should be considered as an invalid number
            // Like 053
            if(i != index && num.charAt(index) == '0')
                break;

            long currentNumber = Long.parseLong(num.substring(index,i+1));

            //Initial. No Operator involved
            if(index == 0){
                backtrack(result, num, target, exp+currentNumber, currentNumber, currentNumber, i+1);
            }
            else
            {
                backtrack(result, num, target, exp+"+"+currentNumber, currentSum + currentNumber, currentNumber, i+1);
                backtrack(result, num, target, exp+"-"+currentNumber, currentSum -currentNumber, -currentNumber, i+1);
                // trick part: to calculate multiplication, we should subtract previous number, and then add current
                // multiplication result to the subtraction result
                backtrack(result, num, target, exp+"*"+currentNumber, currentSum - prevNumber + prevNumber*currentNumber, prevNumber*currentNumber, i+1);
            }

        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators expressionAddOperators = new ExpressionAddOperators();
        List<String> result = expressionAddOperators.addOperators("123", 6);
        result.forEach(System.out::println);
    }
}
