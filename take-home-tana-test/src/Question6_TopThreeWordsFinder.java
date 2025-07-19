import java.util.*;

public class Question6_TopThreeWordsFinder {

    // Returns the top 3 most common words from a sentence, sorted alphabetically.
    // Assumes words are space-separated, case-sensitive.
    public static List<String> grabTopThreeWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return Collections.emptyList(); // Nothing to do here
        }

        // Break the sentence into individual words using whitespace
        String[] wordList = sentence.trim().split("\\s+");

        // Count how often each word appears
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : wordList) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // Build a heap to prioritize by frequency (then alphabetically)
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
                (e1, e2) -> {
                    if (e1.getValue().equals(e2.getValue())) {
                        return e1.getKey().compareTo(e2.getKey()); // tie-break alphabetically
                    }
                    return e2.getValue() - e1.getValue(); // more frequent first
                }
        );

        heap.addAll(wordCounts.entrySet());

        // Get the top 3 (or fewer) from the heap
        List<String> topWords = new ArrayList<>();
        int picked = 0;
        while (!heap.isEmpty() && picked < 3) {
            topWords.add(heap.poll().getKey());
            picked++;
        }

        // Sort final result alphabetically as per requirement
        Collections.sort(topWords);
        return topWords;
    }

    // ---------------- Sample runs ----------------
    public static void main(String[] args) {
        String s1 = "hi there care to discuss algorithm basis or how to solve algorithm or";
        System.out.println("Input: " + s1);
        System.out.println("Top 3: " + grabTopThreeWords(s1));  // [algorithm, or, to]

        String s2 = "apple banana apple cherry banana banana mango";
        System.out.println("Input: " + s2);
        System.out.println("Top 3: " + grabTopThreeWords(s2));  // [apple, banana, cherry]

        String s3 = "one two three four five six";
        System.out.println("Input: " + s3);
        System.out.println("Top 3: " + grabTopThreeWords(s3));  // [five, four, one]
    }
}
