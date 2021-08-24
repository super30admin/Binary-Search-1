// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class rotatedSortedArray {
    public int search(int[] nums, int target) {
        // check if array is null or empty
        if (nums == null || nums.length == 0) return -1;
        // initialize low and high pointers
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid]){ // left sorted
                // Binary search on left sorted part
                if(nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right sorted
                // Binary search on right sorted part
                if(nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}