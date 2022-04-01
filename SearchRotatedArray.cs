// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public int SearchRotatedArray(int[] nums, int target) {

    if(nums == null || nums.Length == 0)
            return -1;
        
        int low = 0;
        int high = nums.Length - 1;
        
    while(low <= high)
    {
        int mid = low + (high - low)/2;

        if(nums[mid] == target)
            return mid;
        
        if(nums[low] <= nums[mid]) //left portion of array is sorted
        {
            if(nums[low] <= target && target < nums[mid]) // target lies in low and mid (left side)
                high = mid - 1;
            else // target lies in mid and high (right side)
                low = mid + 1;
        }
        else //right portion of array is sorted
        {
            if(nums[mid] < target && target <= nums[high]) //target lies in mid and high 
                low = mid + 1;
            else //target lies in low and mid
                high = mid - 1; 
            
        }
    }
        
    return -1;
}