package com.buggymind.lists;

import static com.buggymind.lists.AddTwoLinkedLists.Node;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class AddTwoLinkedListsTest {

    private AddTwoLinkedLists adder;

    @Before
    public void setup() {
        adder = new AddTwoLinkedLists();
    }

    @Test
    public void add() {
        Node n1 = new Node(9).setNext(new Node(9));
        Node n2 = new Node(5).setNext(new Node(2));

        Node result = adder.add(n1, n2);
        Node expect = new Node(4).setNext(new Node(2).setNext(new Node(1)));

        assertThat(Node.equals(result, expect), is(true));
    }
}