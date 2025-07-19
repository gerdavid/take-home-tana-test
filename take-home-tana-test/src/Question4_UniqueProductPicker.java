import java.util.*;

public class Question4_UniqueProductPicker {

    // Finds the first product that shows up exactly once in the list.
    // Returns null if everything repeats.
    public static String findFirstUnique(String[] items) {
        if (items == null || items.length == 0) return null;

        // Using LinkedHashMap to keep insertion order
        Map<String, Integer> countMap = new LinkedHashMap<>();

        for (String item : items) {
            // Increment count or start at 1 if it's new
            countMap.put(item, countMap.getOrDefault(item, 0) + 1);
        }

        // Now go back through and find the first one that occurred just once
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;  // No unique item found
    }

    // -------------------- Tests --------------------

    public static void main(String[] args) {
        runSomeTests();
    }

    private static void runSomeTests() {
        test(new String[]{"Apple", "Computer", "Apple", "Bag"}, "Computer");  // Only Computer appears once
        test(new String[]{"Pen", "Pen", "Book", "Book"}, null);               // All repeated
        test(new String[]{"Monitor"}, "Monitor");                             // One item, obviously unique
        test(new String[]{}, null);                                           // Empty input
        test(new String[]{"Phone", "Phone", "Tablet", "Watch", "Tablet"}, "Watch");  // Watch is the only singleton
    }

    private static void test(String[] products, String expected) {
        String output = findFirstUnique(products);
        System.out.println("Products: " + Arrays.toString(products));
        System.out.println("Result: " + output);
        System.out.println("Expected: " + expected + " --> " +
                (Objects.equals(output, expected) ? "Passed" : "Failed"));
        System.out.println();
    }
}
