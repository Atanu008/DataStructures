package org.atanu.java.ds.dp;

import java.util.stream.Stream;

//This would return the length . Not the actual String .
// String can be derived from dp table(code is there in //Leetcode 1092)
public class ShortestCommonSUpersequence_v2 {
    //The two changing parameters in our recursive function are the two indices, i1 and i2 which are incremented based on the following two conditions:
    //
    //If the characters at i1 and i2 are a match, skip one character from both the sequences and make a recursive call for the remaining lengths.
    //If the characters do not match, call the function recursively twice by skipping one character from each string. Return the minimum result of these two calls.

    public static int shortestCommonSupersequenceRecursive(String str1, String str2, int i1, int i2) {
        // if any of the pointers has iterated over all the characters of the string,
        // return the remaining length of the other string
        if (i1 == str1.length()) {
            return str2.length() - i2;
        }
        if (i2 == str2.length()) {
            return str1.length() - i1;
        }

        // if both the characters pointed by i1 and i2 are same, increment both pointers
        if (str1.charAt(i1) == str2.charAt(i2)) {
            return 1 + shortestCommonSupersequenceRecursive(str1, str2, i1 + 1, i2 + 1);
        }

        // recursively call the function twice by skipping one character from each string
        int length1 = 1 + shortestCommonSupersequenceRecursive(str1, str2, i1, i2 + 1);
        int length2 = 1 + shortestCommonSupersequenceRecursive(str1, str2, i1 + 1, i2);

        // return the minimum of the two lengths
        return Math.min(length1, length2);
    }

    public static int shortestCommonSupersequence(String str1, String str2) {
        return shortestCommonSupersequenceRecursive(str1, str2, 0, 0);
    }

    // driver code
    public static void main(String[] arg) {
        String[] input1Strings = {"abcd", "educativeisfun", "cpprocks", "abcf", "dynamic"};
        String[] input2Strings = {"efgh", "algorithmsarefun", "cppisfun", "bdcf", "programming"};

        // you can uncomment the lines below and check how this recursive solution causes a time-out

        // String newArr[] = Arrays.copyOf(input1Strings, input1Strings.length + 1);
        // newArr[input1Strings.length] = "iloveprogrammingbutprogrammingdoesnotloveme";
        // input1Strings = newArr;
        // newArr = Arrays.copyOf(input2Strings, input2Strings.length + 1);
        // newArr[input2Strings.length] = "computersarefastprogrammerskeepthemslow";
        // input2Strings = newArr;

        for (int i = 0; i < input1Strings.length; i++) {
            System.out.print(i + 1);
            System.out.println("\tString 1: " + input1Strings[i]);
            System.out.println("\tString 1: " + input2Strings[i]);
            System.out.println("\tLength of Shortest Common Supersequence: " + shortestCommonSupersequence(input1Strings[i], input2Strings[i]));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }
    }
}
