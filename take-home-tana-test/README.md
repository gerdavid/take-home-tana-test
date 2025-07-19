# Longest Valid String Finder (Java)

This project implements a Java function `getLongestString` that returns the longest valid string from a given list of strings, based on the following rules:

### ✅ Validation Rules
1. No repeated identical adjacent characters (e.g., `"AAB"` is invalid).
2. Only characters from a provided list of allowed characters are permitted.

### 🧪 Example

**Allowed Characters:** `['A', 'B', 'C', 'D']`  
**Input Strings:** `"AABCDA"`, `"ABCDZADC"`, `"ABCDBCA"`, `"ABCDABDCA"`  
**Output:** `"ABCDABDCA"`

### 🧰 Features
- Simple Java class with `main()` to run test cases
- Includes edge case handling (empty list, all invalid, ties)
- Code is clean, well-commented, and easy to understand

### 📦 How to Run
Compile and run the Java file:

```bash
javac Question1_GetLongestString.java
java Question1_GetLongestString
