// Time Complexity : log(m) + log(n) where m steps to find the bucket to search the target & n is
// number of element to search for the target.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No (do not have premium subscription.)
// Any problem you faced while coding this : No

public class SearchInSortedArrayUnknownSize
{
    class Solution
    {
        public int search(ArrayReader reader, int target)
        {
            int low =0, high = 1;
            while (reader.get(high) <= target)
            {
                low = high;
                high = 2 * high;
            }
            while(low <= high)
            {
                int mid = low + (high-low)/2;
                if(reader.get(mid) == target)
                    return mid;
                else if(target < reader.get(mid))
                    high = mid-1;
                else
                    low = mid+1;
            }
            return -1;
        }
    }
}
