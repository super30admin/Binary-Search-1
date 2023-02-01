// TC: O(logn)
// SC:O(
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int index = binarySearch(nums, target, 0, nums.length - 1);
        return index;
    }
    private int binarySearch(int[] nums, int target, int l, int r) {
        if(r < l) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if(nums[mid] == target) {
            return mid;
        }
        // left is sorted
        if(nums[l] <= nums[mid]) {
            if(target >= nums[l] && target <= nums[mid]) {
                return binarySearch(nums, target, l, mid);
            }
            return binarySearch(nums, target, mid + 1, r);
        }
        // right is sorted
        if(target >= nums[mid] && target <= nums[r]) {
            return binarySearch(nums, target, mid, r);
        }
        return binarySearch(nums, target, l, mid - 1);
    }
}