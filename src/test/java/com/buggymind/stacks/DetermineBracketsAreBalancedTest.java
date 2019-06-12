package com.buggymind.stacks;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DetermineBracketsAreBalancedTest {

    private DetermineBracketsAreBalanced decider;

    @Before
    public void setup() {
        decider = new DetermineBracketsAreBalanced();
    }

    @Test
    public void isWellFormed() {
        assertThat(decider.isWellFormed("([])[]({})"), is(true));
    }

    @Test
    public void isMalformed() {
        assertThat(decider.isWellFormed("([][]({})"), is(false));
    }

    @Test
    public void isMalformed2() {
        assertThat(decider.isWellFormed("][{}]["), is(false));
    }
    @Test
    public void isMalformed3() {
        assertThat(decider.isWellFormed("[[[(((]]])))"), is(false));
    }
}
