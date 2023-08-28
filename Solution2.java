// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Based on the property that a one half of a Rotated sorted array is always sorted and the other half is unsorted. I first check if middle element is equal to the target, if so I return the mid index. Else
 * if the array is left sorted, I check if target element lies in the range of nums[low]<=target<nums[mid] - if so set high = mid-1 for the next iteration .If not, set low = mid + 1. Similarly, if the
 * array is right sorted, I check if element lies in the range of nums[mid]<target<=nums[high]. If yes then I set low = mid+1 else I set high = mid-1 and continue to the next iteration.
 */

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
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
                if(nums[low]<=target && target<nums[mid])
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
            //right sorted array
            else
            {
                if(target>nums[mid] && target<=nums[high])
                {
                    low = mid+1;
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