package com.buggymind.queues;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers and a number k, where 1 <= k <= array.length,
 * compute the maximum values of each subarray of length k.
 *
 * For example, let's say the array is [10, 5, 2, 7, 8, 7] and k = 3.
 * We should get [10, 7, 8, 8] since:
 *
 *  - max(10, 5, 2) --> 10
 *  - max(5, 2, 7)  --> 7
 *  - max(2, 7, 8)  --> 8
 *  - max(7, 8, 7)  --> 8
 */
public class MaximumOfKLengthSubarrays {

    /**
     * The approach taken here is, "update maxIndex only when it's necessary".
     *
     * You can optimize this with the following 2 approaches combined:
     *
     *   1. Keep the tracking information about whether you can remove the number
     *      out of the queue. The original index of the element would be helpful.
     *   2. Remove the smaller elements out of the queue because they are not
     *      necessary to track.
     */
    List<Integer> compute(final int[] input, final int k) {
        if (k >= input.length) {
            return Collections.singletonList(input[maxIndex(input, 0, input.length - 1)]);
        }

        List<Integer> result = new LinkedList<>();

        int maxIdx = maxIndex(input, 0, k - 1);
        int maxVal = input[maxIdx];

        result.add(maxVal);

        for (int i = 1; i < input.length - k + 1; ++i) {
            int removed = i - 1;
            int left = i;
            int right = i + k - 1;

            if (input[right] > maxVal) {
                maxIdx = right;
                maxVal = input[right];
            } else if (maxIdx == removed) {
                /*
                 * because of this, when the given input is sorted in the
                 * descending order, this implementation will give worst performance.
                 */
                maxIdx = maxIndex(input, left, right);
                maxVal = input[maxIdx];
            }

            result.add(maxVal);
        }

        return result;
    }

    private int maxIndex(final int[] input, int from, int to) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = from; i <= to; ++i) {
            if (input[i] > max) {
                max = input[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
