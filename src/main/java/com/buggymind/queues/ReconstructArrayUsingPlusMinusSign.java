package com.buggymind.queues;

import java.util.LinkedList;
import java.util.List;

/**
 * The sequence [0, 1, ..., N] has been jumbled, and the only clue you have
 * for its order is an array representing whether each number is larger or
 * smaller than the last. Given the information, reconstruct an array that is
 * consistent with it.
 *
 * For example, given [None, +, +, -, +], you could return [1, 2, 3, 0, 4].
 *
 * 1 -> you don't have any last (previous) number, thus None.
 * 2 -> larger than the last, thus +
 * 3 -> larger than the last, thus +
 * 0 -> smaller than the last, thus -
 * 4 -> larger than the last, thus +
 *
 * [2, 3, 4, 0, 1] can be also an answer.
 */
public class ReconstructArrayUsingPlusMinusSign {

    /**
     * The example output [2, 3, 4, 0, 1] is misleading - there can be many other answers.
     *
     * Notation used in the below examples and answer:
     *
     * ^ - The last +/None position.
     *
     * Example 1: [None, +, +, -, +]
     *
     * [None               -> 0
     * [None +             -> 0 1
     * [None + +           -> 0 1 2
     *                            ^
     * [None + + -         -> 0 1 3 2
     * [None + + - +       -> 0 1 3 2 4
     *
     * Example 2: [None - - + - - + +]
     *
     * [None              -> 0
     *                       ^
     * [None -            -> 1 0
     * [None - -          -> 2 1 0
     * [None - - +        -> 2 1 0 3
     *                             ^
     * [None - - + -      -> 2 1 0 4 3
     *
     * Example 3: [None + - - + - - + +]
     *
     * [None              -> 0
     * [None +            -> 0 1
     *                         ^
     * [None + -          -> 0 2 1
     * [None + - -        -> 0 3 2 1
     * [None + - - +      -> 0 3 2 1 4
     *                               ^
     * [None + - - + -    -> 0 3 2 1 5 4
     * [None + - - + - -  -> 0 3 2 1 6 5 4
     *
     */
    List<Integer> naive(final String[] input) {
        int lastNoneOrPlusPosition = 0;
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < input.length; ++i) {
            switch(input[i]) {
                case "None":
                case "+":
                    result.addLast(i);
                    lastNoneOrPlusPosition = i;
                    break;
                case "-":
                    // how many items I need to pop?
                    int numberOfItemsToPop = i - lastNoneOrPlusPosition;
                    LinkedList<Integer> stack = new LinkedList<>();
                    for (int j = 0; j < numberOfItemsToPop; ++j) {
                        stack.addLast(result.removeLast());
                    }

                    result.addLast(i);

                    // move all the items in 'stack' back to the result.
                    while (!stack.isEmpty()) {
                        result.addLast(stack.removeLast());
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Not expected input:" + input[i]);
            }
        }

        return result;
    }

    List<Integer> optimized(final String[] input) {
        List<Integer> result = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < input.length - 1; ++i) {
            if (input[i+1].equals("-")) {
                stack.addLast(i);
            } else {
                result.add(i);
                while (!stack.isEmpty()) {
                    result.add(stack.removeLast());
                }
            }
        }

        result.add(input.length - 1);
        while (!stack.isEmpty()) {
            result.add(stack.removeLast());
        }

        return result;
    }
}
