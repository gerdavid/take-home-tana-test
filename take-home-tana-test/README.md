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
```
# Question 3: Zero Array Reducer (Java)

This Java program determines whether a given array of positive integers can be transformed into an array where all elements **except the first** are zero, using the following operation any number of times:

### ✅ Problem Rules
- Each element must remain non-negative during the transformation.
- The operation can be applied multiple times on any valid index.

### 🧪 Example

**Input:** `[1, 2, 3]`  
**Output:** `1` (possible)  
**Steps:**
- [1,2,3] → [1,2,1] → [1,1,1] → [1,1,0] → [1,0,0]

**Input:** `[5, 4, 3]`  
**Output:** `0` (not possible)

### 🚀 How to Run

```bash
javac Question3_ZeroReducer.java
java Question3_ZeroReducer
```
# Question 4: First Unique Product (Java)

This Java program finds the **first product** in a list that appears **only once**. If all products are repeated, it returns `null`.

### ✅ Problem Description

Given an array of product names (strings), return the first product that is **non-repeating**.

### 🧪 Example

**Input:** `["Apple", "Computer", "Apple", "Bag"]`  
**Output:** `"Computer"`

**Input:** `["Pen", "Pen", "Book", "Book"]`  
**Output:** `null`

### 🧠 Approach

- Uses a `LinkedHashMap` to count frequencies while maintaining insertion order.
- Iterates to find the first entry with count `1`.

### 🚀 How to Run

```bash
javac Question4_UniqueProductPicker.java
java Question4_UniqueProductPicker
```
# Question 5: nearest minimun gap

This Java program finds the **minimum distance** between any two occurrences of the **smallest value** in a given array of integers.

### ✅ Problem Statement

You are given an array of `n` integers. Find the **distance between the two closest minimum values** in the array.

**Constraints:**
- The minimum value is guaranteed to appear **at least twice**.

### 🧪 Example

**Input:** `[1, 2, 3, 1, 4, 5, 2]`  
**Output:** `3`  
Explanation: The smallest value is `1`, which appears at indices 0 and 3 → distance = `3 - 0 = 3`.

**Input:** `[9, 8, 7, 6, 5, 4, 5, 4]`  
**Output:** `2`  
Explanation: The smallest value is `4`, which appears at




