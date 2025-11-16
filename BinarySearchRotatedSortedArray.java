// Time complexity: O(log N) - reducing the elements by half in each iteration
// Space complexity: O(1) - no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class BinarySearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // avoiding int overflow
            if (nums[mid] == target) {
                // target found
                // return mid, which is its index
                return mid;
            }
            // at least one half will be sorted
            if (nums[low] <= nums[mid]) {
                // left array is sorted
                if (nums[low] <= target && target < nums[mid]) {
                    // target exists in the left sorted array
                    high = mid - 1;
                } else {
                    // move to the right half of the array
                    low = mid + 1;
                }
            } else {
                // right array is sorted
                if (nums[mid] < target && target <= nums[high]) {
                    // target exists in the right sorted array
                    low = mid + 1;
                } else {
                    // move to the left half of the array
                    high = mid - 1;
                }
            }
        }
        // target not found
        return -1;
    }
}