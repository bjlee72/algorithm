package com.buggymind.dictionaries;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CutBrickWallTest {

    private CutBrickWall cutter;

    @Before
    public void setup() {
        cutter = new CutBrickWall();
    }

    @Test
    public void naive() {
        int[][] input = new int[][] {
                {3, 5, 1, 1},
                {2, 3, 3, 2},
                {5, 5},
                {4, 4, 2},
                {1, 3, 3, 3},
                {1, 1, 6, 1, 1}
        };

        int result = cutter.min(input);

        assertThat(result, is(2));
    }
}