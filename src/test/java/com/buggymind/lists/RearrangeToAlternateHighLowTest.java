package com.buggymind.lists;

import static com.buggymind.lists.RearrangeToAlternateHighLow.Node;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RearrangeToAlternateHighLowTest {

    private RearrangeToAlternateHighLow rearranger;

    @Before
    public void setup() {
        rearranger = new RearrangeToAlternateHighLow();
    }

    @Test
    public void rearrangeListWithOddSize() {
        Node input = new Node(1).next(new Node(2).next(new Node(3).next(new Node(4).next(new Node(5)))));
        rearranger.rearrange(input);
        assertThat(input.toString(), is("1->3->2->5->4"));
    }

    @Test
    public void rearrangeListWithEvenSize() {
        Node input = new Node(1).next(new Node(2).next(new Node(3).next(new Node(4))));
        rearranger.rearrange(input);
        assertThat(input.toString(), is("1->3->2->4"));
    }

    @Test
    public void rearrangeSingletonList() {
        Node input = new Node(1);
        rearranger.rearrange(input);
        assertThat(input.toString(), is("1"));
    }

    @Test
    public void rearrangeNullList() {
        // Simply, it shouldn't do anything.
        rearranger.rearrange(null);
    }
}