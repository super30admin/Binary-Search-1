
// Time Complexity :O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Unsure about implementation of ArratReader. 

// We first find the search range within which the target element lies. Then the code perform the binary search by repeatedly updating the mid pointer and comparing the value at that index with the target. The search continues by adjusting the left and right pointers accordingly until the target is found or the search space is exhausted. The method returns the index of the target or -1 if it is not found.
// In leet code we just uUse the reader to first find the space within which binary search needs to be applied, increment right by a multiplication factor of 2 and assign previous right to left. Once search space is found, apply traditional binary search algorithm

/**
 * HAD TO BE IMPLEMNTED HERE
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */

class Problem3 {
    public interface ArrayReader {
        int get(int index);
    }

    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem3 s = new Problem3();
        ArrayReader reader = new ArrayReader() {
            int[] array = { -1, 0, 3, 5, 9, 12 };

            @Override
            public int get(int index) {
                if (index >= 0 && index < array.length) {
                    return array[index];
                } else {
                    throw new IndexOutOfBoundsException("Index out of range");
                }
            }
        };

        // System.out.println("Target found at index: " + solution.search(reader, 2));
        System.out.println("Target  found at index: " + s.search(reader, 5));

    }
}
