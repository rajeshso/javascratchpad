package com.raj.crack.interview;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPermutation {

    private IsPermutation isPermutation = new IsPermutation();

    @Test
    public void testIsPermutation_shouldReturnTrue_ifMatchFound() {
        String word = "ABC";
        String match = "BA";
        assertTrue(isPermutation.isPermutation(word, match), "BA is present in ABC");
    }

    @Test
    public void testIsPermutation_shouldReturnFalse_ifMatchNotFound() {
        String word = "ABC";
        String match = "DE";
        assertFalse(isPermutation.isPermutation(word, match), "DE is not present in ABC");
    }

    @Test
    public void testIsPermutation_shouldReturnFalse_ifOnlyOneLetterMatches() {
        String word = "ABC";
        String match = "CE";
        assertFalse(isPermutation.isPermutation(word, match), "CE is not present in ABC");
    }

    @Disabled
    public void testIsPermutation_shouldReturnFalse_ifWordDoesNotContainTheNumberOfMatches() {
        String word = "ABC";
        String match = "CC";
        assertFalse(isPermutation.isPermutation(word, match), "CC is not present in ABC");
    }
}
