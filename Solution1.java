/** Time Complexity: O(log n)
* Space Complexity: O(1) [No extra space is used, only variables are used]
* Did this code successfully run on Leetcode : Yes
* Any problem you faced while coding this : No
* LeetCode Problem: Search in Rotated Sorted Array
* Approach:
* 1. Identify the sorted part of the array.
* 2. Identify if the target is within the sorted part or not if not move to the unsorted part.
* 3. Repeat the process until the target is found or the search space is exhausted.
* 4. Use binary search to find the target in the identified part of the array.
* Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
*/


class Solution1 {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;

        while (low<=high)
        {
            int mid= low+(high-low)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[low]<=nums[mid])
            {
                if(target>=nums[low]&& target<nums[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else if(nums[high]>=nums[mid])
            {
                if(target>nums[mid]&& target<=nums[high])
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