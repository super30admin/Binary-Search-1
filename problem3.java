// Time Complexity : O(log n) (finding range + binary search)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Need to first expand search window then do normal binary search.

class Solution {
    public int search(ArrayReader reader, int target) {

        // first find the search range using exponential jumps
        int low = 0;
        int high = 1;

        // keep expanding high until reader.get(high) >= target
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        // now do normal binary search between low and high
        while (low <= high) {

            int mid = low + (high - low) / 2;
            int val = reader.get(mid);

            if (val == target) return mid;
            else if (val < target) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }
}
