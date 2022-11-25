import java.util.Objects;

/**
 * TC - O(log n)
 * SC - O(1)
 */
class RotatedSortedArraySearch {
    public int search(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) return -1;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // check if left is sorted
            if (nums[low] <= nums[mid]) {
                // check if target is in the range of low and mid
                if (nums[low] <= target && nums[mid] > target ) {
                    high = mid -1;
                } else {
                    low = mid + 1;
                }
            } else {    // if left part is not sorted then right part must be sorted
                // check if target is in the range of mid and high
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            }
        }

        return -1;

    }
}