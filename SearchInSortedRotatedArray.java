// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (https://leetcode.com/submissions/detail/568090078/)
// Any problem you faced while coding this :
public class SearchInSortedRotatedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == -1)
            return -1;

        int left = 0;
        int right = nums.length - 1;

        // Find the smallest element
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int start = left;
        left = 0;
        right = nums.length - 1;
        // determining whether we want to search right sub-array or left-subarray
        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
