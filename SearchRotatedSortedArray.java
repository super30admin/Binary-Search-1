/**
 * @author Vishal Puri
 * // Time Complexity : O(logn)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this : No
 */

class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null && nums.length == 0) return -1;

        int l = 0;
        int r = nums.length - 1;

        //finding the minimum element in the array
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int start = l;
        l = 0;
        r = nums.length - 1;

        //finding the correct side of the array where the element must be present
        if (target >= nums[start] && target <= nums[r]) {
            l = start;
        } else {
            r = start;
        }

        //doing the binary search on the correct side of the pivot element
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else
                r = m - 1;
        }

        return -1;
    }
}