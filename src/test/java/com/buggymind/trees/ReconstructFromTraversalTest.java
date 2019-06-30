package com.buggymind.trees;

import static com.buggymind.trees.ReconstructFromTraversal.Node;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ReconstructFromTraversalTest {

    ReconstructFromTraversal reconstructor;

    @Before
    public void setup() {
        reconstructor = new ReconstructFromTraversal();
    }

    @Test
    public void from() {
        Node reconstructed =
                reconstructor.from(
                        new char[] {'a', 'b', 'd', 'e', 'c', 'f', 'g'},
                        new char[] {'d', 'b', 'e', 'a', 'f', 'c', 'g'});

        Node expected =
                new Node('a')
                        .left(new Node('b')
                                .left(new Node('d'))
                                .right(new Node('e')))
                        .right(new Node('c')
                                .left(new Node('f'))
                                .right(new Node('g')));

        assertTrue(Node.equals(reconstructed, expected));
    }
}