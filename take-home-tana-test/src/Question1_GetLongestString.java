import java.util.*;

public class Question1_GetLongestString {

    // So here's the main method that finds the longest valid string from the given bunch.
    // A string is "valid" if:
    // - it has no repeated letters side by side
    // - it only uses characters from our approved list
    public static String findLongestValid(List<Character> allowed, String[] candidates) {
        Set<Character> allowedSet = new HashSet<>(allowed);  // Faster checks with a Set

        String longestSoFar = null;

        for (String word : candidates) {
            if (isStringOkay(word, allowedSet)) {
                if (longestSoFar == null || word.length() > longestSoFar.length()) {
                    longestSoFar = word;  // New champ
                }
            }
        }

        return longestSoFar;
    }

    // Helper that does the actual string validation
    private static boolean isStringOkay(String word, Set<Character> allowedSet) {
        if (word == null || word.isEmpty()) return false;

        char lastChar = 0; // Technically a weird default, but gets the job done
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!allowedSet.contains(ch)) {
                return false;  // nope, invalid char found
            }

            // quick check for back-to-back duplicates
            if (i > 0 && ch == lastChar) {
                return false;  // double trouble
            }

            lastChar = ch;
        }

        return true;
    }

    // Basic test runner — throws in a few different cases
    public static void runSomeTests() {
        List<Character> allowedChars = Arrays.asList('A', 'B', 'C', 'D');

        System.out.println("=== Test Case 1: Main Check ===");
        String[] sampleWords = {
                "AABCDA",      // fail → repeated A
                "ABCDZADC",    // fail → 'Z' not allowed
                "ABCDBCA",     // pass
                "ABCDABDCA"    // longest pass
        };
        testIt(allowedChars, sampleWords, "ABCDABDCA");

        System.out.println("=== Test Case 2: All Invalid ===");
        testIt(allowedChars, new String[]{"AA", "ZZZ"}, null);

        System.out.println("=== Test Case 3: All Valid, Same Length ===");
        testIt(allowedChars, new String[]{"AB", "AC", "AD"}, "AB"); // any of them would do really

        System.out.println("=== Test Case 4: No Candidates ===");
        testIt(allowedChars, new String[]{}, null);

        System.out.println("=== Test Case 5: One Valid ===");
        testIt(allowedChars, new String[]{"A"}, "A");

        System.out.println("=== Test Case 6: One Invalid ===");
        testIt(allowedChars, new String[]{"BB"}, null);
    }

    // Tiny helper to show results and whether they match expectations
    private static void testIt(List<Character> allowed, String[] words, String expected) {
        String output = findLongestValid(allowed, words);

        System.out.println("Words: " + Arrays.toString(words));
        System.out.println("Result: " + output);

        if (expected == null) {
            System.out.println("Expected: null --> " + (output == null ? "✓" : "✗"));
        } else {
            System.out.println("Expected: " + expected + " --> " + (expected.equals(output) ? "✓" : "✗"));
        }

        System.out.println();
    }

    // Yep, gotta have a main
    public static void main(String[] args) {
        runSomeTests();
    }
}
