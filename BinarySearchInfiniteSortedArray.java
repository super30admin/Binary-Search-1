// Time complexity: O(log N) - reducing the elements by half in each iteration
// Space complexity: O(1) - no extra space used
// Did this code successfully run on Leetcode : Will run it later with premium
// Any problem you faced while coding this : No
class BinarySearchInfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while (reader.get(high) < target) {
            // move the search to right of high
            low = high + 1;
            high *= 2;
        } // breaks when the search range is found
        // binary search for the target
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target) {
                // target found
                return mid;
            }
            if (reader.get(mid) < target) {
                // move the search to right of mid
                low = mid + 1;
            } else {
                // move the search to left of mid
                high = mid - 1;
            }
        }
        // target not found
        return -1;
    }
}