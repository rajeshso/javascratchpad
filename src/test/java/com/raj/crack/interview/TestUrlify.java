package com.raj.crack.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUrlify {

    private Urlify urlify = new Urlify();

    @Test
    public void testUrlifyForSimpleString() {
        String given = "Mr John Smith    ";
        String expected = "Mr%20John%20Smith";
        assertEquals(urlify.urlify(given), expected);
    }
}
