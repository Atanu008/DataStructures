package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/decode-string/
//LeetCode 394
//Video : https://www.youtube.com/watch?v=SF2W6VDs7bc&t=514s

public class DecodeString {

    //Case 1) If the current character is a digit (0-9), append it to the number k.
    //Case 2) If the current character is a letter (a-z), append it to the currentString.
    //Case 3) If current character is a opening bracket [, push k and currentString into countStack and stringStack respectively.
    //Case 4) Closing bracket ]: We must begin the decoding process,
    //We must decode the currentString. Pop currentK from the countStack and decode the pattern currentK[currentString]
    //As the stringStack contains the previously decoded string, pop the decodedString from the stringStack.
    //Update the decodedString = decodedString + currentK[currentString]
    public String decodeString(String s) {

        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> counterStack = new Stack<>();
        int number = 0;
        StringBuilder currentString = new StringBuilder();

        for(char ch : s.toCharArray()){

            if(Character.isDigit(ch)){
                number = number*10 + ch -'0';
            }
            else if(Character.isLetter(ch)){
                currentString.append(ch);
            }
            //Push previously calculated values into stack when we see enconded String
            else if(ch == '['){
                // push the number k to countStack
                counterStack.push(number);
                // push the currentString to stringStack
                stringStack.push(currentString);
                // reset currentString and number
                currentString = new StringBuilder();
                number = 0;
            }
            //Start decoding
            else if(ch == ']'){
                StringBuilder  decodedString = stringStack.pop();
                int kTimeAppend = counterStack.pop();
                // decode currentK[currentString] by appending currentString k times
                while(kTimeAppend -->0){
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            }
        }

        return new String(currentString);
    }

    public static void main(String[] args) {

        DecodeString decodeString = new DecodeString();
        String s = "3[a]2[bc]";
        System.out.println("Decoded String is "+ decodeString.decodeString(s));
        s = "3[a2[c]]";
        System.out.println("Decoded String is "+ decodeString.decodeString(s));
        s = "2[abc]3[cd]ef";
        System.out.println("Decoded String is "+ decodeString.decodeString(s));

    }
}
