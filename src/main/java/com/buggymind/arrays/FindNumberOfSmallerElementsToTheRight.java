package com.buggymind.arrays;

/**
 * Given an array of integers, return a new array where each element in the new array
 * is the number of smaller elements to the right of that element in the original
 * input array.
 *
 * <p>For example, if [5, 3, 7, 1, 2] is given as an input, the result should be
 * [3, 2, 2, 0, 0]. Brute-force algorithm should not be an answer. It's too easy.
 * At least O(n log n) should be guaranteed.
 */
public class FindNumberOfSmallerElementsToTheRight {

    /**
     * This implementation is based on the quicksort partitioning algorithm.
     * However, still O(^2). Thus naive.
     */
    public int[] naive(int[] input) {
        int[] result = new int[input.length];
        int[] temp = new int[input.length];

        for (int idx = 0; idx < result.length; ++idx) {
            // pivot
            temp[idx] = input[input.length - idx -1];

            // quick sort partitioning.
            int i = 0;
            for (int j = i; j < idx; ++j) {
                if (temp[j] < temp[idx]) {
                    swap(temp, i, j);
                    ++i;
                } else {
                    break;
                }
            }
            swap(temp, i, idx);

            // 'i' will be the # of the smaller items
            result[input.length - idx -1] = i;
        }

        return result;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
