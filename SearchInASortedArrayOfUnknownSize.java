/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No



class SearchInASortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1;

        // Step 1: Exponential search to find a valid right boundary
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }

        // Binary search
        while (left <= right) {
            int mid = left + (right - left)/2;
            int midValue = reader.get(mid);

            if (midValue == target) return mid;
            else if (midValue > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return -1;
    }
}