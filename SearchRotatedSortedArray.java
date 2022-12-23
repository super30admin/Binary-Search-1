// Time Complexity  : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (https://leetcode.com/problems/search-in-rotated-sorted-array/)
// Any problem you faced while coding this : no

class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null && nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[low] <= nums[mid]) {             // Left sorted
                if(nums[low] <= target && target < nums[mid]) {
                    high = mid -1;
                } else {
                    low = mid + 1;
                }
            } else if(nums[mid] <= nums[high]) {          // Right sorted
                if(nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}