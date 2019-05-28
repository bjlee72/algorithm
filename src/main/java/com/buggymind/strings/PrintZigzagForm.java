package com.buggymind.strings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Given a string and a number of lines k, print the string in zigzag form.
 *
 * In zigzag, characters are printed out diagonally from top left to bottom right
 * until reaching the kth line, then back up to top right, and so on.
 *
 * for example, given the sentence "thisisazigzag" and k = 4, you should print
 *
 *      t     a     g
 *       h   s z   a
 *        i i   i z
 *         s     g
 */
public class PrintZigzagForm {

    /**
     * Position on the screen
     */
    @Getter
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    static class Position {
        int x;
        int y;
    }

    List<Position> print(final String input, final int k) {
        char[][] screen = createScreen(k, input.length());
        List<Position> result = new LinkedList<>();

        int y = 0;
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);
            int x = i;
            int d = (i / (k-1)) % 2 == 0 ? 1 : -1;

            writeOnScreen(screen, x, y, ch);
            result.add(new Position(x, y));

            y = y + d;
        }

        printScreen(screen);
        return result;
    }

    static char[][] createScreen(int row, int column) {
        char[][] screen = new char[row][];
        for (int i = 0; i < row; ++i) {
            screen[i] = new char[column];
            Arrays.fill(screen[i], ' ');
        }
        return screen;
    }

    static void printScreen(char[][] screen) {
        for (int i = 0; i < screen.length; ++i) {
            for (int j = 0; j < screen[i].length; ++j) {
                System.out.print(screen[i][j]);
            }
            System.out.println();
        }
    }

    static void writeOnScreen(char[][] screen, int x, int y, char ch) {
        screen[y][x] = ch;
    }
}
