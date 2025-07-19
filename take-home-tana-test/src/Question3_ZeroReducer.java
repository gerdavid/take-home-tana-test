public class Question3_ZeroReducer {

    // Goal: Try to zero out every element except the first using:
    // arr[i] = arr[i] - arr[i - 1]
    // If at any point that would go negative → bail.
    public static int canZeroify(int[] arr) {
        int len = arr.length;

        for (int i = len - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                // Would go negative, so no-go
                return 0;
            }
            arr[i] = arr[i] - arr[i - 1];  // Knock down arr[i]
        }

        return 1; // If we made it here, it worked!
    }

    // -------------------- Tests ---------------------

    public static void main(String[] args) {
        runTestCases();
    }

    private static void runTestCases() {
        // Should all match the expected output
        test(new int[]{1, 2, 3}, 1);    // Works: [1,1,1] → [1,0,1] → [1,0,0]
        test(new int[]{2, 4, 8}, 1);    // Repeated halving-ish pattern
        test(new int[]{5, 4, 3}, 0);    // Fails early, 4 < 5
        test(new int[]{1, 1, 1}, 1);    // Just enough to stay non-negative
        test(new int[]{3, 3, 1}, 0);    // Last subtraction would break
        test(new int[]{10}, 1);         // Trivial: nothing to subtract
    }

    private static void test(int[] input, int expected) {
        int[] workingCopy = input.clone();  // Keep original clean

        int outcome = canZeroify(workingCopy);

        System.out.println("Array: " + java.util.Arrays.toString(input));
        System.out.println("Result: " + outcome + " | Expected: " + expected +
                (outcome == expected ? " ok" : " fail"));
        System.out.println();
    }
}
