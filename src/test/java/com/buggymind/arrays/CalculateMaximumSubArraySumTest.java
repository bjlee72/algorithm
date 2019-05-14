package com.buggymind.arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import com.buggymind.type.Bounds;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class CalculateMaximumSubArraySumTest {

    private CalculateMaximumSubArraySum calculator;

    @Before
    public void setUp() {
        calculator = new CalculateMaximumSubArraySum();
    }

    @Test
    public void naive() {
        Bounds bounds = calculator.naive(new int[]{34, -50, 42, 14, -5, 86});
        assertThat(bounds, is(new Bounds(2, 5)));
    }

    @Test
    public void onePass_1() {
        Bounds bounds = calculator.onePass(new int[]{34, -50, 42, 14, -5, 86});
        assertThat(bounds, is(new Bounds(2, 5)));
    }

    @Test
    public void onePass_2() {
        Bounds bounds = calculator.onePass(new int[]{34, -50, -42, 14, -5, 86});
        assertThat(bounds, is(new Bounds(3, 5)));
    }

    @Test
    public void onePass_3() {
        Bounds bounds = calculator.onePass(new int[]{34, -32, 3, -10, 86});
        assertThat(bounds, is(new Bounds(4, 4)));
    }

    @Test
    public void onePass_4() {
        Bounds bounds = calculator.onePass(new int[]{34, -32, 3, -10, 8});
        assertThat(bounds, is(new Bounds(0, 0)));
    }

    @Test
    public void onePassReturnsNull() {
        Bounds bounds = calculator.onePass(new int[]{-5, -1, -8, -9});
        assertThat(bounds, nullValue());
    }
}