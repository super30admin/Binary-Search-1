// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        // Use the Binary Search approach since we need to solve this in O(log N)
        // Even though the array is rotated we always know that one half will be always sorted
        while (left <= right) {
            // Identigy the mid
            int mid = left + (right - left)/2;

            //return is mid is the target
            if (nums[mid] == target) return mid;

            //check if left half is sorted
            if (nums[left] <= nums[mid]) {
                //check if the left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    //search left half
                    right = mid - 1;                
                } else {
                    // search right half
                    left = mid + 1;
                }
            } else {
                //check if the right half is sorted
                if (target <= nums[right] && target > nums[mid]) {
                    //search right half
                    left = mid + 1;
                } else {
                    //search left half
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}