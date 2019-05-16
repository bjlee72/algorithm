package com.buggymind.strings;

import static com.buggymind.strings.GeneratePalindromePairs.Pair;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GeneratePalindromePairsTest {

    private GeneratePalindromePairs generator;

    @Before
    public void setUp() {
        generator = new GeneratePalindromePairs();
    }

    @Test
    public void isPalindrome() {
        assertThat(GeneratePalindromePairs.isPalindrome("aba"), is(true));
        assertThat(GeneratePalindromePairs.isPalindrome("abba"), is(true));
        assertThat(GeneratePalindromePairs.isPalindrome("abca"), is(false));
    }

    @Test
    public void naive() {
        List<Pair> result =
                generator.naive(new String[]{"code", "edoc", "da", "d"});

        assertThat(result, contains(new Pair(0, 1), new Pair(1, 0), new Pair(2, 3)));
    }
}