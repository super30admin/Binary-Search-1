// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Based on the property of rotated sorted array - one half of a rotated sorted array is sorted.
 * I set low as 0 and high as nums.length-1 initially. I run a while loop until low is greater than high, in every iteration, I set mid as
 * low + (high-low)/2. If nums[mid]==target then I return mid, else I check if the which half of the array is sorted. If the left half
 * is sorted, I check if target lies in the left half, if so I set high = mid-1 else  I set low = mid+1. If the right half is sorted, I check 
 * if the target lies in the right half, if so I set low = mid+1 else I set high to mid-1.
 */
class Solution {
    public int search(int[] nums, int target) {
        int low = 0 , high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            //left sorted array
            else if(nums[low]<=nums[mid])
            {
                if(nums[low]<=target && target <nums[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            //right sorted array
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