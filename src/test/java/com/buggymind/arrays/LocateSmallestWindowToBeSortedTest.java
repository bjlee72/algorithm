package com.buggymind.arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.buggymind.type.Bounds;
import org.junit.Before;
import org.junit.Test;

public class LocateSmallestWindowToBeSortedTest {

    private LocateSmallestWindowToBeSorted locator;

    @Before
    public void setup() {
        locator = new LocateSmallestWindowToBeSorted();
    }

    @Test
    public void findSmallestWindow_1() {
        Bounds bounds = locator.locate(new int[] {3, 7, 5, 6, 9});
        assertThat(bounds, is(new Bounds(1, 3)));
    }

    @Test
    public void findSmallestWindow_2() {
        Bounds bounds = locator.locate(new int[] {1, 7, 2, 5, 3, 9});
        assertThat(bounds, is(new Bounds(1, 4)));
    }
}