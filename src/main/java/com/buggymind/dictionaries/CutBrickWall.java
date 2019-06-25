package com.buggymind.dictionaries;

import java.util.HashMap;
import java.util.Map;

/**
 * A wall consists of several rows of bricks of various integer lengths and uniform height.
 * Your goal is to find a vertical line going from the top to the bottom of the wall that
 * cuts through the fewest number of bricks. If the line goes through the edge bwteen two
 * bricks, this does not count as a cut.
 *
 * For example, suppose the input is as follows, where values in each row represent the
 * lengths of bricks in that row:
 *
 * [[3, 5, 1, 1],
 *  [2, 3, 3, 2],
 *  [5, 6],
 *  [4, 4, 2],
 *  [1, 3, 3, 3],
 *  [1, 1, 6, 1, 1]]
 *
 * The wall would then look like this:
 *
 * +--+----+++
 * |  |    |||
 * +--+----+++
 * | |  |  | |
 * +-+--+--+-+
 * |    |    |
 * +---++--+-+
 * |   |   | |
 * +---+--++-+
 * ||  |  |  |
 * +++-+--++-+
 * |||     |||
 * +++-----+++
 *
 * Should return the fewest number of bricks that must be cut to create a virtical line.
 *
 */
public class CutBrickWall {
    int min(final int[][] bricks) {
        validate(bricks);

        // map of the brick edge locations exclude the leftmos and rightmost edges
        Map<Integer, Integer> edgeCounterByLocation = new HashMap<>();

        for (int r = 0; r < bricks.length; ++r) {
            // exclude the last brick because we don't need to make an index for it
            int previousSum = 0;
            for (int c = 0; c < bricks[r].length - 1; ++c) {
                edgeCounterByLocation
                        .compute(previousSum + bricks[r][c],
                                (key, oldValue) ->
                                        (oldValue != null) ? oldValue + 1 : 1);

                previousSum += bricks[r][c];
            }
        }

        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : edgeCounterByLocation.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
            }
        }

        return bricks.length - maxCount;
    }

    private void validate(int[][] bricks) {
        int previousSum = 0;
        for (int r = 0; r < bricks.length; ++r) {
            int sum = 0;
            for (int c = 0; c < bricks[r].length; ++c) {
                sum += bricks[r][c];
            }

            if (previousSum != 0 && previousSum != sum) {
                throw new IllegalArgumentException("Wrong brick map row: " + r);
            }

            previousSum = sum;
        }
    }
}
