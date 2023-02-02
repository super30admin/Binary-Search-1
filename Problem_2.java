// 33. Search in Rotated Sorted Array
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// Even the sorted array is rotated, one side (either left or right) of mid will always be sorted. So will use modified binary serach.
// if our target is at mid then simple return the mid.
// if target is not at the mid then use the sorted part of the array to move left or right pointers by checking if the target is lying in sorted part of the array.

class Solution {
    public int search(int[] nums, int target) {
        int mid;
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;

            //if left array is sorted
            if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && nums[mid] >= target)
                    right = mid-1;
                else
                    left = mid+1;
            }

            //if right array is sorted
            else {
                if(nums[right] >= target && nums[mid] <= target)
                    left = mid+1;
                else
                    right = mid-1;
            }

        }
        return -1;
    }
}