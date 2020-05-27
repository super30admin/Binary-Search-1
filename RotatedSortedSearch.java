// Time Complexity :O(log n) where n is the number of elements in the array
// Space Complexity :O(1) since the operation is performed on a fixed number of elements and no auxillary data is produced.
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length==0) return -1;
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[high]==target)
            {
                return high;
            }
            else if(nums[low]==target)
            {
                return low;
            }
            if(nums[mid]>=nums[low])
            {
                if(target>=nums[low] && target<=nums[mid])
                {
                    high = mid -1;
                }
                else
                {
                    low = mid+1;
                }
            }
            else
            {
                if(target<=nums[high] && target>=nums[mid])
                {
                    low = mid +1;
                }
                else
                {
                    high = mid-1;
                }
            }
            
        }
        
        
        return -1;
    }
}