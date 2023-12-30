//Leetcode problem : https://leetcode.com/problems/search-in-rotated-sorted-array/description/
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
        int start = 0, end = nums.length-1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(target==nums[mid])
            {
                return mid;
            }
            //LEFT SORTED
            else if(nums[start]<=nums[mid])
            {
                if(nums[start]<=target && target<nums[mid])
                {
                    end = mid-1;
                }
                else 
                {
                    start = mid+1;
                }
            }
            //RIGHT SORTED
            else 
            {
                if(nums[mid]<target && target<=nums[end])
                {
                    start = mid+1;
                }
                else 
                {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}