// Time Complexity : O(log(n))
// Space Complexity : 0
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : had to try a few iterations to figure out how to move low and high pointers if the target is not in range

class SearchPivotedArray {
    public int search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            
            int mid = (low+high) / 2;
            
            // Return if element found
            
            if(nums[mid] == target) {
                return mid;
            }
            
            // If left array is sorted
            if(nums[low] <= nums[mid]) {
                // Check if target is in range
                if(target >= nums[low] && target <= nums[mid]) {
                    high = mid -1 ;
                } else {
                    low = mid + 1;
                }
            }
            //If right array is sorted
            else if(nums[mid] <= nums[high]) {
                // Check if target is in range
                if(target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid -1 ;
                }
            }
            
        }
            
        return -1;
    }
}