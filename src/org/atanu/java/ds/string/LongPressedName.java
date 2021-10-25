package org.atanu.java.ds.string;

//https://leetcode.com/problems/long-pressed-name/
//LeetCode 925
//https://www.youtube.com/watch?v=738Dy3D-q-E
//PepCoding
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {

        int i = 0;
        int j = 0;

        while (i < name.length() && j < typed.length()) {

            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i > 0 && name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        //name = aabbcc
        //typed = aabbccd
        //when out of the initial loop we need to check whether typed strings last characters
        //are multiple occurances of last character of name String
        while (j < typed.length()) {
            if (name.charAt(i - 1) != typed.charAt(j))
                return false;
            j++;
        }
        //we need to exhaust i as well
        //name = aabbcc
        //typed = aaabc
        //In this case j will be out of loop not not i. so need to check i
        return i == name.length();
    }

    public static void main(String[] args) {
        LongPressedName longPressedName = new LongPressedName();
        String name = "alex", typed = "aaleex";
        System.out.println(longPressedName.isLongPressedName(name,typed));
    }
}
