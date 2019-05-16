package com.buggymind.arrays;

import com.buggymind.type.Bounds;

/**
 * Given an array of numbers, naive the maximum sum of any contiguous subarray
 * of the given array.
 *
 * <p>For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum
 * would be 137, since we would take elements 42, 14, -5 and 86.
 *
 * <p>Given the array [-5, -1, -8, -9], the maximum sum would be zero, since
 * we would choose not to take any elements.
 */
public class CalculateMaximumSubArraySum {

    /**
     * This will have O^3 complexity.
     */
    public Bounds naive(final int[] input) {
        int sum = 0;
        Bounds maxBounds = null;

        for (int i = 0; i < input.length; ++i) {
            for (int j = i+1; j < input.length; ++j) {
                Bounds bounds = new Bounds(i, j);
                int boundedSum = sum(bounds, input);

                if (boundedSum > sum) {
                    maxBounds = bounds;
                    sum = boundedSum;
                }
            }
        }

        return maxBounds;
    }

    public Bounds onePass(final int[] input) {
        int sum = 0;
        int left = 0;
        int right;

        int maxSum = 0;
        int maxLeft = 0;
        int maxRight = 0;

        for (int i = 0; i < input.length; ++i) {
            sum += input[i];
            if (sum < 0) {
                // Reset
                sum = 0;
                left = i + 1;
            } else {
                right = i;

                if (sum >= maxSum) {
                    maxSum = sum;
                    maxLeft = left;
                    maxRight = right;
                }
            }
        }

        if (maxRight >= maxLeft && maxSum > 0) {
            return new Bounds(maxLeft, maxRight);
        }

        return null;
    }

    private int sum(final Bounds bounds, final int[] input) {
        int sum = 0;
        for (int i = bounds.getLower(); i <= bounds.getUpper(); ++i) {
            sum += input[i];
        }
        return sum;
    }
}
