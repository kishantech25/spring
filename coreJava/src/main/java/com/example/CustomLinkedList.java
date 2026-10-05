package com.example;

public class CustomLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    // Node
    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    // Add at the end
    public void add(E item) {

        Node<E> newNode = new Node<>(last, item, null);

        if (last == null) {
            // List is empty
            first = newNode;
        } else {
            // Connect old last to new node
            last.next = newNode;
        }

        // New node becomes last
        last = newNode;

        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Get first element
    public E getFirst() {
        if (first == null) {
            return null;
        }

        return first.item;
    }

    // Get last element
    public E getLast() {
        if (last == null) {
            return null;
        }

        return last.item;
    }

    // Print list from first → last
    public void printForward() {

        Node<E> current = first;

        while (current != null) {
            System.out.print(current.item + " <-> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Print list from last → first
    public void printBackward() {

        Node<E> current = last;

        while (current != null) {
            System.out.print(current.item + " <-> ");
            current = current.prev;
        }

        System.out.println("null");
    }
}