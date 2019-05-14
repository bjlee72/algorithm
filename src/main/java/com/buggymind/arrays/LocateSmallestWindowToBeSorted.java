package com.buggymind.arrays;

import com.buggymind.type.Bounds;

/**
 * Given an array of integers that are out of order, determine the bounds of the
 * smallest window that must be sorted in order for the entire array to be sorted.
 *
 * <p>For example, given [3, 7, 5. 6, 9], you should return (1, 3).
 */
public class LocateSmallestWindowToBeSorted {

    public Bounds locate(final int[] input) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int right = Integer.MAX_VALUE;
        int left = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; ++i) {
            if (input[i] >= max) {
                max = input[i];
            } else {
                right = i;
            }
        }

        for (int i = input.length -1; i >= 0; --i) {
            if (input[i] <= min) {
                min = input[i];
            } else {
                left = i;
            }
        }

        return new Bounds(left, right);
    }

}
