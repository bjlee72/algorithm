package com.buggymind.stacks;

import java.util.LinkedList;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class StackToTrackMaxValue {

    static class Stack {

        @Getter
        @AllArgsConstructor
        static class Elem {
            int value;
            int max;
        }

        private LinkedList<Elem> stack;

        Stack() {
            this.stack = new LinkedList<>();
        }

        public Stack push(int value) {
            if (stack.isEmpty()) {
                stack.push(new Elem(value, value));
            } else {
                Elem topElem = stack.peek();
                stack.push(new Elem(value, Math.max(value, topElem.getMax())));
            }

            return this;
        }

        public int pop() {
            if (stack.isEmpty()) {
                throw new IllegalStateException("Stack is empty. You cannot pop.");
            }

            return stack.pop().getValue();
        }

        public int max() {
            if (stack.isEmpty()) {
                throw new IllegalStateException("Stack is empty. You cannot get max value.");
            }

            return stack.peek().getMax();
        }
    }
}
