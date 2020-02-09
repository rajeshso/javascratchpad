package com.raj.crack.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page 90
 * Cracking the Coding Interview, 6th Edition
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 */
public class TestIsUnique {
    private IsUniqueCharacters isUniqueCharacters = new IsUniqueCharacters();

    @Test
    public void testIsUniqueTrueIfUnique() {
        String word = "word";
        assertTrue(isUniqueCharacters.isUnique(word), "The characters are unique");
    }

    @Test
    public void testIsUniqueFalseIfNotUnique() {
        String word = "palace";
        assertFalse(isUniqueCharacters.isUnique(word), "The characters palace are not unique");
    }

    @Test
    public void testIsUniqueFalseIfonlyDuplicates() {
        String word = "aa";
        assertFalse(isUniqueCharacters.isUnique(word), "The characters aa are not unique");
    }

}
