public class Leetcode33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int n = nums.length;
        int l = 0;
        int h = n - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target)
                return mid;

            // case when left side is sorted
            if (nums[l] <= nums[mid]) {
                // to make sure that element lies between low and mid
                if (target >= nums[l] && target < nums[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }

            }
            // right side sorted:
            else {
                // to make sure that element lies between mid and high
                if (target > nums[mid] && target <= nums[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }
}

// TC: O(log n)
// space complexity: O(1)