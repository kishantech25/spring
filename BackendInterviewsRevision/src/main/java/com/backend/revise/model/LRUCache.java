import java.util.HashMap;
import java.util.Map;

/**
 * LRU (Least Recently Used) Cache Implementation
 * 
 * This is a custom implementation of an LRU Cache using:
 * 1. HashMap - for O(1) get/put operations
 * 2. Doubly Linked List - for O(1) add/remove operations and tracking access order
 * 
 * Time Complexity:
 * - get(key): O(1)
 * - put(key, value): O(1)
 * - Space Complexity: O(capacity)
 * 
 * Use Case: Memory caching, page replacement in OS, browser cache
 */
public class LRUCache {
    
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private final Map<Integer, Node> cache; // HashMap for O(1) lookup
    private final Node head;  // Dummy node pointing to most recently used
    private final Node tail;  // Dummy node pointing to least recently used
    
    /**
     * Initialize LRU Cache with given capacity
     * @param capacity Maximum number of items the cache can hold
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head
        this.tail = new Node(0, 0); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }
    
    /**
     * Get value from cache
     * Moves the accessed node to the front (most recently used position)
     * 
     * @param key The key to retrieve
     * @return The value if found, -1 if not found
     */
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        Node node = cache.get(key);
        moveToFront(node); // Mark as recently used
        return node.value;
    }
    
    /**
     * Put value into cache
     * If key exists, update its value and move to front
     * If cache is full, evict the least recently used item
     * 
     * @param key The key to insert/update
     * @param value The value to store
     */
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Key exists: update value and move to front
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            // New key: add to cache
            if (cache.size() == capacity) {
                // Cache is full: evict LRU (least recently used) node
                removeLRU();
            }
            
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToFront(newNode);
        }
    }
    
    /**
     * Remove a node from its current position and add it to the front
     * (marking it as most recently used)
     */
    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }
    
    /**
     * Add node right after head (most recently used position)
     */
    private void addToFront(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    /**
     * Remove node from its current position
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    /**
     * Remove the least recently used node (right before tail)
     */
    private void removeLRU() {
        Node lru = tail.prev;
        removeNode(lru);
        cache.remove(lru.key);
    }
    
    /**
     * Display cache state for debugging
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cache: [");
        Node current = head.next;
        while (current != tail) {
            sb.append(current.key).append("->").append(current.value);
            current = current.next;
            if (current != tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
