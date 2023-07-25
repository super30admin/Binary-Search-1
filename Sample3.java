// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * I set low as 0 and high as 1 initially. I traverse through the array until reader.get(high)>target. I set low = high and double the
 * size of high in every iteration. Once I reach an index of high for which reader.get(high)>target, I perform binary search to obtain the
 * index of the target element. If the element is not present, I return -1.
 */


class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while(reader.get(high)<target)
        {
            low = high;
            high = high * 2;
        }
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(reader.get(mid)==target)
            {
                return mid;
            }
            else if(reader.get(mid)<target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;
    }
}