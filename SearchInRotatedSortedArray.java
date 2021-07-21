// Time Complexity : O(Log2 N). Where N = size of array.
// Space Complexity : O(1). No extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. While figuring out conditions.

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
           
            if(nums[mid] == target)
            {
                return mid;
            }
            
            // Check if we are in first half            
            if(nums[mid] > nums[nums.length - 1])
            {
                // if we are in first half and if target > midElem we need to update lo pointer
                // similarly, if target is lesser than firstElem, it lies in second half. so update lo pointer
                if(target > nums[mid] || target < nums[0])
                {
                    lo = mid + 1;
                }
                // otherwise update hi pointer
                else
                {
                    hi = mid - 1;
                }
            }
            else
            {
                // We are in second half
                // if target is lesser than midElem: update hi pointer
                // or if target is greater than lastElem, it lies in first half so update hi pointer.
                if(target < nums[mid] || target > nums[nums.length - 1])
                {
                    hi = mid - 1;
                }
                // otherwise update lo pointer
                else
                {
                    lo = mid + 1;
                }
            }
            
        }
        
        return -1;
    }
}