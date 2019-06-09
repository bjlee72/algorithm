package com.buggymind.lists;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Given two singly linked lists that intersect at some point,
 * find the intersecting node. Assume the lists are non-cyclical.
 *
 * For example, given A = 3->7->8->10 and B = 99->1->8->10,
 *
 * return the node with value 8. In this example, assume nodes with the same
 * value are the exact same node objects.
 *
 * Do this in O(m+n) (where m and n are the lengths of the lists) and CONSTANT SPACE.
 */
public class FindIntersectingNodes {

    @Accessors(fluent = true, chain = true)
    @Getter
    static class Node {
        int value;

        @Setter
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    Node find(final Node list1, final Node list2) {
        /*
         * connect two list to make a cycle.
         */
        Node head = list1;
        Node current = head;
        while (current.next() != null) {
            current = current.next();
        }
        current.next(list2);

        /*
         * p and q are two pointers moving different speed. They
         * will meet multiple times while moving within the list.
         */
        Node p = head;
        Node q = head;

        while (p.next() != null && q.next() != null && q.next().next() != null) {
            p = p.next();
            q = q.next().next();

            if (p == q) {
                Node r = head;
                while (r != p) {
                    r = r.next();
                    p = p.next();
                }
                return p;
            }
        }

        /*
         * No cycle. No intersection.
         */
        return null;
    }
}
