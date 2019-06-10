package com.buggymind.stacks;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackToTrackMaxValueTest {

    private StackToTrackMaxValue.Stack stack;

    @Before
    public void setup() {
        stack = new StackToTrackMaxValue.Stack();
    }

    @Test
    public void max1() {
        stack
                .push(1)
                .push(2)
                .push(3)
                .push(4)
                .push(5);

        assertThat(stack.pop(), is(5));
        assertThat(stack.pop(), is(4));

        assertThat(stack.max(), is(3));
    }

    @Test
    public void max2() {
        stack
                .push(5)
                .push(4)
                .push(3)
                .push(2)
                .push(1);

        assertThat(stack.pop(), is(1));
        assertThat(stack.pop(), is(2));

        assertThat(stack.max(), is(5));
    }
}