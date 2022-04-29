/*
 * One side is always sorted.
 * Find which side is sorted and check if element is in that range. If not increment pointer and do same in other side.
 */
// Time - O(log n)
// space - O(1)
class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) { //0,6
            int mid = low + (high - low) / 2; // 3
            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid]) { //4<7
                // left is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
