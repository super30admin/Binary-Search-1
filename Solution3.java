// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We check if the array is left sorted or right sorted. If left sorted, we check if target lies between the left sorted range and high is set to mid - 1, else low is set to mid + 1.
// Similarly if the array is right sorted, we check if the target lies in the range of right sorted array and set low to mid + 1, else high is set to mid - 1.


class Solution3 {
    public int search(int[] nums, int target) {
        int low = 0,high=nums.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[low]<=nums[mid])
            {
                if(nums[low]<=target && nums[mid]>target)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            {
                if(nums[mid]<target && target<=nums[high])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}