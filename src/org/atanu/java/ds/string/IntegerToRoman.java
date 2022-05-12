package org.atanu.java.ds.string;

//https://leetcode.com/problems/integer-to-roman/
//LeetCode 12
//Video : https://www.youtube.com/watch?v=ohBNdSJyLh8
public class IntegerToRoman {

    public String intToRoman(int num) {

        String[] symbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder sb = new StringBuilder();
        for(int i = symbols.length -1; i >= 0; i--){

            int count = num / values[i];
            while(count --> 0){
                sb.append(symbols[i]);
            }
            num = num % values[i];
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        int num = 3;
        //Output: "III"
        //Explanation: 3 is represented as 3 ones.
        System.out.println(integerToRoman.intToRoman(num));

         num = 58;
        //Output: "LVIII"
        //Explanation: L = 50, V = 5, III = 3.
        System.out.println(integerToRoman.intToRoman(num));

        num = 1994;
        //Output: "MCMXCIV"
        //Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
        System.out.println(integerToRoman.intToRoman(num));
    }
}
