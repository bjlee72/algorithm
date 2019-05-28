package com.buggymind.strings;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static com.buggymind.strings.PrintZigzagForm.Position;

public class PrintZigzagFormTest {

    private PrintZigzagForm printer;

    @Before
    public void setup() {
        printer = new PrintZigzagForm();
    }

    @Test
    public void print() {
        List<Position> result = printer.print("thisisazigzag", 6);

        assertThat(result,
                contains(
                        new Position(0,0),
                        new Position(1,1),
                        new Position(2,2),
                        new Position(3,3),
                        new Position(4,4),
                        new Position(5,5),
                        new Position(6,4),
                        new Position(7,3),
                        new Position(8,2),
                        new Position(9,1),
                        new Position(10,0),
                        new Position(11,1),
                        new Position(12,2)));
    }
}