package com.raj.crack.interview;

/**
 * Page 90
 * Cracking the Coding Interview, 6th Edition
 * <p>
 * URLify: Write a method to replace all spaces in a string with '%20:
 * You may assume that the string has sufficient space at the end to
 * hold the additional characters, and that you are given the "true" length of the string.
 * (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * <p>
 * EXAMPLE
 * Input: "Mr John Smith "
 * Output: "Mr%20John%20Smith"
 */
public class Urlify {
    public String urlify(String string) {
        char[] chars = string.toCharArray();
        int length = chars.length;
        char[] result = new char[length];
        for (int i = 0; i < length; ) {
            if (chars[i] == ' ') {
                //TODO: TO continue from here
            } else {
                result[i] = chars[i];
                i++;
            }
        }
        return "";
    }
}