package org.atanu.java.ds.string;

//https://leetcode.com/problems/string-compression/
//LEETCODE 443
//THIS IS SIMILAR TO RUN LENGTH ENCODING
public class StringCompression {

    public int compress(char[] chars) {

        int index = 0;
        int compressionIndex = 0;

        while(index < chars.length){

            char currentChar = chars[index];
            int currentCharCount = 0;

            while(index < chars.length && chars[index] == currentChar){
                index++;
                currentCharCount++;
            }

            chars[compressionIndex++] = currentChar; //Place the Character
            if(currentCharCount > 1){
                for(char ch : String.valueOf(currentCharCount).toCharArray()){
                    chars[compressionIndex++] = ch; //Place the occurance if mor ethean 1. and slpit it if greater than 9. that swhy the loop is for
                }
            }
        }

        return compressionIndex;
    }

    //Video : https://www.youtube.com/watch?v=IhJgguNiYYk
    public int compressV2(char[] chars) {

        int i = 0;
        int j = 0;
        int index = 0;
        while(i < chars.length){
            j = i;
            while(j < chars.length && chars[i] == chars[j]){
                j++;
            }

            chars[index++] = chars[i]; //Place the Character
            if(j-i > 1){
                for(char ch : String.valueOf(j-i).toCharArray()){
                    chars[index++] = ch; //Place the occurance if mor ethean 1. and slpit it if greater than 9. that swhy the loop is for
                }
            }

            i = j;
        }

        return index;
    }
}
