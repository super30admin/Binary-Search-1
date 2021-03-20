// Time Complexity :O(log N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach

/**
 * // This is ArrayReader's API interface. // You should not implement it, or
 * speculate about its implementation interface ArrayReader { public int get(int
 * index) {} }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        if (reader.get(0) == target)
            return 0;
        // Find the higher bound by multiplying by 2
        while (target > reader.get(high))
            high *= 2;
        int result = BinarySearch(low, high, target, reader);
        return result;
    }

    private int BinarySearch(int low, int high, int target, ArrayReader reader) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}