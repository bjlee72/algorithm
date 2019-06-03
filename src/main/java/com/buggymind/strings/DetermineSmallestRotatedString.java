package com.buggymind.strings;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given a string of length n and an integer k. The string can be
 * manipulated by taking one of the first k letters and moving it to the end
 * of the string.
 *
 * Write a program to determine the lexicographically smallest string that
 * can be created after an unlimited number of moves.
 *
 * For example, suppose we are given the string 'daily' and k = 1. The best
 * we can create in this case is ailyd.
 */
class DetermineSmallestRotatedString {

    String determine(final String input, final int k) {
        if (k == 0) {
            return input;
        }

        if (k == 1 && input.length() == k) {
            return input;
        }

        String min = input;

        while (true) {
            List<String> candidates = new LinkedList<>();

            for (int i = 0; i < k; ++i) {
                char current = min.charAt(i);
                String currentMoved = min.substring(0, i) + min.substring(i + 1) + current;

                if (currentMoved.compareTo(min) < 0) {
                    candidates.add(currentMoved);
                }
            }

            if (candidates.isEmpty()) {
                return min;
            }

            Collections.sort(candidates);

            min = candidates.get(0);
        }
    }

}
