package com.buggymind.lists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Given the head of a singly linked list, reverse it in-place.
 */
public class ReverseLinkedList {

    @Getter
    @Setter
    static class Node<T> {
        private T value;
        private Node next;

        Node(T v) {
            this.value = v;
            this.next = null;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(this.value);
            if (this.next != null) {
                builder.append("->");
                builder.append(this.next.toString());
            }
            return builder.toString();
        }
    }

    static class SinglyLinkedList<T> {
        private Node head;
        private Node tail;

        SinglyLinkedList add(T v) {
            if (tail == null) {
                head = tail = new Node<>(v);
            } else {
                Node<T> newNode = new Node<>(v);
                tail.setNext(newNode);
                tail = newNode;
            }

            return this;
        }

        @Override
        public String toString() {
            if (head != null) {
                return head.toString();
            }

            return "()";
        }

        @Getter
        @AllArgsConstructor
        private static class HeadAndTail {
            private Node head;
            private Node tail;
        }

        void reverse() {
            HeadAndTail headAndTail = reverseRecursive(this.head);
            this.head = headAndTail.getHead();
            this.tail = headAndTail.getTail();
        }

        HeadAndTail reverseRecursive(final Node root) {
            // both head and tail are null
            if (root == null) {
                return null;
            }

            Node head = root;
            Node remainder = head.getNext();

            // only one node in the list
            if (remainder == null) {
                return new HeadAndTail(head, head);
            }

            // make the head new tail
            HeadAndTail pair = reverseRecursive(remainder);
            Node oldHead = head;
            oldHead.setNext(null);
            pair.getTail().setNext(oldHead);
            return new HeadAndTail(pair.getHead(), oldHead);
        }
    }
}
