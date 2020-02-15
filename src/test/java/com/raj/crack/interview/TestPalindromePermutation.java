package com.raj.crack.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPalindromePermutation {
    private final PalindromePermutation unit = new PalindromePermutation();

    @Test
    public void testTactCoaReturnsTrue() {
        String given = "tactcoa";
        boolean actual = unit.isPalindromePermutation(given);
        assertTrue(actual);
    }

    @Test
    public void testCocoColaReturnsFalse() {
        String given = "cococola";
        boolean actual = unit.isPalindromePermutation(given);
        assertFalse(actual);
    }
}
