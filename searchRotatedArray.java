// Time Complexity : O(log(n)) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

//https://leetcode.com/problems/search-in-rotated-sorted-array/description/


class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[left]<=nums[mid])
            {
                if(target<nums[mid] && target>=nums[left])
                    right=mid-1;
                else
                    left=mid+1;
            }
            else
            {
                if(target<=nums[right] && target>nums[mid])
                    left=mid+1;
                else
                    right=mid-1;
            }
        }
        return -1;
        
    }
}

