// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only
// Since the array size is unknown, we first expand the search range exponentially until the target lies within the range.
//start with low and high check if target is within the range of high if not move high twice and low in place of high
// Once a valid range is found, we apply binary search to efficiently locate the target.
// This approach ensures logarithmic time complexity while using constant extra space.


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *     public int Get(int index) {}
 * }
 */
class Solution
{
    public int Search(ArrayReader reader, int target)
    {
        int low = 0;
        int high = 1;
        while (reader.get(high) < target)
        {
            low = high;
            high = high * 2;
        }
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }
}