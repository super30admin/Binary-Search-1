/**
 * Similar to Binary Search, keep adjusting mid in the [low..mid..high] ranges depending on which range target lies in
 * If element at index left is less than element at index mid, it means left..mid is sorted and thus adjust high or low according to simple binary search
 */

// Time Complexity: log(N)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Medium difficulty level feels much difficult

class Solution {
    public int search(int[] nums, int target) {
        return rotatedBinarySearch(nums, 0, nums.length - 1, target);
    }

    private int rotatedBinarySearch(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;                       // To avoid Integer overflow

            if (nums[mid] == target)                                // target found at mid
                return mid;

            if (nums[low] <= nums[mid]) {                           // [low..mid] is sorted
                if (target >= nums[low] && target <= nums[mid])     // target lies in range [low...mid-1]
                    high = mid - 1;
                else                                                // target lies in range [mid+1...high]
                    low = mid + 1;
            } else {                                                // [mid+1...high] is sorted
                if (target >= nums[mid + 1] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}