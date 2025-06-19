// Time Complexity : O(log n) where n is the number of elements in the array
// Space Complexity : O(1) as nothing extra is created
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I used binary search to find the target in the rotated sorted array.
// When nums[left] <= nums[mid], it means the left half is sorted. Else the right half is sorted.
// When nums[left] <= target and target < nums[mid], it means the target is in the left half (between left and mid).
// If not, it means the target is in the right half (between mid and right).
// When nums[mid] < target and target <= nums[right], it means the target is in the right half (between mid and right).
// If not, it means the target is in the left half (between left and mid).

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
            else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1; 
    }
}
