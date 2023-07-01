
// Time Complexity : O(log n) we are considering all the positive integers in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public int search(ArrayReader reader, int target) {

        // Initialize the search range
        int low = 0;
        int high = Integer.MAX_VALUE;

        // Perform binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the target is found
            if (target == reader.get(mid)) {
                return mid;
            }
            // Adjust the search range based on the target value
            else if (target > reader.get(mid)) {
                low = mid + 1;  // Target is in the right half
            }
            else {
                high = mid - 1; // Target is in the left half
            }
        }

        // Target element is not found
        return -1;
    }
}