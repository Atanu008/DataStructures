package org.bgd.java.ds.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/encode-and-decode-strings/editorial/">...</a>
 *
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Machine 1 (sender) has the function:
 *
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 * So Machine 1 does:
 *
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 *
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 *
 * Implement the encode and decode methods.
 */
public class EncodeDecodeString {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String each : strs) {
            encoded.append(each.replace("/", "//"))
              .append("/:");
        }

        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();
        StringBuilder currentDecoded = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == ':') {
                decodedStrings.add(currentDecoded.toString());
                currentDecoded = new StringBuilder();
                i += 2;
            } else if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                currentDecoded.append('/');
                i += 2;
            } else {
                currentDecoded.append(s.charAt(i));
                i += 1;
            }
        }
        return decodedStrings;
    }
}
