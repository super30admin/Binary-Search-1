// Time Complexity :O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/search-in-rotated-sorted-array/


class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0; 
        int high = nums.length -1; 

        while(low <= high) {
            int mid = low + (high-low) /2 ;

            if(nums[mid] == target) return mid;

            //left side is sorted
            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && nums[mid] >= target) {
                    high = mid -1;
                }
                else {
                    low = mid +1;
                }
            }
            //right side is sorted
            else if(nums[high] >= target && target >= nums[mid]) {
                low = mid +1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
}