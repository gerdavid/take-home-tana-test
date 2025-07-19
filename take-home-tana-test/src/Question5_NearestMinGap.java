import java.util.*;

public class Question5_NearestMinGap {

    // Finds the smallest distance between any two occurrences of the minimum value.
    // If not possible (e.g. array too short), returns -1.
    public static int findClosestMinDistance(int[] arr) {
        if (arr == null || arr.length < 2) return -1;

        int minVal = Integer.MAX_VALUE;

        // First pass: Find what the minimum actually is
        for (int num : arr) {
            if (num < minVal) {
                minVal = num;
            }
        }

        // Second pass: Find the tightest gap between repeated mins
        int lastSeen = -1;
        int closestGap = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == minVal) {
                if (lastSeen != -1) {
                    int gap = i - lastSeen;
                    if (gap < closestGap) {
                        closestGap = gap;
                    }
                }
                lastSeen = i; // Update for next match
            }
        }

        return closestGap;
    }

    // ---------------- Test Runner ----------------

    public static void main(String[] args) {
        runSampleTests();
    }

    private static void runSampleTests() {
        test(new int[]{1, 2, 3, 1, 4, 5, 2}, 3);
        test(new int[]{5, 1, 1, 5, 1, 5, 1}, 1);
        test(new int[]{9, 8, 7, 6, 5, 4, 5, 4}, 2);
        test(new int[]{1, 1}, 1);
        test(new int[]{3, 2, 1, 4, 1, 5, 6, 1}, 2);
    }

    private static void test(int[] input, int expected) {
        int actual = findClosestMinDistance(input);
        System.out.println("Array: " + Arrays.toString(input));
        System.out.println("Output: " + actual);
        System.out.println("Expected: " + expected + " --> " +
                (actual == expected ? "ok" : "not ok"));
        System.out.println();
    }
}
