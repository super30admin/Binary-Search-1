// Time Complexity : O(log n), the search space is reduced in half because of binary search
// Space Complexity : O(1), no additional space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int len = nums.length;

        if (len == 1) {
            return target == nums[0] ? 0 : -1;
        }


        int low = 0;
        int high = len - 1;

        while (low <= high) {
            // Divide the search in half by finding the mid element
            int mid = (low + high) / 2;
            if (target == nums[mid]) return mid;

            // Check if the right side of the mid is sorted and if the target is in the right side, else check in the left side
            if (nums[mid] <= nums[high]) {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    // Search in the left half of the array if arr[mid] < target < arr[high] doesnt hold true for the target
                    high = mid - 1;
                }
            } else {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }


        return -1;
    }
}
