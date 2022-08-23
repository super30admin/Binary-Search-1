// Time complexity: O(logn)
// Space complexity: O(1)

// Approach - we will use binary search. It is guaranteed that atleast one side of the pivot will be in sorted order. The approach is to first calculate the mid. Then check if left side is sorted by making sure l <= mid. If that is the case, we need to confirm if our target element is between l and mid. If not, we can element everything between l and mid and set l to mid + 1. If left side is not sorted, we can do the same kind of investigation in the right sorted list.

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int low = 0; int high = nums.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}