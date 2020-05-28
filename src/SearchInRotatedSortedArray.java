// Time Complexity : O(log n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No

// Your code here along with comments explaining your approach

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0) return -1;

        int low =0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target) return mid;

            if(nums[low] <= nums[mid]) { //left array is sorted
                if(target >= nums[low] && target < nums[mid]) { // target lies between left array
                    high = mid - 1;
                }else {
                    low = mid + 1; // target lies outside left sorted array
                }
            } else { // right array is sorted
                if(target > nums[mid] && target <= nums[high]) { //target lies between right sorted array
                    low = mid + 1;
                }else {
                    high = mid - 1; // target lies outside right sorted array
                }
            }
        }

        return -1;
    }
}