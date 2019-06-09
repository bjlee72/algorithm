package com.buggymind.graphs;

import static com.buggymind.graphs.FindLongestIncreasingPathInMatrix.Point;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FindLongestIncreasingPathInMatrixTest {

    private FindLongestIncreasingPathInMatrix finder;

    @Before
    public void setup() {
        finder = new FindLongestIncreasingPathInMatrix();
    }

    @Test
    public void find() {
        int[][] input = {{1, 2, 9},
                         {5, 3, 8},
                         {4, 6, 7}};

        List<Point> longestPath = finder.find(input);

        // 1->2->3->6->7->8->9
        assertThat(longestPath.size(), is(7));
    }
}