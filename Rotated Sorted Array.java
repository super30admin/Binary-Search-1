// Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
public class rotatedSortedArray{
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int value = nums[mid];
            if (value == target)
                return mid;

            if (nums[start] <= value) {
                if (target >= nums[start] && target < value) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}