package org.atanu.java.ds.string;

//https://leetcode.com/problems/to-lower-case/description/
//Leetcode 709
public class ToLowerCase {
    //the difference between the lower case and upper case ascii value is 32, so when need to convert upper case to lower case, add 32 in the upper case value. and to convert from lower case to uppercase, minus 32 from the lowercase char.
    public String toLowerCase(String s) {

        char[] arr = s.toCharArray();

        for(int i = 0; i < s.length(); i++){
            if ('A' <= arr[i] && arr[i] <= 'Z')
                arr[i] = (char) (arr[i] - 'A' + 'a');
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        ToLowerCase toLowerCase = new ToLowerCase();
        String s = "Hello";
        System.out.println(toLowerCase.toLowerCase(s));
    }
}
