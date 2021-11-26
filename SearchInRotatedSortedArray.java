class SearchInRotatedSortedArray {

    // Time Complexity : O(logmn)
    // Space Complexity :o(1)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : No

    public int search(int[] nums, int target) {
        // if the nums array is not instantiated and has no items in it.
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            // Check if the left array is sorted or not!
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // If left part of array is not sorted,
            // Check if the target we are looking is present in between mid +1 to high.
            // If it is in the range of mid+1 and high, change low value to mid + 1 and the
            // control goes to while loop and helps in checking.
            // if the looking target is not present in the range if right side, make high
            // point to mid - 1.

            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }

        }
        return -1;

    }
}