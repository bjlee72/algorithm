package com.buggymind.graphs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * All the values in the matrix are 'unique' integers.
 */
public class FindLongestIncreasingPathInMatrix {

    @Accessors(fluent = true)
    @Getter
    static class Point implements Comparable<Point> {
        private int x;
        private int y;
        private int value;

        @Setter
        private boolean visited;

        Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.visited = false;
        }

        @Override
        public int compareTo(Point o) {
            if (o == null) {
                throw new IllegalArgumentException("Cannot compare with null");
            }
            return this.value - o.value;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d,'%d')", x,y,value);
        }
    }

    List<Point> find(final int[][] input) {
        if (input == null) {
            return Collections.emptyList();
        }

        List<Point> points = new LinkedList<>();
        Point[][] map = new Point[input.length][];
        for (int i = 0; i < input.length; ++i) {
            map[i] = new Point[input[i].length];
        }

        for (int i = 0; i < input.length; ++i) {
            for (int j = 0; input[i] != null && j < input[i].length; ++j) {
                Point p = new Point(i, j, input[i][j]);
                points.add(p);
                map[i][j] = p;
            }
        }

        Collections.sort(points);
        List<Point> longestPath = Collections.emptyList();

        for (Point p : points) {
            if (p.visited()) {
                continue;
            }

            List<Point> path = findLongestPathFrom(Collections.singletonList(p), map);

            if (path.size() > longestPath.size()) {
                longestPath = path;
            }
        }

        return longestPath;
    }

    List<Point> findLongestPathFrom(final List<Point> path, final Point[][] map) {
        Point lastPoint = path.get(path.size() - 1);
        int x = lastPoint.x();
        int y = lastPoint.y();
        int value = lastPoint.value();

        List<Point> longestPath = path;

        int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int i = 0; i < delta.length; ++i) {
            int p = x + delta[i][0];
            int q = y + delta[i][1];

            if (p < 0 || p >= map.length) continue;
            if (q < 0 || q >= map[p].length) continue;

            if (map[p][q].value() > value) {
                // we already considered path including this node.
                // in the future, we don't need to search paths starting from this node.
                map[p][q].visited(true);

                List<Point> newPath = new LinkedList<>(path);
                newPath.add(map[p][q]);

                List<Point> longerPath = findLongestPathFrom(newPath, map);

                if (longerPath.size() > longestPath.size()) {
                    longestPath = longerPath;
                }
            }
        }

        return longestPath;
    }
}
