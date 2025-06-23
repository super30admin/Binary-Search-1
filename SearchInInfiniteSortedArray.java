// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Approach:
// Start with a small search range and expand it exponentially until the target is within bounds.
// Once the range is large enough, perform a standard binary search between low and high.
// Used ArrayReader.get(index) to safely access values and avoid accessing out-of-bound indices.

class Solution {

    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        // Expand the window until the target is within [low, high]
        while (reader.get(high) < target) {
            low = high;
            high *= 2;
        }

        // Perform binary search within the established bounds
        while (low <= high) {
            int mid = low + (high - low)/2;
            int actualMid = reader.get(mid);

            if (actualMid == target) {
                return mid;
            }
            else if (actualMid < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // Target not found
        return -1;
    }
}