// Time Complexity : O(log n) where n is the number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only 
// Perform binary search on a rotated sorted array.Check if the left or right half is sorted and narrow search accordingly. Repeat until the target is found or search space is exhausted.
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Identify which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Target is in the left sorted portion
                } else {
                    left = mid + 1; // Target is in the right portion
                }
            } else {
                // Right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Target is in the right sorted portion
                } else {
                    right = mid - 1; // Target is in the left portion
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Index of 0: " + sol.search(nums, 0)); 
        System.out.println("Index of 3: " + sol.search(nums, 3)); 
    }
}