package com.raj.crack.interview;

import static java.lang.String.copyValueOf;

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
    private static final char one = '%';
    private static final char two = '2';
    private static final char three = '0';

    public String urlify(String string) {
        char[] charsTrimmed = string.trim().toCharArray();
        int length = charsTrimmed.length;
        char[] result = new char[string.length()];
        int resultCounter = 0;
        for (int i = 0; i < length; i++) {
            if (charsTrimmed[i] == ' ') {
                result[resultCounter++] = one;
                result[resultCounter++] = two;
                result[resultCounter++] = three;
            } else {
                result[resultCounter++] = charsTrimmed[i];
            }
        }
        return copyValueOf(result);
    }
}