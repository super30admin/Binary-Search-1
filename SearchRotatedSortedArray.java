// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*The search for target element in a rotated sorted array can be optimized by choosing either side of a middle element.
The choice can be made by checking if the target lies in the ranges of low and mid or mid and high and moving the pointers accordingly.
*/

class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {

        int n = nums.length;

        // If array length is 0 then return -1
        if (n == 0) {
            return -1;
        }

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= target && nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }

}