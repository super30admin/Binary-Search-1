class Solution {
    public int search(int[] nums, int target) {
        
        int l=0;
        int h=nums.length-1;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(nums[m]==target)
                return m;
            if(nums[l]<=nums[m])
            {
                if(target>=nums[l] && target<nums[m])
                    h=m-1; 
                else
                    l=m+1;  
            }
            else{
                if(target <= nums[h] && nums[m]<target)
                    l=m+1;
                else
                    h=m-1;
                        
            }
        }
        return -1;
    }
}

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no