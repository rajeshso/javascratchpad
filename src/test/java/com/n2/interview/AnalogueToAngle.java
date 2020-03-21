package com.n2.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnalogueToAngle {
    static final int HOUR_ANGLE = 30;
    static final int MINUTES_ANGLE = 6;

    static int handleAngle(int h, int m) {
        return HOUR_ANGLE * h - MINUTES_ANGLE * m;
    }

    @Test
    public void test3OClock() {
        assertTrue(handleAngle(3, 0) == 90);
    }

    @Test
    public void test5OClock() {
        assertTrue(handleAngle(5, 0) == 150);
    }

    @Test
    public void test3Hours10MinutesClock() {
        assertTrue(handleAngle(3, 10) == 150);
    }

}
