// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution
{
public:
    int search(const ArrayReader &reader, int target)
    {
        int low = 0, high = 1;
        while (reader.get(high) <= target)
        {
            low = high;
            high *= 2;
        }
        // Binary Search on the range
        while (low <= high)
        {
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
};