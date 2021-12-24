class Solution {
    // Time Complexity : O(log n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    //Approach - If the left part of the array is sorted and target lies in the left part, drop the right half, else drop the left half.
    //If the right part of the array is sorted and target lies in the right part, drop the left half, else drop the right half.
    //Repeat this till we find the target or return -1 if no target found.

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[low] <= nums[mid]) { //left side is monotonically increasing
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else { //right side is monotonically increasing
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}