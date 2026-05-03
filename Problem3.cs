// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
To find the correct seach space over which I need to perform binary search, I set low = 0 and high = 1 initially. I iterate through 
the ArrayReader till reader.get(high) < target. In each iteration, I set low = high and double the value of high. After finding the
correct window where I need to perform the search, I perform binary search between the low and high indices.
*/

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
        int low = 0, high = 1;

        while (reader.get(high) < target)
        {
            low = high;
            high = high * 2;
        }

        return BSearch(reader, low, high, target);
    }

    private int BSearch(ArrayReader reader, int low, int high, int target)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target)
            {
                return mid;
            }

            else if (reader.get(mid) < target)
            {
                low = mid + 1;
            }

            else
            {
                high = mid - 1;
            }
        }

        return -1;
    }
}