// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class SearchInSortedArrayUnkownSize {
    
    public int search(ArrayReader reader, int target)
    {
        int low = 0, high = 1;

        // get the range of low and high we need to search target in
        while(reader.get(high) < target)
        {
            low = high+1;
            high = 2 * high;
        }
        if(high == Integer.MAX_VALUE)
            high = 10000; // reset the high index to questions constraint

        while(low <= high)
        {
            int mid = low + (high-low)/2; // avoid integer overflow

            if(reader.get(mid) == target)
                return mid;
            
            if(reader.get(mid) < target)
            {
                low = mid+1;
            }
            else
                high = mid-1;    
        }
        return -1;
    }
}
