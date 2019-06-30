package com.buggymind.trees;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * For example, given the following pre-order traversal:
 *
 * [a, b, d, e, c, f, g]
 *
 * and for the following in-order traversal:
 *
 * [d, b, e, a, f, c, g]
 *
 * you should return the following tree:
 *
 *               a
 *            /    \
 *           b     c
 *          / \   / \
 *         d  e  f  g
 *
 */
public class ReconstructFromTraversal {

    @Accessors(fluent = true)
    static class Node {
        @Getter private char value;

        @Getter @Setter private Node left;
        @Getter @Setter private Node right;

        Node(final char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public static boolean equals(final Node l, final Node r) {
            if (l == null && r == null) {
                return true;
            } else if (l == null) {
                return false;
            } else if (r == null) {
                return false;
            }

            return l.value() == r.value()
                    && equals(l.left(), r.left())
                    && equals(l.right(), r.right());
        }
    }

    /**
     * Will assume that we don't have any duplicates in the given input arrays.
     */
    Node from(@NonNull final char[] preOrder, @NonNull final char[] inOrder) {
        if (preOrder.length != inOrder.length) {
            throw new IllegalArgumentException("The length of two input arrays should be the same");
        }

        /*
         * from the in-order history, we build the location map.
         */
        Map<Character, Integer> locationsByCharacter = new HashMap<>();
        for (int i = 0; i < inOrder.length; ++i) {
            locationsByCharacter.put(inOrder[i], i);
        }

        return formSimpleTree(preOrder, 0, preOrder.length - 1, locationsByCharacter);
    }

    /**
     * start will be always a root.
     */
    Node formSimpleTree(final char[] input, final int start, final int end, Map<Character, Integer> ordering) {
        if (start > end) {
            // just to simplify the code overall
            return null;
        }

        if (start == end) {
            return new Node(input[start]);
        }

        // find the range of values that has the locations less than input[start]
        char pivot = input[start];
        int pivotLocation = ordering.get(pivot);

        int i;
        int sb; // start of the smaller value
        int se; // end of the smaller value

        // find the range of smaller numbers (excluding start)
        for (i = start + 1, sb = start + 1, se = start; i <= end; ++i) {
            char current = input[i];
            if (ordering.get(current) < pivotLocation) {
                se = i;
            } else {
                break;
            }
        }

        // range of the greater numbers
        int gb = i; // start of the greater value
        int ge = end; // end of the greater value

        Node left = formSimpleTree(input, sb, se, ordering);
        Node right = formSimpleTree(input, gb, ge, ordering);

        return new Node(pivot).left(left).right(right);
    }
}
