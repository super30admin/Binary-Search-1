// Leetcode problem : https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * I first set low as 0 and high as 1. I run a loop until reader.get(high)<target and in each iteration I set low = high and high = high * 2. I then perform Binary search with low and high as the limits of the
 * boundary.
 */
class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0, end = 1;
        while(reader.get(end)<target)
        {
            start = end;
            end = end*2;
        }
        return bSearch(reader,target,start,end);
    }

    public int bSearch(ArrayReader reader, int target, int start, int end)
    {
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(reader.get(mid)==target)
            {
                return mid;
            }
            else if (reader.get(mid)<target)
            {
                start = mid + 1;
            }
            else 
            {
                end = mid - 1;
            }
        }
        return -1;
    }
}