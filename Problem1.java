// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Search in rotated sorted array
// - At each step, determines whether the left half or right half is sorted, then checks if the target lies within that sorted portion.
// - Narrows the search range accordingly and returns the target's index if found; otherwise returns -1.


class Problem2 {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + ((high - low) / 2);

            if(nums[mid] == target) {
                return mid;
            }
            if(nums[low] < nums[mid]) {
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}