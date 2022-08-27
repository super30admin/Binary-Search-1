// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {

        // null check
        if ( nums.length == 0 || nums == null ) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1 ;

        while ( low <= high) {
            int mid = low + (high-low) / 2;
            if ( nums[mid] == target) {
                return mid;
            }
            else if ( nums[low] <= nums[mid] ) { // left sorted
                if ( nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else { // right sorted
                if ( target <= nums[high] && target > nums[mid] ) {
                    low = mid + 1 ;
                }else {
                    high = mid - 1 ;
                }
            }
        }
        return -1;
    }
}