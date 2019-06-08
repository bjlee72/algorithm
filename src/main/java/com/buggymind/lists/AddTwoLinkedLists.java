package com.buggymind.lists;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class AddTwoLinkedLists {

    @Accessors(chain = true)
    @Getter
    @Setter
    static class Node {
        int value; // this cannot be positive
        Node next;

        Node(final int v) {
            this.value = v;
        }

        static boolean equals(Node a, Node b) {
            if (a == b) return true;

            // treating null list as zero.
            int l = (a == null) ? 0 : a.getValue();
            int r = (a == null) ? 0 : b.getValue();
            if (l != r) return false;

            return equals(a == null ? null : a.getNext(), b == null ? null : b.getNext());
        }
    }

    Node add(final Node a, final Node b) {
        if (a == null && b == null) {
            return new Node(0);
        }

        Node l = a;
        Node r = b;

        // for the result
        Node head = null;
        Node tail = null;

        int carry = 0;
        while (l != null || r != null) {
            int lvalue = (l == null) ? 0 : l.getValue();
            int rvalue = (r == null) ? 0 : r.getValue();

            int sum = lvalue + rvalue + carry;
            int current = sum % 10;
            carry = sum / 10;

            if (tail == null) {
                head = tail = new Node(current);
            } else {
                Node newTail = new Node(current);
                tail.setNext(newTail);
                tail = newTail;
            }

            l = (l == null) ? null : l.getNext();
            r = (r == null) ? null : r.getNext();
        }

        if (carry != 0) {
            Node newTail = new Node(carry);
            tail.setNext(newTail);
        }

        return head;
    }
}
