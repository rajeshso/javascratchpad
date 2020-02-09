package com.raj.crack.interview;

import java.util.Optional;

public class IsPermutation {
    public boolean isPermutation(final String word, final String match) {
        char[] wordChars = word.toCharArray();
        char[] matchChars = match.toCharArray();
        int[] matchIndices = new int[matchChars.length];
        int j = 0;
        for (int i = 0; i < match.length(); i++) {
            Optional<Integer> matchIndex = getIndex(wordChars, matchChars[i]);
            if (matchIndex.isEmpty()) {
                return false;
            } else {
                matchIndices[j] = i;
                j++;
            }
        }
        return true;
    }

    public Optional<Integer> getIndex(char[] word, char match) {
        int wordLength = word.length;
        Optional<Integer> result = Optional.empty();
        loop:
        for (int i = 0; i < wordLength; i++) {
            if (word[i] == match) {
                result = Optional.of(i);
                break loop;
            }
        }
        return result;
    }
}
