package org.atanu.java.ds.string;

//https://leetcode.com/problems/add-strings/
//LeetCode 415
//Simple Video : https://www.youtube.com/watch?v=PlCOTfHB54g&list=PLtQWXpf5JNGIjrOGo2OYLa145-d86To2P&index=15
public class AddStrings {
    public String addStrings(String num1, String num2) {

        int i = num1.length() -1;
        int j = num2.length() -1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while(i >= 0 || j >= 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10); // Can use insert at index 0, then we wont have to reverse
            carry = sum / 10;
            i--;
            j--;
        }

        if(carry == 1){ // For cases Like 99 + 1 . Carry would be 1 , and need tp insert/append
            result.append(1);
        }

        return result.reverse().toString();
    }
}
