package com.buggymind.strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Given a list of words, find all pairs of 'unique indices' such that the
 * concatenation of the two words is a palindrome.
 */
public class GeneratePalindromePairs {

    @ToString
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

                if (isPalindrome(l + r)) {
                    result.add(new Pair(i, j));
                }
            }
        }

        return result;
    }

    List<Pair> byLookup(final String[] words) {
        List<Pair> result = new LinkedList<>();
        Map<String, Integer> locationMap = new HashMap<>();

        for (int i = 0; i < words.length; ++i) {
            locationMap.put(words[i], i);
        }

        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                String prefix = words[i].substring(0,j);
                String postfix = words[i].substring(j);

                if (isPalindrome(prefix)) {
                    String reversedPostfix = reverse(postfix);
                    Integer loc = locationMap.get(reversedPostfix);
                    if (loc != null && !loc.equals(i)) {
                        result.add(new Pair(loc, i));
                    }
                }

                if (isPalindrome(postfix)) {
                    String reversedPrefix = reverse(prefix);
                    Integer loc = locationMap.get(reversedPrefix);
                    if (loc != null && !loc.equals(i)) {
                        result.add(new Pair(i, loc));
                    }
                }
            }
        }

        return result;
    }

    private String reverse(final String str) {
        StringBuffer result = new StringBuffer();
        for (int i = 0, sz = str.length(); i < sz; ++i) {
            result.append(str.charAt(sz - i - 1));
        }
        return result.toString();
    }
}
