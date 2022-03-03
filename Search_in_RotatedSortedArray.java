// Time Complexity : O(logn) as atleast one side of the array will be sorted which will reduce search space by half
// Space Complexity : O(1) ; no auxilary space needed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//CODE

public class Search_in_RotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) { // null case
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // avoiding integer overflow
            if (nums[mid] == target)
                return mid; // if value is mid is target ,then return mid
            else if (nums[low] <= nums[mid]) { // if the array is left sorted then search in the left part of the array
                                               // using binary search
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // searching in the right side of the array i.e. right side of array is sorted
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
