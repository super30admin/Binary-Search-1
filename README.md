# Binary Search - 1

This document provides solutions to three common problems involving binary search. Each problem is solved with an efficient approach, leveraging the properties of binary search to achieve optimal time complexity.

---

## Problem 1: Search a 2D Matrix

**Problem Link**: [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)

### Problem Description:
Given an `m x n` matrix where each row is sorted in ascending order and the first integer of each row is greater than the last integer of the previous row, write an efficient algorithm to search for a target value in the matrix. Return `true` if the target exists, otherwise return `false`.

### Solution:
The solution treats the 2D matrix as a flattened 1D array and performs binary search on it. The row and column indices are calculated dynamically during the search.

```java
public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;

    int low = 0, high = m * n - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        int r = mid / n; // Row index
        int c = mid % n; // Column index

        if (matrix[r][c] == target) {
            return true;
        } else if (matrix[r][c] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return false;
}
```

---

## Problem 2: Search in a Rotated Sorted Array

**Problem Link**: [Search in a Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

### Problem Description:
Given a rotated sorted array and a target value, return the index of the target if it exists, otherwise return `-1`. The array is rotated at an unknown pivot, and no duplicate values exist in the array.

### Solution:
The solution uses binary search to identify whether the target lies in the left or right sorted portion of the array, adjusting the search range accordingly.

```java
public int search(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == target) return mid;

        if (arr[low] <= arr[mid]) { // Left portion is sorted
            if (arr[low] <= target && arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else { // Right portion is sorted
            if (arr[mid] < target && arr[high] >= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
    return -1;
}
```

---

## Problem 3: Search in an Infinite Sorted Array

**Problem Link**: [Search in a Sorted Array of Unknown Size](https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/)

### Problem Description:
Given a sorted array of unknown length and a target value, return the index of the target if it exists, otherwise return `-1`. Accessing an element out of bounds throws an exception. If the target occurs multiple times, return the index of any occurrence.

### Solution:
The solution first determines a valid search range by exponentially expanding the bounds until the target is within range. Then, binary search is performed within the identified range.

```java
public int Search(ArrayReader reader, int target) {
    int low = 0, high = 1;

    // Expand the range until the target is within bounds
    while (reader.get(high) < target) {
        low = high;
        high *= 2;
    }

    // Perform binary search within the range
    while (low <= high) {
        int mid = low + (high - low) / 2;
        int midValue = reader.get(mid);

        if (midValue == target) return mid;
        if (midValue > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return -1;
}
```

---

### Summary:
These problems demonstrate the versatility of binary search in solving a variety of challenges, from searching in 2D matrices to handling rotated arrays and infinite sorted arrays. Each solution is optimized for logarithmic time complexity, making them efficient for large datasets.
