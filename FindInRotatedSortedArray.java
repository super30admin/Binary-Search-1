// Time Complexity : O(log n), binary search used
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Implements a binary search on a rotated sorted array to find the target element.
// First determine which half of the array is sorted and then decide whether to search in the left or right half.
//If the target lies within the sorted half, we update low and high accordingly and continue searching.
//If the element is not found, -1 is returned.
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        //If low and high crosses exit the loop and return -1
        while (low <= high){
            //find mid
            mid = low + (high - low)/2;
            // check if mid is the target and return mid
            if(nums[mid] == target){
                return mid;
            }
            // check if it is left sorted array
            if(nums[low] <= nums[mid]){
                // Check if the target is present in the left part
                if(nums[low] <= target && nums[mid] > target){
                    high = mid - 1;
                }
                else low = mid + 1;
            }else{ // right sorted array
                // Check if the target is present in the right part
                if(nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                }
                else high = mid -1;
            }
        }
        return -1;
    }
}