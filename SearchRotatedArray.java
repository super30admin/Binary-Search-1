// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
public class SearchRotatedArray {
    public int search(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[low] <= nums[mid]) {

                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                if (nums[high] >= target && nums[mid] < target) {
                    low = mid + 1;

                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }
}
