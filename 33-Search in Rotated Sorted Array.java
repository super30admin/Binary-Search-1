//Time complexity=O(log N)
//Spacecomplexity=O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int mid;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[start]<=nums[mid])//We are checking whether we have increasing sub sequence or decreasing 
            {
            if(target<nums[mid] && target>=nums[start])
            {
                end=mid-1;
            }
                else
                    start=mid+1;
            }
            if(nums[end]>=nums[mid] )
            {
                if(target>nums[mid] && target<=nums[end])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return -1;
    }
}