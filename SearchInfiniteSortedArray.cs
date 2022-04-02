// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : didnt tried, dont have premium subscription to run on leetcode
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//we need to find the lower and higher bound
//first approach, low = 0 and high = 10^4, then we can do binary search, but we want to go better high bound
//second approach, low = 0 and high = 1, we will multiply higher bound by 2 till value at higher bound is greater than target
public int SearchInfiniteSortedArray(ArrayReader reader, int target) {
    if(nums == null || nums.Length == 0)
            return -1;
        
    int low = 0;
    int high = 1;

    //low = 0 and high = 1, we will multiply higher bound by 2 till value at higher bound is greater than target
    //complexityof this is O(logn) because we are multiplying by 2
    //we can multiply ofby 3, 4 or 5, we will increase space complexity also.
    while(reader.get(high) < target)
    {
        high *= 2;
    }

    //now we have lower and higher bound, we can run ou regular binary search 
    while(low <= high)
    {
        int mid = low + (high - low)/2;
        int val = reader.get(mid);
        if(val == target)
            return mid;
        
        if(target < val)
            high = mid - 1;
        else
            low = mid + 1;
    }
        
    return -1;
}