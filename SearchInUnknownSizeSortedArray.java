/**
 * Search in Unknown Size Sorted Array
 * https://leetcode.com/problems/search-in-unknown-size-sorted-array/
 * Time Complexity: O(log(n)) where n is number of elements in the array
 * Space Complexity: O(1)
 * 
 * Description:
 * Given an integer array sorted in ascending order, write a function to search
 * for a target value in the array.
 * If the target value exists, then return its index. Otherwise, return -1.
 * Since the array size is unknown, you cannot access an index out of the bounds
 * of the array.
 * You may only access the array using an ArrayReader interface, where
 * ArrayReader.get(k) returns the element of the array at index k (0-indexed).
 * You may assume all integers in the array are less than 10000, and if you
 * access the array out of bounds, ArrayReader.get will return 2147483647.
 * 
 * 
 */
public class SearchInUnknownSizeSortedArray {
    public int search(ArrayReader reader, int target) {

        int low = 0;
        int high = low + 1;
        while (low <= high) {
            if (reader.get(low) >= target && target <= reader.get(high)) {
                while (low <= high) {
                    int mid = high - (high - low) / 2;
                    if (reader.get(mid) == target)
                        return mid;
                    if (target < reader.get(mid)) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            } else {
                low = high;
                high = high * 2;
            }

        }

        return -1;
        // Method implementation goes here
    }
}
