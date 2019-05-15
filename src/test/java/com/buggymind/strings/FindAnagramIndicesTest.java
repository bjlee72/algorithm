package com.buggymind.strings;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

public class FindAnagramIndicesTest {

    private FindAnagramIndices finder;

    @Before
    public void setUp() {
        finder = new FindAnagramIndices();
    }

    @Test
    public void find_1() {
        List<Integer> result = finder.find("ab", "abxaba");
        assertThat(result, is(ImmutableList.of(0, 3, 4)));
    }

    @Test
    public void find_2() {
        List<Integer> result = finder.find("john", "ojohnomygodnhojshitnnn");
        assertThat(result, is(ImmutableList.of(1, 11)));
    }
}