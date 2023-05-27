// Time Complexity : O(log(n)) we're reducing the search space into half during each iteration
// Space Complexity : O(1), no auxiliary data storage needed
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
/**

 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class InfinitedSortedArraySearch
{
    public int search(ArrayReader reader, int target)
    {
        int targetIndex = -1;
        if(reader.get(0) > target)
        {
            return -1;
        }
        if(reader.get(0) == target)
        {
            return 0;
        }

        int low = 1;
        int high = 2;

        while(reader.get(high) <= target)
        {
            low = high;
            high = high *2;
        }

        targetIndex = binarySearch(low, high, reader, target);
        return targetIndex;
    }

    private int binarySearch(int low, int high, ArrayReader reader, int target)
    {
        int targetIndex = -1;

        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target)
            {
                return mid;
            }
            else if(reader.get(mid) < target)
            {
                low = mid +1;
            }
            else
            {
                high = mid -1;
            }
        }

        return targetIndex;
    }
}