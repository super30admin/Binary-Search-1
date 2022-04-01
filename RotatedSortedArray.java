// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class RotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[low] <= nums[mid]) { // left half is sorted
                
                if(nums[low] <= target && target < nums[mid]) { // exists in left half
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right half is sorted
                
                if(nums[mid] < target && target <= nums[high]) { // exists in right half
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}