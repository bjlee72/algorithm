package com.buggymind.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.google.common.annotations.VisibleForTesting;

/**
 * Given a word w and a string s, find all indices in s which are the
 * starting locations of anagrams of w.
 *
 * <p>For example, if w := ab and s := abxaba, then the result := [0, 3, 4].
 *
 * <p>An anagram is a word or phrase formed by rearranging the letters of
 * a different word or phrase, typically using all the original letters exactly once.
 */
public class FindAnagramIndices {

    List<Integer> find(final String word, final String text) {
        if (word == null || word.length() > text.length()) {
            return Collections.emptyList();
        }

        int windowSize = word.length();

        List<Integer> result = new LinkedList<>();

        // assume that the given word and text are composed by only alphabet (a-z)
        int[] textHistogramWithWindows = createHistogram(text, windowSize);
        int[] wordHistogram = createHistogram(word, windowSize);

        for (int i = 0; i <= (text.length() - windowSize); ++i) {
            if (i > 0) {
                // move the window
                recalculateHistogram(textHistogramWithWindows, text, i, windowSize);
            }

            if (equals(wordHistogram, textHistogramWithWindows)) {
                result.add(i);
            }
        }

        return result;
    }

    @VisibleForTesting
    int[] createHistogram(final String input, final int len) {
        int[] histogram = Arrays.copyOf(new int[]{0}, 26);
        return setHistogramWithString(histogram, input, len);
    }

    @VisibleForTesting
    int[] setHistogramWithString(int[] histogram, String string, int len) {
        for (int i = 0; i < len; ++i) {
            ++histogram[toDigit(string.charAt(i))];
        }
        return histogram;
    }

    @VisibleForTesting
    int toDigit(char ch) {
        return Character.toLowerCase(ch) - 'a';
    }

    @VisibleForTesting
    void recalculateHistogram(int[] histogram, String text, int start, int windowSize) {
        int prev_char = toDigit(text.charAt(start - 1));
        --histogram[prev_char];
        int incoming_char = toDigit(text.charAt(start + windowSize - 1));
        ++histogram[incoming_char];
    }

    boolean equals(int[] histogramA, int[] histogramB) {
        return Arrays.equals(histogramA, histogramB);
    }

}
