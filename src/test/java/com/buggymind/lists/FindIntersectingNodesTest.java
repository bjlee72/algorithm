package com.buggymind.lists;

import static com.buggymind.lists.FindIntersectingNodes.Node;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FindIntersectingNodesTest {

    private FindIntersectingNodes finder;

    @Before
    public void setup() {
        finder = new FindIntersectingNodes();
    }

    @Test
    public void findCase1() {
        // A = 3->7->8->10 and B = 99->1->8->10,
        Node commonList = new Node(8).next(new Node(10));
        Node list1 = new Node(3).next(new Node(7).next(commonList));
        Node list2 = new Node(99).next(new Node(1).next(commonList));

        Node intersect = finder.find(list1, list2);

        assertThat(intersect.value(), is(8));
    }

    @Test
    public void findCase2() {
        // A = 3->7->8->10 and B = 99->1->4->8->10,
        Node commonList = new Node(8).next(new Node(10));
        Node list1 = new Node(3).next(new Node(7).next(commonList));
        Node list2 = new Node(99).next(new Node(1).next(new Node(4).next(commonList)));

        Node intersect = finder.find(list2, list1);

        assertThat(intersect.value(), is(8));
    }

    @Test
    public void findCase3() {
        Node list1 = new Node(3).next(new Node(7));
        Node list2 = new Node(99).next(new Node(1).next(new Node(4)));

        Node intersect = finder.find(list1, list2);

        assertThat(intersect, nullValue());

    }
}