// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach:

// Got the low and high values by putting a while loop on a condition that element at high < target
// Applied binary search to get the answer
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }
        // System.out.println(low);
        // System.out.println(high);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}