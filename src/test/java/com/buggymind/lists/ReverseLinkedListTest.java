package com.buggymind.lists;

import org.junit.Test;

import static com.buggymind.lists.ReverseLinkedList.SinglyLinkedList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReverseLinkedListTest {

    @Test
    public void reverseOddNumberSinglyList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);

        singlyLinkedList.reverse();

        assertThat(singlyLinkedList.toString(), is("3->2->1"));
    }

    @Test
    public void reverseEvenNumberSinglyList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);

        singlyLinkedList.reverse();

        assertThat(singlyLinkedList.toString(), is("4->3->2->1"));
    }
}