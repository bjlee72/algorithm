package com.buggymind.strings;

import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Given a list of words, find all pairs of 'unique indices' such that the
 * concatenation of the two words is a palindrome.
 */
public class GeneratePalindromePairs {

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode
    static class Pair {
        private int l;
        private int r;
    }

    static boolean isPalindrome(String input) {
        for (int i = 0; i < input.length() / 2; ++i) {
            char l = input.charAt(i);
            char r = input.charAt(input.length() - i - 1);

            if (l != r) {
                return false;
            }
        }

        return true;
    }

    /*
     * Let's say the words.length == n. This algorithm works in O(n^2).
     */
    List<Pair> naive(final String[] words) {
        List<Pair> result = new LinkedList<>();

        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words.length; ++j) {
                if (i == j) {
                    continue;
                }

                String l = words[i];
                String r = words[j];

                if (l.charAt(0) != r.charAt(r.length()-1)) {
                    continue;
                }

                if (isPalindrome(l + r)) {
                    result.add(new Pair(i, j));
                }
            }
        }

        return result;
    }
}
