// 33. Search in Rotated Sorted Array - https://leetcode.com/problems/search-in-rotated-sorted-array/
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution 
{
    public int search(int[] nums, int target) 
    {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high)/2; 
        if(nums[mid] == target) 
            return mid;
        
        if (nums[low] <= nums[mid]) 
        {
            if (target >= nums[low] && target <= nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
         }
        else 
        {
            if(target >= nums[mid] && target <= nums[high])
                low = mid + 1;
            else
                high = mid - 1;
        }
    }
    return -1;
  }
}