// Time Complexity : O(logn)
// Space Complexity : O(n) (size of array)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :N/A
class Solution {
    public int search(int[] nums, int target) {
        
        int low = 0, high = nums.length-1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            if(nums[mid]==target)
            {
                return mid;
            } else if(nums[mid]>=nums[low])
            {
                if(target>=nums[low] && target < nums[mid])
                    high = mid-1;
                else
                    low = mid + 1;
            }else
            {
                if(target >nums[mid] && target <=nums[high])
                     low = mid+1;
                else
                     high = mid-1;
            }
                
        }
        return -1;
    }
}