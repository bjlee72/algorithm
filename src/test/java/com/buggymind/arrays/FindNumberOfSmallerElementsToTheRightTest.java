package com.buggymind.arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FindNumberOfSmallerElementsToTheRightTest {

    private FindNumberOfSmallerElementsToTheRight finder;

    @Before
    public void setup() {
        finder = new FindNumberOfSmallerElementsToTheRight();
    }

    @Test
    public void naive_1() {
        int[] result = finder.naive(new int[]{5, 3, 7, 1, 2});
        assertThat(result, is(new int[]{3, 2, 2, 0, 0}));
    }

    @Test
    public void naive_2() {
        int[] result = finder.naive(new int[]{5, 13, 7, 8, 2});
        assertThat(result, is(new int[]{1, 3, 1, 1, 0}));
    }
}