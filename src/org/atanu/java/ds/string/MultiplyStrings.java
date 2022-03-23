package org.atanu.java.ds.string;

//https://leetcode.com/problems/multiply-strings/
//LeetCode 43
public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        //Base Case
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m+n];

        for(int i = m -1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;
                product += result[i+j+1];

                result[i+j+1] = product % 10;
                result[i+j] += product / 10; // This is impt and Tricky . we need += ;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int a : result) {
            if(sb.length() == 0 && a == 0){
                continue;
            }
            sb.append(a);
        }

        return sb.toString();
    }
}
