package com.buggymind.trees;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.LinkedList;

/**
 * When a complete binary three and a number is given, decide whether
 * the number has a designated node in the tree.
 *
 * A complete binary tree is a balanced tree that grows from the left side.
 *
 * For example:
 *
 *    1 ->   1 ->   1   ->    1   ->     1
 *          /      / \       / \        / \
 *         2      2   3     2  3       2  3
 *                         /          / \
 *                        4          4  5
 *
 * Every node for this balanced tree DOES NOT HAVE any stored value inside.
 *
 * When a value is given, you should decide if the value can be mapped to a node
 * in the tree. For example, in the last tree shown above, 5 is in the tree and 6 is
 * not. Thus, when 5 is given as an input, true should be returned, and false should be
 * returned when 6 is given.
 */
public class CompleteBinaryTreeHasNodeForValue {

    @Getter
    @Setter
    @Accessors(fluent = true)
    @NoArgsConstructor
    static class Node {
        private Node left;
        private Node right;
    }

    boolean decide(@NonNull final Node node, final int value) {
        if (value <= 0) {
            return false;
        }

        int rb = 1; // beginning of the range that value belongs
        int re = 1; // end of the range that value belongs

        for (int i = 1; true;i = i * 2) {
            if (value >= i && value <= i * 2 - 1) {
                rb = i;
                re = i * 2 - 1;
                break;
            }
        }

        LinkedList<Integer> directions = new LinkedList<>();

        while (rb < re) {
            int mid = rb + (re - rb) / 2 + 1;
            if (value < mid) {
                directions.add(0); // go left;
                re = mid - 1;
            } else {
                directions.add(1); // go right;
                rb = mid;
            }
        }

        Node current = node;
        while (current != null && !directions.isEmpty()) {
            int dir = directions.removeFirst();
            if (dir == 0) {
                current = current.left();
            } else {
                current = current.right();
            }
        }

        // if empty, 'current' is the matching node.
        return current != null && directions.isEmpty();
    }

}
