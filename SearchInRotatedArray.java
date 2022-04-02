class Solution {

    // Time Complexity : 0(log N)
    // Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Here, assuming either the left or the right portion of
    //the array is sorted, so first we take the midpoint of the array and then compare which part of the array is sorted,
    //if the left part of the array is sorted, then we try to search the target value in the left part of the array
    //if not then we search for the target value in the right part of the array. If value is not found we return -1
    //If found we return the index.
    //Similarly if the right side of the array is sorted, then we repeat the above steps.

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //If left portion is sorted
            else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && nums[mid] >= target){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }

            }
            // If right portion is sorted
            else{
                if(nums[mid] <= target && nums[high] >= target){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}