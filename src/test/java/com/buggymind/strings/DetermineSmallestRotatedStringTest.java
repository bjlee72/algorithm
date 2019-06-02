package com.buggymind.strings;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DetermineSmallestRotatedStringTest {

    private DetermineSmallestRotatedString rotator;

    @Before
    public void setUp() {
        rotator = new DetermineSmallestRotatedString();
    }

    @Test
    public void determine() {
        assertThat(rotator.determine("daily", 1), is("ailyd"));
        assertThat(rotator.determine("flashbriefing", 2), is("abriefinglfsh"));
    }
}