// Time Complexity :
//		search() - O(log(n)
//      
// Space Complexity :
//		search() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        else if(nums.length == 1)
        {
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }
        else
        {
            int l = 0, h = nums.length-1;
            
            while(l <= h)
            {
                int m = l + (h-l)/2;
                
                if(nums[m] == target)
                    return m;
                else if(nums[l] <= nums[m]) //left sorted
                {
                    if(nums[l] <= target && nums[m] >= target)
                        h = m-1;
                    else
                        l = m+1;
                }
                else
                {
                    if(nums[m] <= target && nums[h] >= target)
                        l = m+1;
                    else
                        h = m-1;
                }
            }
            
            return -1;
        }
    }
}
