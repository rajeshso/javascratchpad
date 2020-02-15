package com.raj.crack.interview;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation
 * of a palin- drome. A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.The palindrome does not need to be limited to
 * just dictionary words.
 * <p>
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat". "atco cta". etc.) Hints: #106, #121, #134, #136
 */
public class PalindromePermutation {
    public static char[] removePair(char[] input, boolean indexFound) throws Exception {
        if (input.length == 1) return input;
        char[] result = new char[input.length];
        int inputCounter = input.length;
        char toMatchChar = input[--inputCounter];
        boolean removed = false;
        int j = 0;
        while (inputCounter > 0) {
            char matchChar = input[--inputCounter];
            if (!removed && (matchChar == toMatchChar)) {
                removed = true;
            } else {
                result[j++] = matchChar;
            }
        }
        if (!removed && !indexFound) {
            return result;
        } else if (!removed) {
            throw new Exception("Does not have a palindrome permutation");
        } else {
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        char[] input = "tactcoa".toCharArray();
        System.out.println(String.copyValueOf(removePair(input, false)));
    }

    public boolean isPalindromePermutation(String given) {
        return true;
    }
}
