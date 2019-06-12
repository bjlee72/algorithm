package com.buggymind.stacks;

import java.util.Stack;

/**
 * Given a string of round, curly, and square opening and closing brackets,
 * return whether the brackets are balanced (well-formed).
 *
 * For example, given the string '([])[]({})' should return true.
 *
 * Given the string '([]}', you should return false.
 */
public class DetermineBracketsAreBalanced {

    boolean isWellFormed(final String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);

            if (isOpenBracket(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();

                if (isMatchingBracket(top, ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    boolean isOpenBracket(final char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    boolean isMatchingBracket(final char open, final char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }
}
