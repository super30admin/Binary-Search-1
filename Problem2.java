// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    //Once we find the mid we know that one part would be sorted either left of mid or right of mid
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[left]<=nums[mid])
            {
                if(target>=nums[left]&&target<nums[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }
            else
            {
                if(target>nums[mid]&&target<=nums[right])
                    left=mid+1;
                else
                    right=mid-1;
            }
        }

        return -1;
    }
}