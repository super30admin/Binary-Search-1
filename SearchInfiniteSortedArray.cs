// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : didnt tried, dont have premium subscription to run on leetcode
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public int SearchInfiniteSortedArray(ArrayReader reader, int target) {
    if(nums == null || nums.Length == 0)
            return -1;
        
    int low = 0;
    int high = 1;

    while(reader.get(high) < target)
    {
        high *= 2;
    }
        
    while(low <= high)
    {
        int mid = low + (high - low)/2;
        int val = reader.get(mid);
        if(val == target)
            return mid;
        
        if(target < val) //left portion of array is sorted
            high = mid - 1;
        else
            low = mid + 1;
    }
        
    return -1;
}