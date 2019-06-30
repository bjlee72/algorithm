package com.buggymind.trees;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static com.buggymind.trees.CountUnivalTrees.Node;

public class CountUnivalTreesTest {

    CountUnivalTrees counter;

    @Before
    public void setup() {
        counter = new CountUnivalTrees();
    }

    @Test
    public void count1() {
        /*
         *             0
         *            / \
         *           1   0
         *              / \
         *             1   0
         *            / \
         *           1   1
         */
        Node root = new Node(0);
        root.setLeft(new Node(1));
        root.setRight(new Node(0));

        root.getRight().setRight(new Node(0));
        root.getRight().setLeft(new Node(1));

        root.getRight().getLeft().setLeft(new Node(1));
        root.getRight().getLeft().setRight(new Node(1));

        int count = counter.count(root);

        assertThat(count, is(5));
    }

    @Test
    public void count2() {
        /*
         *             0
         *            / \
         *           0   0
         *              / \
         *             0   0
         *                  \
         *                   1
         */
        Node root = new Node(0);
        root.setLeft(new Node(0));
        root.setRight(new Node(0));

        root.getRight().setRight(new Node(0));
        root.getRight().setLeft(new Node(0));

        root.getRight().getRight().setRight(new Node(1));

        int count = counter.count(root);

        assertThat(count, is(3));
    }
}