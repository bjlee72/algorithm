package com.buggymind.queues;

import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class MaximumOfKLengthSubarraysTest {

    private MaximumOfKLengthSubarrays computer;

    @Before
    public void setup() {
        computer = new MaximumOfKLengthSubarrays();
    }

    @Test
    public void compute() {
        List<Integer> result = computer.compute(new int[]{10, 5, 2, 7, 8, 7}, 3);
        assertThat(result, Matchers.contains(10, 7, 8, 8));
    }
}