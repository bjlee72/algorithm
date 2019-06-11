package com.buggymind.stacks;

import java.util.Stack;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Given a string of round, curly, and square opening and closing brackets,
 * return whether the brackets are balanced (well-formed).
 *
 * For example, given the string '([])[]({})' should return true.
 *
 * Given the string '([]}', you should return false.
 */
public class DetermineBracketsAreBalanced {

    @AllArgsConstructor
    @Getter
    enum Bracket {
        ROUND('(', ')'),
        CURLY('{', '}'),
        SQUARE('[', ']');

        private char open;
        private char close;

        boolean isOpen(final char ch) {
            return this.open == ch;
        }

        boolean isClose(final char ch) {
            return this.close == ch;
        }

        static Bracket of(final char ch) {
            for (Bracket constant : Bracket.values()) {
                if (constant.getOpen() == ch || constant.getClose() == ch) {
                    return constant;
                }
            }
            throw new IllegalArgumentException("Wrong bracket character: " + ch);
        }
    }

    @Getter
    static class BracketStack {
        private Bracket bracketType;
        private Stack<Character> stack;

        BracketStack(Bracket bracketType) {
            this.bracketType = bracketType;
            this.stack = new Stack<>();
        }

        boolean isEmpty() {
            return stack.isEmpty();
        }

        void push(char ch) {
            this.stack.push(ch);
        }

        char pop() {
            return this.stack.pop();
        }
    }

    static class BracketStacks {

        private BracketStack roundBracketStack = new BracketStack(Bracket.ROUND);
        private BracketStack curlyBracketStack = new BracketStack(Bracket.CURLY);
        private BracketStack squareBracketStack = new BracketStack(Bracket.SQUARE);

        private BracketStack get(final char bracket) {
            switch (Bracket.of(bracket)) {
                case ROUND:
                    return roundBracketStack;
                case CURLY:
                    return curlyBracketStack;
                case SQUARE:
                    return squareBracketStack;
            }

            // this cannot happen without code error.
            throw new AssertionError("Wrong bracket character " + bracket);
        }

        boolean isEmpty() {
            return roundBracketStack.isEmpty() && curlyBracketStack.isEmpty() && squareBracketStack.isEmpty();
        }
    }

    private BracketStacks bracketStacks = new BracketStacks();

    boolean isWellFormed(final String input) {
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);

            BracketStack stack = bracketStacks.get(ch);

            if (stack.getBracketType().isOpen(ch)) {
                stack.push(ch);
            } else if (stack.getBracketType().isClose(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return bracketStacks.isEmpty();
    }
}
