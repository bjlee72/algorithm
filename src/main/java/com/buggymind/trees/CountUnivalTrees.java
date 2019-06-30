package com.buggymind.trees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * A unival tree is a tree where all nodes under it have the same value.
 *
 * Given the root to a binary tree, count the number of the unival subtrees.
 */
public class CountUnivalTrees {

    static class Node {
        @Getter private int value;

        @Getter @Setter private Node left;
        @Getter @Setter private Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    @Getter
    @AllArgsConstructor
    static class SearchResult {
        private int count;
        private int value;
        private boolean unival;
    }

    int count(@NonNull final Node root) {
        SearchResult result = findUnival(root);
        return result.getCount();
    }

    private SearchResult findUnival(@NonNull final Node root) {
        if (root.getLeft() == null && root.getRight() == null) {
            return new SearchResult(1, root.getValue(), true);
        }

        else if (root.getLeft() == null) {
            SearchResult right = findUnival(root.getRight());
            if (right.isUnival() && right.getValue() == root.getValue()) {
                return new SearchResult(right.getCount() + 1, root.getValue(), true);
            } else {
                return new SearchResult(right.getCount(), root.getValue(), false);
            }
        } else if (root.getRight() == null) {
            SearchResult left = findUnival(root.getLeft());
            if (left.isUnival() && left.getValue() == root.getValue()) {
                return new SearchResult(left.getCount() + 1, root.getValue(), true);
            } else {
                return new SearchResult(left.getCount(), root.getValue(), false);
            }
        } else {
            SearchResult left = findUnival(root.getLeft());
            SearchResult right = findUnival(root.getRight());

            if (left.isUnival() && root.getValue() == left.getValue()
                    && right.isUnival() && root.getValue() == right.getValue()) {
                return new SearchResult(left.getCount() + right.getCount() + 1, root.getValue(), true);
            } else {
                return new SearchResult(left.getCount() + right.getCount(), root.getValue(), false);
            }
        }
    }
}
