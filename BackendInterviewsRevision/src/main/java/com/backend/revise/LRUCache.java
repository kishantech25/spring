package com.backend.revise;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int var1) {
        this.capacity = var1;
        this.cache = new HashMap();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int var1) {
        if (!this.cache.containsKey(var1)) {
            return -1;
        } else {
            Node var2 = (Node)this.cache.get(var1);
            this.moveToFront(var2);
            return var2.value;
        }
    }

    public void put(int var1, int var2) {
        if (this.cache.containsKey(var1)) {
            Node var3 = (Node)this.cache.get(var1);
            var3.value = var2;
            this.moveToFront(var3);
        } else {
            if (this.cache.size() == this.capacity) {
                this.removeLRU();
            }

            Node var4 = new Node(var1, var2);
            this.cache.put(var1, var4);
            this.addToFront(var4);
        }

    }

    private void moveToFront(Node var1) {
        this.removeNode(var1);
        this.addToFront(var1);
    }

    private void addToFront(Node var1) {
        var1.prev = this.head;
        var1.next = this.head.next;
        this.head.next.prev = var1;
        this.head.next = var1;
    }

    private void removeNode(Node var1) {
        var1.prev.next = var1.next;
        var1.next.prev = var1.prev;
    }

    private void removeLRU() {
        Node var1 = this.tail.prev;
        this.removeNode(var1);
        this.cache.remove(var1.key);
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder("Cache: [");
        Node var2 = this.head.next;

        while(var2 != this.tail) {
            var1.append(var2.key).append("->").append(var2.value);
            var2 = var2.next;
            if (var2 != this.tail) {
                var1.append(", ");
            }
        }

        var1.append("]");
        return var1.toString();
    }

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int var1, int var2) {
            this.key = var1;
            this.value = var2;
        }
    }
}