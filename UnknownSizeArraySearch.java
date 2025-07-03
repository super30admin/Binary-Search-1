/*PROBLEM STATEMENT:
 702. Search in a Sorted Array of Unknown Size
 You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:
returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
returns 231 - 1 if the i is out of the boundary of the array.
You are also given an integer target.
Return the index k of the hidden array where secret[k] == target or return -1 otherwise.
You must write an algorithm with O(log n) runtime complexity.
Constraints:
1 <= secret.length <= 104
-104 <= secret[i], target <= 104
secret is sorted in a strictly increasing order.
Input: secret = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in secret and its index is 4.
 */

/*Time Complexity :O(logn)
Space Complexity :O(1)
Approach:
Since the array size is unknown, first expand the search window exponentially until the value at 'high' is greater than or equal to the target.Then perform a binary search between low and high to locate the target index. */
public class UnknownSizeArraySearch {

    public int search(ArrayReader reader, int target) {
        // Assuming values of low as high as 0 and 1 respectively as we dont know the
        // starting and ending indexes of the array
        int low = 0;
        int high = 1;
        // Expand the range exponentially until we find a value >= target
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }
        // If value at 'high' index is the target, return it directly
        if (reader.get(high) == target) {
            return high;
        }
        // Perform binary search within [low, high] range
        return binarySearch(low, high, reader, target);
    }

    private int binarySearch(int low, int high, ArrayReader reader, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;// Prevent Integer overflow
            if (reader.get(mid) == target) {
                return mid; // Found target
            } else if (target > reader.get(mid)) {// Move right if target value is greater than mid
                low = mid + 1;
            } else {// else move left
                high = mid - 1;
            }
        }
        return -1; // Target not found
    }
}

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */
