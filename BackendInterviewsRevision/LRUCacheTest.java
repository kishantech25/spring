/**
 * Comprehensive test cases for LRU Cache implementation
 * Tests cover all key scenarios and edge cases
 */
public class LRUCacheTest {
    
    public static void main(String[] args) {
        System.out.println("========== LRU CACHE TEST SUITE ==========\n");
        
        testBasicOperations();
        testEviction();
        testUpdateValue();
        testAccessOrder();
        testComplexScenario();
        
        System.out.println("\n========== ALL TESTS PASSED ==========");
    }
    
    /**
     * Test 1: Basic get/put operations
     */
    private static void testBasicOperations() {
        System.out.println("Test 1: Basic Operations");
        System.out.println("-".repeat(40));
        
        LRUCache cache = new LRUCache(2);
        
        cache.put(1, 100);
        System.out.println("put(1, 100): " + cache);
        assert cache.get(1) == 100 : "Get should return 100";
        
        cache.put(2, 200);
        System.out.println("put(2, 200): " + cache);
        assert cache.get(2) == 200 : "Get should return 200";
        
        // Non-existent key
        assert cache.get(3) == -1 : "Non-existent key should return -1";
        System.out.println("get(3): -1 (not found)");
        
        System.out.println("✓ Test 1 PASSED\n");
    }
    
    /**
     * Test 2: LRU Eviction when capacity is exceeded
     */
    private static void testEviction() {
        System.out.println("Test 2: LRU Eviction");
        System.out.println("-".repeat(40));
        
        LRUCache cache = new LRUCache(2);
        
        cache.put(1, 100);
        cache.put(2, 200);
        System.out.println("After put(1, 100) and put(2, 200): " + cache);
        
        // Add third element - should evict 1 (least recently used)
        cache.put(3, 300);
        System.out.println("After put(3, 300): " + cache);
        assert cache.get(1) == -1 : "Key 1 should be evicted";
        assert cache.get(2) == 200 : "Key 2 should exist";
        assert cache.get(3) == 300 : "Key 3 should exist";
        
        System.out.println("✓ Test 2 PASSED\n");
    }
    
    /**
     * Test 3: Update existing key value (should not evict)
     */
    private static void testUpdateValue() {
        System.out.println("Test 3: Update Existing Key");
        System.out.println("-".repeat(40));
        
        LRUCache cache = new LRUCache(2);
        
        cache.put(1, 100);
        cache.put(2, 200);
        System.out.println("After put(1, 100) and put(2, 200): " + cache);
        
        // Update key 1 with new value
        cache.put(1, 150);
        System.out.println("After put(1, 150): " + cache);
        assert cache.get(1) == 150 : "Key 1 value should be updated to 150";
        
        // Add new element - should evict 2, not 1 (since 1 was just updated)
        cache.put(3, 300);
        System.out.println("After put(3, 300): " + cache);
        assert cache.get(1) == 150 : "Key 1 should still exist";
        assert cache.get(2) == -1 : "Key 2 should be evicted";
        assert cache.get(3) == 300 : "Key 3 should exist";
        
        System.out.println("✓ Test 3 PASSED\n");
    }
    
    /**
     * Test 4: Access order matters (get should update recency)
     */
    private static void testAccessOrder() {
        System.out.println("Test 4: Access Order Tracking");
        System.out.println("-".repeat(40));
        
        LRUCache cache = new LRUCache(3);
        
        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);
        System.out.println("After inserting 1,2,3: " + cache);
        
        // Access key 1 (makes it recently used)
        int val = cache.get(1);
        System.out.println("get(1) returns: " + val + ", cache state: " + cache);
        
        // Now key 2 is least recently used, should be evicted
        cache.put(4, 400);
        System.out.println("After put(4, 400): " + cache);
        assert cache.get(1) == 100 : "Key 1 should exist";
        assert cache.get(2) == -1 : "Key 2 should be evicted (it was LRU)";
        assert cache.get(3) == 300 : "Key 3 should exist";
        assert cache.get(4) == 400 : "Key 4 should exist";
        
        System.out.println("✓ Test 4 PASSED\n");
    }
    
    /**
     * Test 5: Complex scenario combining multiple operations
     */
    private static void testComplexScenario() {
        System.out.println("Test 5: Complex Scenario");
        System.out.println("-".repeat(40));
        
        LRUCache cache = new LRUCache(3);
        
        // Build up cache to capacity
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        System.out.println("Step 1 - Full cache: " + cache);
        
        // Access elements in different order
        cache.get(1); // 1 becomes most recent
        cache.get(3); // 3 becomes most recent
        System.out.println("Step 2 - After get(1), get(3): " + cache);
        
        // Add new element - 2 should be evicted (LRU)
        cache.put(4, 40);
        System.out.println("Step 3 - After put(4, 40): " + cache);
        assert cache.get(2) == -1 : "Key 2 should be evicted";
        assert cache.get(1) == 10 : "Key 1 should exist";
        assert cache.get(3) == 30 : "Key 3 should exist";
        assert cache.get(4) == 40 : "Key 4 should exist";
        
        // Update existing key
        cache.put(1, 15);
        System.out.println("Step 4 - After put(1, 15): " + cache);
        
        // Add another element - 3 should be evicted (it's LRU now)
        cache.put(5, 50);
        System.out.println("Step 5 - After put(5, 50): " + cache);
        assert cache.get(3) == -1 : "Key 3 should be evicted";
        assert cache.get(1) == 15 : "Key 1 value should be 15";
        assert cache.get(4) == 40 : "Key 4 should exist";
        assert cache.get(5) == 50 : "Key 5 should exist";
        
        System.out.println("✓ Test 5 PASSED\n");
    }
}
