// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * In this problem, 1 part of the array will always be sorted, with this in mind, alter the mid such that left part and right
 * part to the mid is sorted. we will apply binary search with following conditions: 1. nums[mid] == target, 2. if left array is
 * sorted, then check if target lies between low & mid. 3. If right array is sorted, then check if target lies between mid & high
 */


public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int low = 0, high = nums.length-1;

        while(low <= high) {

            int mid = low + (high-low)/2;

            if(nums[mid] == target) {
                return mid;
            }
            //left sorted
            else if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            //right sorted
            else {
                if(nums[mid] < target && nums[high] >=target) {
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
