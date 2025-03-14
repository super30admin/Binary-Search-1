// Time Complexity: O(log N), where N is the index where the target is found or exceeded.
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach: First, expand the search range exponentially until the target is within bounds.
// Then, perform a standard binary search within the identified range.
// This ensures an efficient search without knowing the array size in advance.



/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0, r = 1;
        
        while (reader.get(r) < target) {
            l = r;
            r *= 2;
        }
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int val = reader.get(mid);
            
            if (val == target) return mid;
            else if (val > target) r = mid - 1;
            else l = mid + 1;
        }
        
        return -1;
    }
}
