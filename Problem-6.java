// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Problem6 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[start]) {
                // this part of array is sorted, check if target lies with range [start <-> mid]
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    // it is not within above range
                    start = mid + 1;
                }
            } else {
                // this part of array is not sorted, check if target lies in range [mid <-> end]
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
