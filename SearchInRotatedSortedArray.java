// Search in rotated sorted array
// time complexity: O log (n)
// Space Complexity: O (1)

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] == target) {
                return mid;
            }

            // left array is sorted
            if (nums[low] <= nums[mid]) {
                // check if target is present in the sorted array
                if (target >= nums[low] && target < nums[mid]) {
                    // target is present in the left sorted array
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right is sorted
                // check if target is present in the sorted array
                if (target > nums[mid] && target <= nums[high]) {
                    // target is present in the right sorted array
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }
}