// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : picking the sorted half and rejecting the other half
/**
 * One-half is always sorted.
 * So check if the target lies in the sorted half
 * if yes, pick it
 * if no, pick the other half
 */
/**
 * TC: O(log n)
 * SC: O(1)
 */
public class SearchRotatedSortedArray {

    public SearchRotatedSortedArray() {

    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

}