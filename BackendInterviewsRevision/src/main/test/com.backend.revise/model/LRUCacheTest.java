
public class LRUCacheTest {

    public LRUCacheTest() {
    }

    public static void main(String[] var0) {
        System.out.println("========== LRU CACHE TEST SUITE ==========\n");
        testBasicOperations();
        testEviction();
        testUpdateValue();
        testAccessOrder();
        testComplexScenario();
        System.out.println("\n========== ALL TESTS PASSED ==========");
    }

    private static void testBasicOperations() {
        System.out.println("Test 1: Basic Operations");
        System.out.println("-".repeat(40));
        LRUCache var0 = new LRUCache(2);
        var0.put(1, 100);
        System.out.println("put(1, 100): " + String.valueOf(var0));

        assert var0.get(1) == 100 : "Get should return 100";

        var0.put(2, 200);
        System.out.println("put(2, 200): " + String.valueOf(var0));

        assert var0.get(2) == 200 : "Get should return 200";

        assert var0.get(3) == -1 : "Non-existent key should return -1";

        System.out.println("get(3): -1 (not found)");
        System.out.println("✓ Test 1 PASSED\n");
    }

    private static void testEviction() {
        System.out.println("Test 2: LRU Eviction");
        System.out.println("-".repeat(40));
        LRUCache var0 = new LRUCache(2);
        var0.put(1, 100);
        var0.put(2, 200);
        System.out.println("After put(1, 100) and put(2, 200): " + String.valueOf(var0));
        var0.put(3, 300);
        System.out.println("After put(3, 300): " + String.valueOf(var0));

        assert var0.get(1) == -1 : "Key 1 should be evicted";

        assert var0.get(2) == 200 : "Key 2 should exist";

        assert var0.get(3) == 300 : "Key 3 should exist";

        System.out.println("✓ Test 2 PASSED\n");
    }

    private static void testUpdateValue() {
        System.out.println("Test 3: Update Existing Key");
        System.out.println("-".repeat(40));
        LRUCache var0 = new LRUCache(2);
        var0.put(1, 100);
        var0.put(2, 200);
        System.out.println("After put(1, 100) and put(2, 200): " + String.valueOf(var0));
        var0.put(1, 150);
        System.out.println("After put(1, 150): " + String.valueOf(var0));

        assert var0.get(1) == 150 : "Key 1 value should be updated to 150";

        var0.put(3, 300);
        System.out.println("After put(3, 300): " + String.valueOf(var0));

        assert var0.get(1) == 150 : "Key 1 should still exist";

        assert var0.get(2) == -1 : "Key 2 should be evicted";

        assert var0.get(3) == 300 : "Key 3 should exist";

        System.out.println("✓ Test 3 PASSED\n");
    }

    private static void testAccessOrder() {
        System.out.println("Test 4: Access Order Tracking");
        System.out.println("-".repeat(40));
        LRUCache var0 = new LRUCache(3);
        var0.put(1, 100);
        var0.put(2, 200);
        var0.put(3, 300);
        System.out.println("After inserting 1,2,3: " + String.valueOf(var0));
        int var1 = var0.get(1);
        System.out.println("get(1) returns: " + var1 + ", cache state: " + String.valueOf(var0));
        var0.put(4, 400);
        System.out.println("After put(4, 400): " + String.valueOf(var0));

        assert var0.get(1) == 100 : "Key 1 should exist";

        assert var0.get(2) == -1 : "Key 2 should be evicted (it was LRU)";

        assert var0.get(3) == 300 : "Key 3 should exist";

        assert var0.get(4) == 400 : "Key 4 should exist";

        System.out.println("✓ Test 4 PASSED\n");
    }

    private static void testComplexScenario() {
        System.out.println("Test 5: Complex Scenario");
        System.out.println("-".repeat(40));
        LRUCache var0 = new LRUCache(3);
        var0.put(1, 10);
        var0.put(2, 20);
        var0.put(3, 30);
        System.out.println("Step 1 - Full cache: " + String.valueOf(var0));
        var0.get(1);
        var0.get(3);
        System.out.println("Step 2 - After get(1), get(3): " + String.valueOf(var0));
        var0.put(4, 40);
        System.out.println("Step 3 - After put(4, 40): " + String.valueOf(var0));

        assert var0.get(2) == -1 : "Key 2 should be evicted";

        assert var0.get(1) == 10 : "Key 1 should exist";

        assert var0.get(3) == 30 : "Key 3 should exist";

        assert var0.get(4) == 40 : "Key 4 should exist";

        var0.put(1, 15);
        System.out.println("Step 4 - After put(1, 15): " + String.valueOf(var0));
        var0.put(5, 50);
        System.out.println("Step 5 - After put(5, 50): " + String.valueOf(var0));

        assert var0.get(3) == -1 : "Key 3 should be evicted";

        assert var0.get(1) == 15 : "Key 1 value should be 15";

        assert var0.get(4) == 40 : "Key 4 should exist";

        assert var0.get(5) == 50 : "Key 5 should exist";

        System.out.println("✓ Test 5 PASSED\n");
    }
}
