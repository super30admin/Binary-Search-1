/**
 * Implementing a Binary Search in a roated sorted array;
 * if left <= target < mid is true => search on left; update right;
      * else search on right; update left;
 * if mid < target <= right is true => Search on right; update left;
      * else  search on left; update right;
 * Time Complexity for put: O(log(n));
 * Space Complexity: O(n);
 * Successfully ran and submitted on LeetCode;
 */

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int n = nums.length;

        if (n == 1 && target != nums[n - 1]) {
            return -1;
        }

        if (n == 2 && target != nums[0] && target != nums[1]) {
            return -1;
        } else if (n == 2 && target == nums[0] && target != nums[1]) {
            return 0;
        } else if (n == 2 && target != nums[0] && target == nums[1]) {
            return 1;
        }

        if (n > 2) {
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (target == nums[mid]) {
                    return mid;
                }

                if ((target < nums[mid]) && (target >= nums[left])) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

                if ((target > nums[mid]) && (target <= nums[right])) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return (nums[left] == target) ? left : -1;

    }
}