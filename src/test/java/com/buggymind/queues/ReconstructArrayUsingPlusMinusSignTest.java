package com.buggymind.queues;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ReconstructArrayUsingPlusMinusSignTest {

    private ReconstructArrayUsingPlusMinusSign array;

    @Before
    public void setup() {
        array = new ReconstructArrayUsingPlusMinusSign();
    }

    @Test
    public void naive1() {
        List<Integer> result = array.naive(new String[]{"None", "+", "+", "-", "+"});
        assertThat(result.toString(), result, contains(0, 1, 3, 2, 4));
    }

    @Test
    public void naive2() {
        List<Integer> result = array.naive(new String[]{"None", "-", "+", "+", "-", "-", "-", "+"});
        assertThat(result.toString(), result, contains(1, 0, 2, 6, 5, 4, 3, 7));
    }

    @Test
    public void optimized1() {
        List<Integer> result = array.optimized(new String[]{"None", "+", "+", "-", "+"});
        assertThat(result.toString(), result, contains(0, 1, 3, 2, 4));
    }

    @Test
    public void optimized2() {
        List<Integer> result = array.optimized(new String[]{"None", "-", "+", "+", "-", "-", "-", "+"});
        assertThat(result.toString(), result, contains(1, 0, 2, 6, 5, 4, 3, 7));
    }
}