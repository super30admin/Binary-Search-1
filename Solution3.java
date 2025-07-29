
// Approach:
// We start with a small window [low, high] and keep doubling ‘high’ until the value at high is ≥ target or out of bounds.
// Once we have a valid window that must contain the target if it exists, we perform a standard binary search using reader.get(mid).
// This lets us locate the target index in O(log n) time without knowing the array’s length in advance.


// Time Complexity : O(log n)  
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes  
// Any problem you faced while coding this : No  

class Solution3{
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        
        // Grow the search window exponentially until we exceed or reach the target
        while (reader.get(high) < target) {
            low = high;               // shift low to previous high
            high = high * 2;          // double the window size
        }
        
        // Now binary search between low and high
        while (low <= high) {
            // safer midpoint calculation to avoid overflow
            int mid = low + (high - low) / 2;
            int val = reader.get(mid);     // may return 2^31-1 if out of bounds
            
            if (val == target) {
                return mid;                // found the target
            } else if (val == Integer.MAX_VALUE || val > target) {
                // if out of bounds or value too large, search left half
                high = mid - 1;
            } else {
                // value too small, search right half
                low = mid + 1;
            }
        }
        
        // target not found
        return -1;
    }
}

