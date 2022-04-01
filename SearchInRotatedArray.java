// Time complexity: O(log n) where n is number of elements of the input array.
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {      // Testing base case.
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {                         // Binary Search.
            int mid = low + (high - low) / 2;       // To prevent integer overflow.
            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid]) {       // Left subarray is sorted.
                if(nums[mid] > target && target >= nums[low]) {     // Target may be in left subarray. 
                    high = mid - 1;
                }
                else {                  // Target may be in right subarray.
                    low = mid + 1;
                }
            }
            else if(nums[mid] <= nums[high]) {      // Right subarray is sorted.
                if(nums[mid] < target && target <= nums[high]) {    // Target may be in right subarray.
                    low = mid + 1;  
                }
                else {                      // Target may be in left subarray.
                    high = mid - 1;
                }   
            }
        }
        return -1;      // Target not found.
    }
}