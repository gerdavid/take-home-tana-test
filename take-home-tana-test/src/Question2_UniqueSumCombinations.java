import java.util.*;

public class Question2_UniqueSumCombinations {

    // Entry point to count how many unique combinations give us the target sum.
    // Note: every number can be used at most once per combination (since we move index forward)
    public static int countUniqueWays(int[] numbers, int goal) {
        return explore(numbers, 0, goal);
    }

    // Recursive approach, trying both including and skipping the current number
    private static int explore(int[] arr, int pos, int left) {
        if (left == 0) {
            return 1;  // found a valid combo
        }
        if (pos >= arr.length || left < 0) {
            return 0;  // no way forward
        }

        // Try taking the number at 'pos'
        int withCurrent = explore(arr, pos + 1, left - arr[pos]);

        // Skip it entirely
        int withoutCurrent = explore(arr, pos + 1, left);

        return withCurrent + withoutCurrent;
    }

    // ------------------- Test Cases -----------------------

    public static void main(String[] args) {
        runAllTests();
    }

    private static void runAllTests() {
        // Some classic test cases
        runTest(new int[]{1, 2, 3, 4, 5}, 10, 3);
        runTest(new int[]{1, 2, 4, 7, 5}, 17, 1);
        runTest(new int[]{2, 4, 6, 10}, 16, 2);

        // Duplicates handled positionally, not by value
        runTest(new int[]{1, 1, 1, 1}, 2, 6);  // Should be 6 distinct index-based pairs

        // Edge stuff
        runTest(new int[]{}, 0, 1);  // Empty set sums to 0, that's a valid combo
        runTest(new int[]{}, 5, 0);  // Nothing to use here
    }

    private static void runTest(int[] input, int target, int expected) {
        int actual = countUniqueWays(input, target);
        System.out.println("Array: " + Arrays.toString(input));
        System.out.println("Target: " + target + " → Result: " + actual);
        if (actual == expected) {
            System.out.println("Passed");
        } else {
            System.out.println(" Failed — Expected: " + expected);
        }
        System.out.println();
    }
}
