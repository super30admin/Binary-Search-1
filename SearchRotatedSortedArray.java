public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[low] <= nums[mid]) { // left sorted array
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right sorted array
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }

        return -1;

    }
}

/**
 * Time Complexity: O(log N) - We divide the search space in half each iteration,
 * leveraging binary search to efficiently locate the target.
 * <p>
 * Space Complexity: O(1) - Only a few integer variables (low, high, mid) are used,
 * requiring constant space.
 */