
/ Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;
        int left = 0, right = n - 1;

        // ✅ Step 1: Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // ✅ Case 1: If target is at mid → Return mid
            if (nums[mid] == target) {
                return mid;
            }

            // ✅ Step 2: Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1; // Search left side
                } else {
                    left = mid + 1; // Search right side
                }
            }

            // ✅ Step 3: If left half is not sorted, right half must be sorted
            else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1; // Search right side
                } else {
                    right = mid - 1; // Search left side
                }
            }
        }

        // ✅ Step 4: If target is not found → Return -1
        return -1;
    }

    // ✅ Main function to test the code
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        // ✅ Test case 1: Target exists
        int target = 0;
        int result = solution.search(nums, target);
        System.out.println("Index of " + target + " is " + result); // Output: 4

        // ✅ Test case 2: Target does not exist
        target = 3;
        result = solution.search(nums, target);
        System.out.println("Index of " + target + " is " + result); // Output: -1
    }
}
