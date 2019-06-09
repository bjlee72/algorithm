package com.buggymind.lists;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Given a liked list, rearrange the node values such that
 * they appear in alternating low -> high -> low -> high form.
 *
 * For example, if the input is 1 -> 2 -> 3 -> 4 -> 5,
 * then the output should be 1 -> 3 -> 2 -> 5 -> 4.
 *
 * We assume that he input is sorted in the ascending order.
 */
public class RearrangeToAlternateHighLow {

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
            return String.format("%d%s",
                    value,
                    (next == null) ? "" : String.format("->%s", next.toString()));
        }
    }

    void rearrange(final Node input) {
        boolean low = true;
        Node current = input;
        Node previous = null;

        while (current != null) {
            if (low) {
                low = !low;
                previous = current;
                current = current.next();
                continue;
            }

            Node high = current;
            Node higher = current.next();

            if (higher == null) break;

            if (previous == null) {
                // this cannot happen.
                throw new AssertionError("'previous' cannot be null.");
            }

            previous.next(higher);
            high.next(higher.next());
            higher.next(high);

            // flip
            low = !low;
            previous = higher;
            current = high;
        }
    }
}
