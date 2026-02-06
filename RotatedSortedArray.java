// Binary Search O(log n) time, O(1) space

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while (left <= right) {
            int mid = left + (right-left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[left] <= nums[mid]) { // left half sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else { // right half sorted (nums[mid] <= nums[right])
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}