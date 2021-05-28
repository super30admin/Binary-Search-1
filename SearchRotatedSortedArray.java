// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
// The basic idea is that one part of the array will be still sorted while the other will not be sorted.
// By comparing the mid wih high we can figure out which part is sorted and check if the target lies in that part
// if the target is present in the sorted part, continue with the Binary Search in that part or perform the Binary Search in the other part.
// Return -1 if the element is not found

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high) {
            int mid =  low + (high-low)/2;
            
            if(nums[mid] == target)
                return mid;
            
            if(nums[mid] < nums[high]) {
                if(nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                
                if(nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        
        return -1;
    }
}