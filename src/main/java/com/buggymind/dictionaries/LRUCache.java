package com.buggymind.dictionaries;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Implement an LRU cache.
 */
public class LRUCache<K, V> {

    static class DoublyLinkedList {

        @Accessors(fluent = true, chain = true)
        @Getter
        @Setter
        static class Node<K, V> {
            private K key;
            private V value;

            private Node prev;
            private Node next;

            Node(final K key, final V value) {
                this.key = key;
                this.value = value;
                this.prev = null;
                this.next = null;
            }
        }

        private Node head;
        private Node tail;

        DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        boolean isEmpty() {
            return this.head == null;
        }

        /*
         * We only implement the necessary operations
         */
        DoublyLinkedList addToFront(final Node node) {
            if (isEmpty()) {
                this.head = this.tail = node;
                return this;
            }

            head.prev(node);
            node.next(head);
            head = node;

            return this;
        }

        Node removeLast() {
            if (isEmpty()) {
                throw new IllegalStateException("List is empty.");
            }

            Node removed = tail;
            remove(tail);
            return removed;
        }

        DoublyLinkedList remove(final Node node) {
            if (node == null) {
                throw new IllegalArgumentException("node is null - cannot remove.");
            }

            if (node == head) {
                if (head.next() != null) {
                    head.next().prev(null);
                }
                head = head.next();
            } else if (node == tail) {
                tail.prev().next(null);
                tail = tail.prev();
            } else {
                node.prev().next(node.next());
                node.next().prev(node.prev());
            }

            return this;
        }
    }


    private Map<K, DoublyLinkedList.Node<K, V>> cache;
    private DoublyLinkedList order;
    private int size;

    LRUCache(final int size) {
        this.cache = new HashMap<>();
        this.order = new DoublyLinkedList();
        this.size = size;
    }

    public LRUCache put(final K key, final V value) {
        DoublyLinkedList.Node<K, V> found = cache.get(key);
        if (found != null) {
            found.value(value);
            order
                    .remove(found)
                    .addToFront(found);
            return this;
        }

        if (cache.size() == this.size) {
            DoublyLinkedList.Node node = order.removeLast();
            cache.remove(node.key());
        }

        DoublyLinkedList.Node newNode = new DoublyLinkedList.Node(key, value);
        cache.put(key, newNode);
        order.addToFront(newNode);

        return this;
    }

    public V get(final K key) {
        DoublyLinkedList.Node<K, V> found = cache.get(key);
        if (found == null) {
            return null;
        }

        order
                .remove(found)
                .addToFront(found);

        return found.value();
    }
}
