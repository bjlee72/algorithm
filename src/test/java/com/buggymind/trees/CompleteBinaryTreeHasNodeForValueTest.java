package com.buggymind.trees;

import org.junit.Before;
import org.junit.Test;

import static com.buggymind.trees.CompleteBinaryTreeHasNodeForValue.Node;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CompleteBinaryTreeHasNodeForValueTest {

    private CompleteBinaryTreeHasNodeForValue decider;

    @Before
    public void setup() {
        decider = new CompleteBinaryTreeHasNodeForValue();
    }

    @Test
    public void decide() {
        /*
         *      1
         *     / \
         *    2   3
         *   / \
         *  4  5
         */
        Node root =
                new Node()
                        .left(new Node()
                                .left(new Node())
                                .right(new Node()))
                        .right(new Node());

        for (int i = 1; i <= 10; ++i) {
            if (i <= 5) {
                assertThat(String.valueOf(i), decider.decide(root, i), is(true));
            } else {
                assertThat(String.valueOf(i), decider.decide(root, i), is(false));
            }
        }
    }
}
