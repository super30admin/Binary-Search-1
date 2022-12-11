// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[low] <= nums[mid]){
                // left side is sorted
                if(target >= nums[low] && target < nums[mid]){
                    // Is target falling within the ranges of this half
                    high = mid - 1;             
                }else{
                    // element lies in this half
                    low = mid + 1;
                }
            }
            else{
                // right side is sorted
                if(target > nums[mid] && target <= nums[high]){
                    // Is target falling within the ranges of this half
                    low = mid + 1;             
                }else{
                    // element lies in this half
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
