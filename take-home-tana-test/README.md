# All question compiled with java 17

# Question 1: Longest Valid String Finder (Java)

This program implements a Java function `getLongestString` that returns the longest valid string from a given list of strings, based on the following rules:

###  Validation Rules
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
```
# Question 2: Unique Sum Combinations (Java)

This Java program counts the number of **unique combinations** of elements in an array that sum up to a given target.

### ✅ Rules
- Each number can be used **once**
- Combinations are based on **distinct positions (indices)**, not just values
- Order of numbers in the combination does **not** matter

### 🧪 Example

**Input:**  
Array: `[1, 2, 3, 4, 5]`  
Target: `10`

**Valid combinations:**  
- [1, 2, 3, 4]  
- [1, 4, 5]  
- [2, 3, 5]  

**Output:** `3`

### 🚀 How to Run

```bash
javac Question2_UniqueSumCombinations.java
java Question2_UniqueSumCombinations
