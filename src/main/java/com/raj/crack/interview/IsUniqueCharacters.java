package com.raj.crack.interview;
/**
 * Page 90
 * Cracking the Coding Interview, 6th Edition
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 */
public class IsUniqueCharacters {
    public boolean isUnique(String word) {
        char[] chars = word.toCharArray();
        int length = chars.length;
        boolean result = true;
        outerloop:
        for (int i = 0; i <= length; i++) {
            for (int j = i + 1; j < length; j++) {
                System.out.printf("i %d is %s and j %d is %s\n", i, chars[i], j, chars[j]);
                if (chars[i] == chars[j]) {
                    result = false;
                    break outerloop;
                }
            }

        }
        return result;
    }
}
