// Problem1 Search Rotated Sorted Array

public class RotatedSortedArray {

    class Solution {
        public int search(int[] nums, int target) {

            if (nums == null || nums.length == 0)
                return -1; // edge

            int low = 0;
            int high = nums.length - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (target == nums[mid]) {
                    return mid;
                } else if (nums[low] <= nums[mid]) { // left sorted

                    if (nums[low] <= target && nums[mid] > target) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }

                } else {
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
}
