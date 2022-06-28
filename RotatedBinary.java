// Time Complexity : O(logn)
// Space Complexity : No extra space required. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Brainstorming on this twisted version of binary search


// Your code here along with comments explaining your approach


class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while( low <= high)
        {
            int mid = (low+high)/2;
            
            if(nums[mid] == target)
                return mid; 
            
            if (nums[low] <= nums[mid])
            {
                if(nums[mid] > target && nums[low] <= target)
                    high = mid - 1;
                else
                    low  = mid + 1; 
            }
            else
            {
                if(nums[mid] < target && nums[high] >= target )
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        
        return -1;    
    }
}

